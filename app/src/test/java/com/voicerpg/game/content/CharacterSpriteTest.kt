package com.voicerpg.game.content

import com.voicerpg.engine.content.*

import com.voicerpg.engine.ui.sprites.PixelSpriteData
import com.voicerpg.engine.ui.sprites.SpriteFrame
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class CharacterSpriteTest {

    @Test
    fun testAllCharactersHaveValidGendersAndEmbeddedSprites() {
        val assetsDir = listOf(
            File("app/src/main/assets/game"),
            File("src/main/assets/game"),
            File("assets/game")
        ).firstOrNull { it.isDirectory }
        assertNotNull("Assets directory should be found", assetsDir)

        GameContent.reset()
        GameContent.initializeFromDirectory(assetsDir!!)
        val pack = GameContent.pack

        assertTrue("Characters catalog should not be empty", pack.characters.isNotEmpty())

        for ((id, character) in pack.characters) {
            assertNotNull("Character '$id' should have a non-null gender", character.gender)
            assertTrue("Character '$id' gender should not be blank", character.gender!!.isNotBlank())

            val sprite = character.sprite
            assertNotNull("Character '$id' should have an embedded sprite definition", sprite)
            assertTrue("Character '$id' sprite palette should not be empty", sprite!!.palette.isNotEmpty())

            for (frame in SpriteFrame.values()) {
                val matrix = sprite.getFrame(frame)
                assertEquals("Character '$id' frame $frame must have exactly 26 lines", 26, matrix.size)
                for ((lineIdx, line) in matrix.withIndex()) {
                    assertEquals(
                        "Character '$id' frame $frame line $lineIdx must have exactly 20 characters",
                        20,
                        line.length
                    )
                    for (char in line) {
                        assertTrue(
                            "Character '$id' frame $frame uses unmapped char '$char'",
                            sprite.palette.containsKey(char)
                        )
                    }
                }
            }

            // Test runtime resolution through PixelSpriteData
            val (resolvedMatrix, resolvedPalette) = PixelSpriteData.getPixelMatrix(id, SpriteFrame.IDLE_UPRIGHT)
            assertEquals("Resolved matrix for '$id' must have 26 lines", 26, resolvedMatrix.size)
            assertTrue("Resolved palette for '$id' must not be empty", resolvedPalette.isNotEmpty())
        }
    }
}
