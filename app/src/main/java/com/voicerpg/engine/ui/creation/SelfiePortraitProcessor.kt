package com.voicerpg.engine.ui.creation

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Shader
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions
import com.google.mlkit.vision.face.FaceLandmark
import com.google.mlkit.vision.segmentation.Segmentation
import com.google.mlkit.vision.segmentation.selfie.SelfieSegmenterOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.nio.ByteBuffer
import kotlin.coroutines.resume
import kotlin.math.hypot
import kotlin.math.min

object SelfiePortraitProcessor {

    const val PORTRAIT_SIZE = 512
    const val CUSTOM_PORTRAIT_FILENAME = "custom_hero_portrait.jpg"

    val AVAILABLE_BACKGROUNDS = listOf(
        "Trench" to "environments/trench.jpg",
        "Break Room" to "environments/break_room.jpg",
        "Sales Floor" to "environments/sales_floor.jpg",
        "Service Bay" to "environments/service_bay.jpg",
        "Overnight Lot" to "environments/parking_lot.jpg"
    )

    fun loadFromUri(context: Context, uri: android.net.Uri): Bitmap? {
        return try {
            val raw = context.contentResolver.openInputStream(uri)?.use {
                BitmapFactory.decodeStream(it)
            } ?: return null

            val orientation = try {
                context.contentResolver.openInputStream(uri)?.use { stream ->
                    val exif = android.media.ExifInterface(stream)
                    exif.getAttributeInt(
                        android.media.ExifInterface.TAG_ORIENTATION,
                        android.media.ExifInterface.ORIENTATION_NORMAL
                    )
                } ?: android.media.ExifInterface.ORIENTATION_NORMAL
            } catch (_: Exception) {
                android.media.ExifInterface.ORIENTATION_NORMAL
            }

            val matrix = android.graphics.Matrix()
            when (orientation) {
                android.media.ExifInterface.ORIENTATION_ROTATE_90 -> matrix.postRotate(90f)
                android.media.ExifInterface.ORIENTATION_ROTATE_180 -> matrix.postRotate(180f)
                android.media.ExifInterface.ORIENTATION_ROTATE_270 -> matrix.postRotate(270f)
                android.media.ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> matrix.preScale(-1.0f, 1.0f)
                android.media.ExifInterface.ORIENTATION_FLIP_VERTICAL -> matrix.preScale(1.0f, -1.0f)
                else -> return raw
            }
            Bitmap.createBitmap(raw, 0, 0, raw.width, raw.height, matrix, true)
        } catch (_: Exception) {
            null
        }
    }

    suspend fun processSelfie(
        context: Context,
        inputBitmap: Bitmap,
        retailBgAsset: String = "environments/trench.jpg",
        applySegmentation: Boolean = true,
        applyRaccoonEyes: Boolean = true,
        applyScanlines: Boolean = true,
        applyFluorescentGrading: Boolean = true
    ): Bitmap = withContext(Dispatchers.Default) {
        // 1. Center crop and scale to square 512x512
        val squareInput = cropAndScale(inputBitmap, PORTRAIT_SIZE)

        // 2. AI Background Segmentation & Retail Background Replacement
        val composited = if (applySegmentation) {
            val maskBuffer = runSegmentation(squareInput)
            val retailBg = loadAssetBitmap(context, retailBgAsset, PORTRAIT_SIZE)
            compositeWithBackground(squareInput, retailBg, maskBuffer)
        } else {
            squareInput
        }

        // 3. Raccoon Eyes (Overnight shift exhaustion shading under eye orbits)
        val withExhaustion = if (applyRaccoonEyes) {
            applyExhaustionEyeBags(composited)
        } else {
            composited
        }

        // 4. CRT Scanlines & Harsh Fluorescent Color Grading
        val finalResult = applyFilters(
            withExhaustion,
            applyScanlines = applyScanlines,
            applyFluorescent = applyFluorescentGrading
        )

        finalResult
    }

