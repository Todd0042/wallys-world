package com.voicerpg.game.content

import com.voicerpg.engine.content.*

import com.voicerpg.engine.combat.MovesetTable
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class SpellContentTest {

    @Test
    fun testAllSpellsAndMovesetsAreValidAndResolvable() {
        val assetsDir = listOf(
            File("app/src/main/assets/game"),
            File("src/main/assets/game"),
            File("assets/game")
        ).firstOrNull { it.isDirectory }
        assertNotNull("Assets directory should be found", assetsDir)

        GameContent.reset()
        GameContent.initializeFromDirectory(assetsDir!!)
        val pack = GameContent.pack

        // 1. Verify global spells catalog
        assertTrue("Spells catalog should not be empty", pack.spells.isNotEmpty())
        for ((spellId, spell) in pack.spells) {
            assertTrue("Spell '$spellId' must have a non-blank name", spell.name.isNotBlank())
            assertTrue(
                "Spell '$spellId' base power or heal/mana/guard/status/cleanse must be valid",
                spell.basePower > 0 || spell.isHeal || spell.manaRestorePct > 0f || spell.isGuard || spell.status != null || spell.cleansesDebuffs
            )
            assertNotNull("Spell '$spellId' must have graphics defined", spell.graphics)
            val gfx = spell.graphics!!
            assertTrue("Spell '$spellId' effectType must not be blank", gfx.effectType.isNotBlank())
            assertTrue("Spell '$spellId' particle count must be >= 0", gfx.particleCount >= 0)
            assertTrue("Spell '$spellId' screen shake must be >= 0f", gfx.screenShake >= 0f)
        }

        // 2. Verify character profiles with combat loadouts have embedded spells
        val charactersWithCombat = pack.characters.values.filter { it.combat != null && it.combat.spells.isNotEmpty() }
        assertTrue("There should be playable characters with combat loadouts", charactersWithCombat.isNotEmpty())
        for (character in charactersWithCombat) {
            val spells = character.combat!!.spells
            assertTrue("Character '${character.id}' must have at least one embedded spell", spells.isNotEmpty())
            for (spell in spells) {
                assertTrue("Character '${character.id}' spell '${spell.id}' must have a non-blank name", spell.name.isNotBlank())
                assertNotNull("Character '${character.id}' spell '${spell.id}' must have graphics defined", spell.graphics)
                val gfx = spell.graphics!!
                assertTrue("Character '${character.id}' spell '${spell.id}' effectType must not be blank", gfx.effectType.isNotBlank())
            }
        }

        // 3. Verify enemy movesets in enemy_spells.json
        assertTrue("Enemy movesets catalog should not be empty", pack.enemyMovesets.isNotEmpty())
        for ((movesetId, moveset) in pack.enemyMovesets) {
            assertTrue("Moveset '$movesetId' must contain moves", moveset.moves.isNotEmpty())
            for (move in moveset.moves) {
                assertTrue("Moveset '$movesetId' move '${move.name}' must have a non-blank name", move.name.isNotBlank())
                assertTrue("Moveset '$movesetId' move '${move.name}' must have non-negative power multiplier", move.powerMult >= 0f)
                assertNotNull("Moveset '$movesetId' move '${move.name}' must have graphics defined", move.graphics)
                val gfx = move.graphics!!
                assertTrue("Moveset '$movesetId' move '${move.name}' effectType must not be blank", gfx.effectType.isNotBlank())
                assertTrue("Moveset '$movesetId' move '${move.name}' particle count must be >= 0", gfx.particleCount >= 0)
                assertTrue("Moveset '$movesetId' move '${move.name}' screen shake must be >= 0f", gfx.screenShake >= 0f)
            }
        }

        // 4. Verify all enemy templates with explicit movesetId have resolvable movesets
        assertTrue("Enemy templates catalog should not be empty", pack.enemyTemplates.isNotEmpty())
        for ((templateId, template) in pack.enemyTemplates) {
            if (template.movesetId.isNotBlank()) {
                val moveset = GameContent.movesetById(template.movesetId) ?: MovesetTable.movesetFor(template.movesetId)
                assertNotNull(
                    "Enemy template '$templateId' movesetId '${template.movesetId}' must resolve",
                    moveset
                )
                assertTrue(
                    "Enemy template '$templateId' moveset '${template.movesetId}' must have moves",
                    moveset?.moves?.isNotEmpty() == true
                )
            }
        }
    }

    @Test
    fun testAllSpellChantPresetsAcrossAllResonanceTiers() {
        val assetsDir = listOf(
            File("app/src/main/assets/game"),
            File("src/main/assets/game"),
            File("assets/game")
        ).firstOrNull { it.isDirectory }
        assertNotNull("Assets directory should be found", assetsDir)

        GameContent.reset()
        GameContent.initializeFromDirectory(assetsDir!!)
        val allSpells = GameContent.spells.values.distinctBy { it.id }

        val resonanceEngine = com.voicerpg.engine.engine.ResonanceEngine()
        val tiers = listOf(
            com.voicerpg.engine.model.ResonanceTier.BASIC,
            com.voicerpg.engine.model.ResonanceTier.ADEPT,
            com.voicerpg.engine.model.ResonanceTier.MASTER,
            com.voicerpg.engine.model.ResonanceTier.MYTHIC,
            com.voicerpg.engine.model.ResonanceTier.TRANSCENDENTAL
        )

        for (spell in allSpells) {
            for (expectedTier in tiers) {
                val preset = com.voicerpg.engine.engine.SpellChantPresets.getPreset(spell, expectedTier)
                val result = resonanceEngine.evaluate(
                    utterance = preset.chantText,
                    school = spell.school,
                    acousticProfile = preset.acousticProfile,
                    ignoreNoveltyDecay = true
                )

                val tierMessage = "Spell '${spell.id}' with preset tier $expectedTier failed: got ${result.tier} with ${result.bonusPercent}%"
                org.junit.Assert.assertEquals(tierMessage, expectedTier, result.tier)

                if (expectedTier == com.voicerpg.engine.model.ResonanceTier.TRANSCENDENTAL) {
                    assertTrue(
                        "Transcendental tier for ${spell.id} should hit maximum 200% bonus (got ${result.bonusPercent}%)",
                        result.bonusPercent == 200
                    )
                    assertTrue(
                        "Damage multiplier should hit 3.0x (got ${result.damageMultiplier}x)",
                        result.damageMultiplier == 3.0f
                    )
                }
            }
        }
    }
}
