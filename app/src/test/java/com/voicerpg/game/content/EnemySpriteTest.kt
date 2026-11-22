package com.voicerpg.game.content

import com.voicerpg.engine.content.*

import com.voicerpg.engine.ui.sprites.PixelSpriteData
import com.voicerpg.engine.ui.sprites.SpriteFrame
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class EnemySpriteTest {

    @Test
    fun testAllEnemySpritesAreValidAndResolvable() {
        val assetsDir = listOf(
            File("app/src/main/assets/game"),
            File("src/main/assets/game"),
            File("assets/game")
        ).firstOrNull { it.isDirectory }
        assertNotNull("Assets directory should be found", assetsDir)

        GameContent.reset()
        GameContent.initializeFromDirectory(assetsDir!!)
        val pack = GameContent.pack

        assertTrue("Enemy sprites catalog should not be empty", pack.enemySprites.isNotEmpty())

        // 1. Verify all enemy sprites in catalog have valid frames & palettes
        for ((spriteId, sprite) in pack.enemySprites) {
            assertTrue("Sprite '$spriteId' palette should not be empty", sprite.palette.isNotEmpty())
            assertTrue("Sprite '$spriteId' palette should contain '.'", sprite.palette.containsKey('.'))
            assertTrue("Sprite '$spriteId' palette should contain 'K'", sprite.palette.containsKey('K'))

            for (frame in SpriteFrame.values()) {
                val matrix = sprite.getFrame(frame)
                assertEquals("Sprite '$spriteId' frame $frame must have exactly 26 lines", 26, matrix.size)
                for ((lineIdx, line) in matrix.withIndex()) {
                    assertEquals(
                        "Sprite '$spriteId' frame $frame line $lineIdx must have exactly 20 characters",
                        20,
                        line.length
                    )
                    for (char in line) {
                        assertTrue(
                            "Sprite '$spriteId' frame $frame uses unmapped palette char '$char' on line $lineIdx",
                            sprite.palette.containsKey(char)
                        )
                    }
                }
            }

            // Test runtime resolution through PixelSpriteData
            val (resolvedMatrix, resolvedPalette) = PixelSpriteData.getPixelMatrix(spriteId, SpriteFrame.IDLE_UPRIGHT)
            assertEquals("Resolved matrix for '$spriteId' must have 26 lines", 26, resolvedMatrix.size)
            assertTrue("Resolved palette for '$spriteId' must not be empty", resolvedPalette.isNotEmpty())
        }

        // 2. Verify all enemy templates have valid spriteIds defined in enemy_sprites.json
        assertTrue("Enemy templates catalog should not be empty", pack.enemyTemplates.isNotEmpty())
        for ((templateId, template) in pack.enemyTemplates) {
            assertTrue("Enemy template '$templateId' spriteId should not be blank", template.spriteId.isNotBlank())
            assertNotNull(
                "Enemy template '$templateId' spriteId '${template.spriteId}' should resolve in enemySprites",
                pack.enemySpriteById(template.spriteId)
            )

            // Test resolution through PixelSpriteData using templateId
            val (templateMatrix, templatePalette) = PixelSpriteData.getPixelMatrix(templateId, SpriteFrame.IDLE_UPRIGHT)
            assertEquals("Resolved matrix for template '$templateId' must have 26 lines", 26, templateMatrix.size)
            assertTrue("Resolved palette for template '$templateId' must not be empty", templatePalette.isNotEmpty())
        }

        // 3. Verify all encounters have enemies with resolvable sprites
        assertTrue("Encounters catalog should not be empty", pack.encounters.isNotEmpty())
        for ((encounterId, encounter) in pack.encounters) {
            for (enemy in encounter.enemies) {
                val effectiveSpriteId = enemy.spriteId.ifBlank { enemy.id }
                val (enemyMatrix, enemyPalette) = PixelSpriteData.getPixelMatrix(effectiveSpriteId, SpriteFrame.IDLE_UPRIGHT)
                assertEquals("Resolved matrix for encounter '$encounterId' enemy '${enemy.id}' must have 26 lines", 26, enemyMatrix.size)
                assertTrue("Resolved palette for encounter '$encounterId' enemy '${enemy.id}' must not be empty", enemyPalette.isNotEmpty())
            }
        }
    }
}
