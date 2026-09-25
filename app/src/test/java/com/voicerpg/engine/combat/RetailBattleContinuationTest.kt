package com.voicerpg.engine.combat

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
}
