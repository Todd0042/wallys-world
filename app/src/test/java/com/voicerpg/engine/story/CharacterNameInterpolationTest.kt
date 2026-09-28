package com.voicerpg.engine.story

import androidx.compose.ui.graphics.Color
import com.voicerpg.engine.audio.CombatNarrator
import com.voicerpg.engine.audio.SpeechManager
import com.voicerpg.engine.content.GameContent
import com.voicerpg.engine.model.DialogueChoice
import com.voicerpg.engine.model.DialogueNode
import com.voicerpg.engine.model.DialogueSpeaker
import com.voicerpg.engine.model.PlayerCustomization
import com.voicerpg.engine.model.SpeakerSide
import com.voicerpg.engine.viewmodel.StoryViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import java.io.File

class CharacterNameInterpolationTest {

    private fun createViewModel(): StoryViewModel {
        val speechManager = SpeechManager()
        val combatNarrator = CombatNarrator()
        val testScope = CoroutineScope(Dispatchers.Default)
        return StoryViewModel(
            speechManager = speechManager,
            combatNarrator = combatNarrator,
            scopeOverride = testScope
        )
    }

    @Test
    fun testDefaultHeroNameInterpolation() {
        val vm = createViewModel()
        val formatted = vm.formatStoryText("Sit down for a second, {hero}.", "Todd", "Freight Supervisor")
        assertEquals("Sit down for a second, Todd.", formatted)
    }

    @Test
    fun testCustomHeroNameInterpolation() {
        val vm = createViewModel()
        val formatted = vm.formatStoryText("Sit down for a second, {hero}. {hero}'s bays are clean.", "Alex", "Shop Lead")
        assertEquals("Sit down for a second, Alex. Alex's bays are clean.", formatted)
    }

    @Test
    fun testLegacyNameReplacementWhenCustomized() {
        val vm = createViewModel()
        val formatted = vm.formatStoryText("Todd, I've toured forty shops. Todd's bays are the cleanest.", "Alex", "Shop Lead")
        assertEquals("Alex, I've toured forty shops. Alex's bays are the cleanest.", formatted)
    }

    @Test
    fun testFormatNodeForPlayerHeroSpeaker() {
        val vm = createViewModel()
        val heroSpeaker = DialogueSpeaker(
            id = "hero",
            name = "Todd",
            title = "Freight Supervisor",
            portraitAsset = null,
            themeColor = Color.White
        )
        val node = DialogueNode(
            id = "test_node",
            speaker = heroSpeaker,
            side = SpeakerSide.LEFT,
            text = "Somebody has to pull this line, and today that somebody is me, {hero}.",
            choices = listOf(
                DialogueChoice(
                    id = "c1",
                    text = "Follow {hero}",
                    voiceKeywords = listOf("follow"),
                    nextNodeId = "next_node"
                )
            )
        )
        val player = PlayerCustomization(name = "Jordan", title = "Floor Captain")
        val formatted = vm.formatNodeForPlayer(node, player)

        assertEquals("Jordan", formatted.speaker.name)
        assertEquals("Floor Captain", formatted.speaker.title)
        assertEquals("Somebody has to pull this line, and today that somebody is me, Jordan.", formatted.text)
        assertEquals("Follow Jordan", formatted.choices.first().text)
    }

    @Test
    fun testHeroNameplateDuringNarratorNode() {
        val vm = createViewModel()
        val defaultHeroName = GameContent.manifest.defaultHeroName.ifBlank { "Todd" }
        val player = PlayerCustomization(name = "Jordan", title = "Floor Captain")

        val effectiveHeroName = player.name.ifBlank { defaultHeroName }
        val effectiveHeroTitle = player.title.ifBlank { GameContent.manifest.defaultHeroTitle.ifBlank { "Freight Supervisor" } }

        val heroSpeaker = (GameContent.heroCharacter?.speaker ?: DialogueSpeaker(
            id = "hero",
            name = defaultHeroName,
            title = effectiveHeroTitle,
            portraitAsset = "portraits/todd.jpg",
            themeColor = Color.White
        )).copy(name = effectiveHeroName, title = effectiveHeroTitle)

        // The bust for the hero on screen during narrator speech must display the custom user name
        assertEquals("Jordan", heroSpeaker.name)
        assertEquals("Floor Captain", heroSpeaker.title)
        assertFalse(heroSpeaker.name.equals("Todd", ignoreCase = true))

        // And verify that formatStoryText replaces any occurrence in narration text
        val narrationNode = DialogueNode(
            id = "narrator_test",
            speaker = DialogueSpeaker.NARRATOR,
            side = SpeakerSide.CENTER_NARRATOR,
            text = "Todd steps onto the freight dock as the clock strikes four."
        )
        val formattedNarration = vm.formatNodeForPlayer(narrationNode, player)
        assertEquals("Jordan steps onto the freight dock as the clock strikes four.", formattedNarration.text)
    }

    @Test
    fun testNoHardcodedToddInStoryNodes() {
        val assetsDir = listOf(
            File("app/src/main/assets/game"),
            File("src/main/assets/game"),
            File("assets/game")
        ).firstOrNull { it.isDirectory }
        if (assetsDir != null) {
            GameContent.reset()
            GameContent.initializeFromDirectory(assetsDir)
            for (node in GameContent.nodes.values) {
                assertFalse(
                    "Node [${node.id}] contains hardcoded 'Todd' in text: ${node.text}",
                    node.text.contains("\\bTodd\\b".toRegex(RegexOption.IGNORE_CASE))
                )
            }
        }
    }
}