    fun saveCustomPortrait(context: Context, bitmap: Bitmap): File {
        val destFile = File(context.filesDir, CUSTOM_PORTRAIT_FILENAME)
        FileOutputStream(destFile).use { out ->
            bitmap.compress(Bitmap.CompressFormat.JPEG, 92, out)
        }
        return destFile
    }

    fun getCustomPortraitFile(context: Context): File? {
        val f = File(context.filesDir, CUSTOM_PORTRAIT_FILENAME)
        return if (f.exists()) f else null
    }

    fun deleteCustomPortrait(context: Context): Boolean {
        val f = File(context.filesDir, CUSTOM_PORTRAIT_FILENAME)
        return if (f.exists()) f.delete() else false
    }

    private fun cropAndScale(src: Bitmap, targetSize: Int): Bitmap {
        val minDim = min(src.width, src.height)
        val xOffset = (src.width - minDim) / 2
        val yOffset = (src.height - minDim) / 2
        val cropped = Bitmap.createBitmap(src, xOffset, yOffset, minDim, minDim)
        return if (cropped.width != targetSize || cropped.height != targetSize) {
            Bitmap.createScaledBitmap(cropped, targetSize, targetSize, true)
        } else {
            cropped
        }
    }

    private fun loadAssetBitmap(context: Context, assetPath: String, targetSize: Int): Bitmap? = try {
        context.assets.open(assetPath).use { stream ->
            val raw = BitmapFactory.decodeStream(stream)
            if (raw != null) cropAndScale(raw, targetSize) else null
        }
    } catch (_: Exception) {
        null
    }

    private suspend fun runSegmentation(bitmap: Bitmap): ByteBuffer? =
        suspendCancellableCoroutine { cont ->
            try {
                val options = SelfieSegmenterOptions.Builder()
                    .setDetectorMode(SelfieSegmenterOptions.SINGLE_IMAGE_MODE)
                    .build()
                val segmenter = Segmentation.getClient(options)
                val inputImage = InputImage.fromBitmap(bitmap, 0)
                segmenter.process(inputImage)
                    .addOnSuccessListener { mask ->
                        cont.resume(mask.buffer)
                    }
                    .addOnFailureListener {
                        cont.resume(null)
                    }
            } catch (_: Exception) {
                cont.resume(null)
            }
        }

    private fun compositeWithBackground(
        subject: Bitmap,
        background: Bitmap?,
        maskBuffer: ByteBuffer?
    ): Bitmap {
        if (background == null || maskBuffer == null) return subject

        val w = subject.width
        val h = subject.height
        val totalPixels = w * h

        val subjectPixels = IntArray(totalPixels)
        val bgPixels = IntArray(totalPixels)
        val outPixels = IntArray(totalPixels)

        subject.getPixels(subjectPixels, 0, w, 0, 0, w, h)
        background.getPixels(bgPixels, 0, w, 0, 0, w, h)

        maskBuffer.rewind()

        for (i in 0 until totalPixels) {
            val confidence = if (maskBuffer.hasRemaining()) maskBuffer.float else 1f
            // Smooth threshold curve
            val alpha = confidence.coerceIn(0f, 1f)

            val sCol = subjectPixels[i]
            val bCol = bgPixels[i]

            val r = (Color.red(sCol) * alpha + Color.red(bCol) * (1f - alpha)).toInt()
            val g = (Color.green(sCol) * alpha + Color.green(bCol) * (1f - alpha)).toInt()
            val b = (Color.blue(sCol) * alpha + Color.blue(bCol) * (1f - alpha)).toInt()

            outPixels[i] = Color.rgb(r, g, b)
        }

        val result = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        result.setPixels(outPixels, 0, w, 0, 0, w, h)
        return result
    }

