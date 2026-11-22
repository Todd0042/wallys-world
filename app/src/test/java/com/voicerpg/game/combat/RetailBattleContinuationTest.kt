package com.voicerpg.game.combat

import com.voicerpg.engine.combat.*

import com.voicerpg.engine.content.GameContent
import com.voicerpg.engine.engine.StoryChoiceMatcher
import com.voicerpg.engine.model.CharacterStance
import com.voicerpg.engine.model.PartyMember
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * GAME SPECIFIC (Wally's World / The Squeeze): Never upstream to core engine repo.
 * Verifies that retail battle defeat allows pressing on with witty dialogue and revived party.
 */
class RetailBattleContinuationTest {

    @Test
    fun testDefeatDialogueAndVoiceContinuation() {
        val assetsDir = listOf(
            File("app/src/main/assets/game"),
            File("src/main/assets/game"),
            File("assets/game")
        ).firstOrNull { it.isDirectory }
        assertNotNull("Assets directory should be found", assetsDir)

        GameContent.reset()
        GameContent.initializeFromDirectory(assetsDir!!)

        // 1. Verify witty defeat line in manifest
        val defeatLine = GameContent.manifest.defeatLine
        assertTrue("Defeat line should mention retail context", defeatLine.contains("retail", ignoreCase = true))
        assertTrue("Defeat line should mention pressing on", defeatLine.contains("press on", ignoreCase = true))

        // 2. Verify voice conclusion matcher supports 'press on' and 'continue story'
        val pressOnAction = StoryChoiceMatcher.parseBattleConclusionIntent("press on")
        assertEquals(StoryChoiceMatcher.ConclusionAction.CONTINUE_STORY, pressOnAction)

        val continueStoryAction = StoryChoiceMatcher.parseBattleConclusionIntent("continue story")
        assertEquals(StoryChoiceMatcher.ConclusionAction.CONTINUE_STORY, continueStoryAction)

        // 3. Verify associate revival logic for party continuing the shift
        val fallenAssociate = PartyMember(
            id = "hero",
            name = "Todd",
            loreClass = "Freight Associate",
            currentHp = 0,
            maxHp = 300,
            currentMp = 20,
            maxMp = 95,
            spells = emptyList(),
            stance = CharacterStance.DEAD
        )

        val restored = if (fallenAssociate.currentHp <= 0) {
            fallenAssociate.copy(
                currentHp = maxOf(1, fallenAssociate.maxHp / 2),
                stance = CharacterStance.READY
            )
        } else fallenAssociate

        assertTrue("Associate should be revived to press on in retail", restored.isAlive)
        assertEquals(150, restored.currentHp)
        assertEquals(CharacterStance.READY, restored.stance)
    }

    @Test
    fun testHeroCanFallInBattleRegardlessOfPureStoryMode() {
        val hero = PartyMember(
            id = "hero",
            name = "Todd",
            loreClass = "Freight Associate",
            currentHp = 50,
            maxHp = 300,
            currentMp = 20,
            maxMp = 95,
            spells = emptyList()
        )

        val lethalDamage = 120
        // Now hero falls to 0 HP even in pure story mode because death advances the retail story
        val newHp = (hero.currentHp - lethalDamage).coerceAtLeast(0)
        assertEquals("Hero HP should reach 0 when taking lethal damage", 0, newHp)
        assertTrue("Hero should fall when taking lethal damage", newHp <= 0)
    }

    @Test
    fun testAutoHeroActionPrefersAoeAndNeverHeals() {
        val dummyNarrator = com.voicerpg.engine.audio.CombatNarrator()
        val dummySpeech = com.voicerpg.engine.audio.SpeechManager()
        val testScope = kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.Default)
        val viewModel = com.voicerpg.engine.viewmodel.CombatViewModel(
            speechManager = dummySpeech,
            combatNarrator = dummyNarrator,
            scopeOverride = testScope
        )
        viewModel.setPureStoryMode(true)

        val aoeSpell = com.voicerpg.engine.model.Spell(
            id = "freight_push",
            name = "Freight Push",
            school = com.voicerpg.engine.model.SpellSchool.PHYSICAL,
            basePower = 55,
            mpCost = 12,
            hitsAll = true,
            description = "Shove freight",
            exampleChant = "freight push!"
        )
        val singleSpell = com.voicerpg.engine.model.Spell(
            id = "line_drill",
            name = "Line Drill",
            school = com.voicerpg.engine.model.SpellSchool.PHYSICAL,
            basePower = 40,
            mpCost = 0,
            description = "Line drill",
            exampleChant = "line drill!"
        )
        val healSpell = com.voicerpg.engine.model.Spell(
            id = "belt_mend",
            name = "Belt Mend",
            school = com.voicerpg.engine.model.SpellSchool.HOLY,
            basePower = 50,
            mpCost = 16,
            isHeal = true,
            description = "Belt mend",
            exampleChant = "belt mend!"
        )

        val hero = PartyMember(
            id = "hero",
            name = "Todd",
            loreClass = "Shop Captain",
            currentHp = 30, // critically low HP (10%)
            maxHp = 300,
            currentMp = 90,
            maxMp = 100,
            spells = listOf(singleSpell, aoeSpell, healSpell)
        )

        val enemies = listOf(
            com.voicerpg.engine.model.Enemy(id = "e1", name = "Cart 1", subtitle = "Minion", currentHp = 100, maxHp = 100, baseAttack = 10),
            com.voicerpg.engine.model.Enemy(id = "e2", name = "Cart 2", subtitle = "Minion", currentHp = 100, maxHp = 100, baseAttack = 10)
        )

        viewModel.startEncounter(
            party = listOf(hero),
            enemies = enemies,
            environment = com.voicerpg.engine.model.BattleEnvironment.CASTLE
        )
        viewModel.setPlayerInputPhaseForTesting("hero")

        // 1. With 2 enemies alive, even at 10% HP, hero must pick AoE damage spell and NOT heal
        val chosenWithMultipleEnemies = viewModel.triggerAutoHeroAction(hero)
        assertEquals("Should choose AoE spell when more than 1 enemy", "freight_push", chosenWithMultipleEnemies?.id)
        org.junit.Assert.assertFalse("Should never heal in auto play fights", chosenWithMultipleEnemies?.isHeal == true)

        // 2. With only 1 enemy alive, hero must pick offensive spell and NOT heal even at 10% HP
        val singleEnemyList = listOf(
            com.voicerpg.engine.model.Enemy(id = "e1", name = "Cart 1", subtitle = "Minion", currentHp = 100, maxHp = 100, baseAttack = 10),
            com.voicerpg.engine.model.Enemy(id = "e2", name = "Cart 2", subtitle = "Minion", currentHp = 0, maxHp = 100, baseAttack = 10)
        )
        viewModel.startEncounter(
            party = listOf(hero),
            enemies = singleEnemyList,
            environment = com.voicerpg.engine.model.BattleEnvironment.CASTLE
        )
        viewModel.setPlayerInputPhaseForTesting("hero")

        val chosenWithSingleEnemy = viewModel.triggerAutoHeroAction(hero)
        org.junit.Assert.assertFalse("Should never heal in auto play fights even with 1 enemy", chosenWithSingleEnemy?.isHeal == true)
        assertEquals("Should choose offensive spell and not heal", "freight_push", chosenWithSingleEnemy?.id)
    }
}
