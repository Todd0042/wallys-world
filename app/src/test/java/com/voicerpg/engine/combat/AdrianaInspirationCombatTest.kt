package com.voicerpg.engine.combat

import com.voicerpg.engine.audio.SpeechManager
import com.voicerpg.engine.content.GameContent
import com.voicerpg.engine.model.CombatPhase
import com.voicerpg.engine.model.Enemy
import com.voicerpg.engine.model.PartyMember
import com.voicerpg.engine.viewmodel.CombatState
import com.voicerpg.engine.viewmodel.CombatViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
class AdrianaInspirationCombatTest {

    @Before
    fun setup() {
        val assetsDir = listOf(
            File("app/src/main/assets/game"),
            File("src/main/assets/game"),
            File("assets/game")
        ).firstOrNull { it.isDirectory }
        assertNotNull("Assets directory should be found", assetsDir)
        GameContent.reset()
        GameContent.initializeFromDirectory(assetsDir!!)
    }

    @Test
    fun testAdrianaInspirationProfileInvariants() {
        val adriana = GameContent.characterById("adriana_inspiration")
        assertNotNull("Adriana's Inspiration character should exist", adriana)
        val combat = adriana!!.combat
        assertNotNull("Combat stats should exist", combat)

        // ATB / Speed invariant: gauge fills very slowly so she acts only a few times per fight
        assertEquals("Adriana's speed must be very slow (12)", 12, combat!!.speed)
        assertTrue("Adriana's starting ATB must be very low (<= 0.10)", combat.startAtb <= 0.10f)
        assertTrue("Adriana must be an ethereal support ghost", combat.isGhost)
        assertFalse("Adriana must not be able to direct-attack", combat.canAttack)
        assertEquals("Adriana should have spriteAlpha configured for translucency", 0.45f, combat.spriteAlpha ?: 0f, 0.01f)

        // Spells invariant: strictly no attack spells, only a heal and debuff removal
        val spells = combat.spells
        assertEquals("Adriana should strictly have 2 spells (heal + cleanse)", 2, spells.size)

        val healSpell = spells.firstOrNull { it.id == "the_backrub" }
        assertNotNull("Must have the_backrub", healSpell)
        assertTrue("the_backrub must be a heal spell", healSpell!!.isHeal)
        assertTrue("the_backrub must have positive healing power", healSpell.basePower > 0)

        val cleanseSpell = spells.firstOrNull { it.id == "inspiring_words" }
        assertNotNull("Must have inspiring_words", cleanseSpell)
        assertTrue("inspiring_words must cleanse debuffs", cleanseSpell!!.cleansesDebuffs || cleanseSpell.isCleanse)
        assertEquals("inspiring_words base power should be 0 (no attack)", 0, cleanseSpell.basePower)
        assertFalse("inspiring_words must not be an attack spell", cleanseSpell.basePower > 0)
    }

    @Test
    fun testAutoPlayChoosesCleanseWhenAllyHasDebuffs() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        val testScope = TestScope(testDispatcher)

        val vm = CombatViewModel(
            speechManager = SpeechManager(),
            scopeOverride = testScope
        )

        val adrianaChar = GameContent.characterById("adriana_inspiration")!!
        val adrianaMember = PartyMember(
            id = "adriana_inspiration",
            name = "Adriana's Inspiration",
            loreClass = "Spiritual Anchor",
            currentHp = 1,
            maxHp = 1,
            currentMp = 999,
            maxMp = 999,
            spells = adrianaChar.combat!!.spells,
            isGhost = true,
            canAttack = false,
            speed = 12,
            atbGauge = 1.0f
        )

        val debuffedTodd = PartyMember(
            id = "hero",
            name = "Todd",
            loreClass = "Freight Associate",
            currentHp = 250,
            maxHp = 300,
            currentMp = 50,
            maxMp = 100,
            spells = emptyList(),
            statuses = listOf(
                StatusInstance(
                    status = StatusId.POISON,
                    turnsLeft = 3,
                    potPct = 0.1f
                )
            )
        )

        val dummyEnemy = Enemy(
            id = "enemy_1",
            name = "Freight Wall",
            subtitle = "Cardboard Nemesis",
            currentHp = 200,
            maxHp = 200,
            baseAttack = 10
        )