    private suspend fun applyExhaustionEyeBags(source: Bitmap): Bitmap =
        suspendCancellableCoroutine { cont ->
            try {
                val options = FaceDetectorOptions.Builder()
                    .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                    .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
                    .build()
                val detector = FaceDetection.getClient(options)
                val inputImage = InputImage.fromBitmap(source, 0)

                detector.process(inputImage)
                    .addOnSuccessListener { faces ->
                        if (faces.isEmpty()) {
                            cont.resume(source)
                            return@addOnSuccessListener
                        }

                        val result = source.copy(Bitmap.Config.ARGB_8888, true)
                        val canvas = Canvas(result)

                        for (face in faces) {
                            val leftEye = face.getLandmark(FaceLandmark.LEFT_EYE)?.position
                            val rightEye = face.getLandmark(FaceLandmark.RIGHT_EYE)?.position

                            if (leftEye != null && rightEye != null) {
                                val dx = rightEye.x - leftEye.x
                                val dy = rightEye.y - leftEye.y
                                val eyeDist = hypot(dx.toDouble(), dy.toDouble()).toFloat()

                                val radius = eyeDist * 0.28f
                                val darkCenterColor = Color.argb(135, 45, 25, 42) // Bruised purple-slate
                                val transparentColor = Color.argb(0, 45, 25, 42)

                                // Left eye bag (placed right below the eye)
                                drawEyeBag(canvas, leftEye.x, leftEye.y + radius * 0.55f, radius, darkCenterColor, transparentColor)

                                // Right eye bag
                                drawEyeBag(canvas, rightEye.x, rightEye.y + radius * 0.55f, radius, darkCenterColor, transparentColor)
                            }
                        }
                        cont.resume(result)
                    }
                    .addOnFailureListener {
                        cont.resume(source)
                    }
            } catch (_: Exception) {
                cont.resume(source)
            }
        }

    private fun drawEyeBag(
        canvas: Canvas,
        cx: Float,
        cy: Float,
        radius: Float,
        centerColor: Int,
        edgeColor: Int
    ) {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            shader = RadialGradient(
                cx, cy, radius,
                centerColor, edgeColor,
                Shader.TileMode.CLAMP
            )
        }
        val oval = RectF(
            cx - radius * 1.15f,
            cy - radius * 0.55f,
            cx + radius * 1.15f,
            cy + radius * 0.75f
        )
        canvas.drawOval(oval, paint)
    }

    private fun applyFilters(
        source: Bitmap,
        applyScanlines: Boolean,
        applyFluorescent: Boolean
    ): Bitmap {
        val w = source.width
        val h = source.height
        val result = source.copy(Bitmap.Config.ARGB_8888, true)
        val canvas = Canvas(result)

        // 1. Cold 3 AM Fluorescent Color Grade
        if (applyFluorescent) {
            val filterPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                val matrix = ColorMatrix(
                    floatArrayOf(
                        0.92f, 0.00f, 0.00f, 0.0f, -5f,   // Red desaturated
                        0.00f, 1.05f, 0.00f, 0.0f, +8f,   // Green slightly boosted (fluorescent ballast)
                        0.00f, 0.00f, 1.08f, 0.0f, +12f,  // Blue/Cyan boosted (cold store lighting)
                        0.00f, 0.00f, 0.00f, 1.0f, 0f     // Alpha
                    )
                )
                colorFilter = ColorMatrixColorFilter(matrix)
            }
            canvas.drawBitmap(source, 0f, 0f, filterPaint)
        }

        // 2. CRT Scanlines
        if (applyScanlines) {
            val scanlinePaint = Paint().apply {
                color = Color.argb(32, 0, 0, 0)
                strokeWidth = 1.8f
            }
            var y = 0f
            while (y < h) {
                canvas.drawLine(0f, y, w.toFloat(), y, scanlinePaint)
                y += 3.8f
            }
        }

        // 3. Subtle Vignette
        val vignettePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            val gradient = RadialGradient(
                w / 2f, h / 2f, w * 0.7f,
                Color.TRANSPARENT,
                Color.argb(85, 10, 12, 18),
                Shader.TileMode.CLAMP
            )
            shader = gradient
        }
        canvas.drawRect(0f, 0f, w.toFloat(), h.toFloat(), vignettePaint)

        return result
    }
}