        vm.setCombatStateForTesting(
            CombatState(
                phase = CombatPhase.PLAYER_INPUT,
                activePartyMemberId = adrianaMember.id,
                party = listOf(debuffedTodd, adrianaMember),
                enemies = listOf(dummyEnemy)
            )
        )

        val chosen = vm.triggerAutoHeroAction(adrianaMember)
        assertNotNull("Auto play must pick an action for Adriana", chosen)
        assertEquals("Auto play should prioritize debuff cleanse when an ally is debuffed", "inspiring_words", chosen!!.id)
    }

    @Test
    fun testAutoPlayChoosesHealWhenAllyIsDamaged() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        val testScope = TestScope(testDispatcher)

        val vm = CombatViewModel(
            speechManager = SpeechManager(),
            scopeOverride = testScope
        )

        val adrianaChar = GameContent.characterById("adriana_inspiration")!!
        val adrianaMember = PartyMember(
            id = "adriana_inspiration",
            name = "Adriana's Inspiration",
            loreClass = "Spiritual Anchor",
            currentHp = 1,
            maxHp = 1,
            currentMp = 999,
            maxMp = 999,
            spells = adrianaChar.combat!!.spells,
            isGhost = true,
            canAttack = false,
            speed = 12,
            atbGauge = 1.0f
        )

        val woundedTodd = PartyMember(
            id = "hero",
            name = "Todd",
            loreClass = "Freight Associate",
            currentHp = 100,
            maxHp = 300,
            currentMp = 50,
            maxMp = 100,
            spells = emptyList(),
            statuses = emptyList() // No debuffs, just wounded
        )

        val dummyEnemy = Enemy(
            id = "enemy_1",
            name = "Freight Wall",
            subtitle = "Cardboard Nemesis",
            currentHp = 200,
            maxHp = 200,
            baseAttack = 10
        )

        vm.setCombatStateForTesting(
            CombatState(
                phase = CombatPhase.PLAYER_INPUT,
                activePartyMemberId = adrianaMember.id,
                party = listOf(woundedTodd, adrianaMember),
                enemies = listOf(dummyEnemy)
            )
        )

        val chosen = vm.triggerAutoHeroAction(adrianaMember)
        assertNotNull("Auto play must pick an action for Adriana", chosen)
        assertEquals("Auto play should pick heal spell when ally is wounded", "the_backrub", chosen!!.id)
    }

    @Test
    fun testSupportSpellOnAllyDoesNotTriggerOutOfTurnError() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        val testScope = TestScope(testDispatcher)

        val vm = CombatViewModel(
            speechManager = SpeechManager(),
            scopeOverride = testScope
        )

        val adrianaChar = GameContent.characterById("adriana_inspiration")!!
        val adrianaMember = PartyMember(
            id = "adriana_inspiration",
            name = "Adriana's Inspiration",
            loreClass = "Spiritual Anchor",
            currentHp = 1,
            maxHp = 1,
            currentMp = 999,
            maxMp = 999,
            spells = adrianaChar.combat!!.spells,
            isGhost = true,
            canAttack = false,
            speed = 12,
            atbGauge = 1.0f
        )

        val todd = PartyMember(
            id = "hero",
            name = "Todd",
            loreClass = "Freight Associate",
            currentHp = 120,
            maxHp = 300,
            currentMp = 50,
            maxMp = 100,
            spells = emptyList(),
            atbGauge = 0.2f // Todd is NOT ready yet
        )

        val dummyEnemy = Enemy(
            id = "enemy_1",
            name = "Freight Wall",
            subtitle = "Cardboard Nemesis",
            currentHp = 200,
            maxHp = 200,
            baseAttack = 10
        )

        vm.setCombatStateForTesting(
            CombatState(
                phase = CombatPhase.PLAYER_INPUT,
                activePartyMemberId = adrianaMember.id,
                party = listOf(todd, adrianaMember),
                enemies = listOf(dummyEnemy)
            )
        )

        // Adriana casts The Backrub on Todd while Todd's ATB is charging
        vm.submitTypedChant("the backrub todd")
        testScheduler.advanceTimeBy(300)

        // Phase should transition to resolving / casting, NOT stay stuck in PLAYER_INPUT with an out-of-turn lockout
        assertFalse(
            "Chanting 'the backrub todd' during Adriana's turn must not be locked out as an out-of-turn hero error",
            vm.state.value.phase == CombatPhase.PLAYER_INPUT && vm.state.value.floatingTexts.any { it.text.contains("charging") }
        )
    }
}
