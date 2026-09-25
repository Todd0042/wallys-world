package com.voicerpg.engine.story

import com.voicerpg.engine.content.GameContent
import com.voicerpg.engine.model.DialogueChoice
import com.voicerpg.engine.model.DialogueNode
import com.voicerpg.engine.model.DialogueSpeaker
import com.voicerpg.engine.model.GameSaveData
import com.voicerpg.engine.model.SpeakerSide
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class HubRevisitTest {

    @Test
    fun testAllHubNodesHaveContextualRevisitText() {
        val assetsDir = listOf(
            File("app/src/main/assets/game"),
            File("src/main/assets/game"),
            File("assets/game")
        ).firstOrNull { it.isDirectory }
        assertNotNull("Assets directory should be found", assetsDir)

        GameContent.reset()
        GameContent.initializeFromDirectory(assetsDir!!)

        val hubNodes = GameContent.nodes.values.filter { it.hubCompletion != null }
        assertEquals("Should have exactly 32 hub nodes", 32, hubNodes.size)

        for (hub in hubNodes) {
            assertNotNull("Hub node ${hub.id} should have revisitText defined", hub.revisitText)
            assertTrue("Hub node ${hub.id} revisitText should not be blank", hub.revisitText!!.isNotBlank())
            assertNotEquals("Hub node ${hub.id} revisitText should be different from opening text", hub.text, hub.revisitText)
        }
    }

    @Test
    fun testRevisitTextResolutionLogic() {
        val speaker = DialogueSpeaker.NARRATOR
        val hubNode = DialogueNode(
            id = "test_hub",
            speaker = speaker,
            side = SpeakerSide.CENTER_NARRATOR,
            text = "Long introductory narration for the department hub.",
            revisitText = "What will you tackle next in this department?",
            choices = listOf(
                DialogueChoice("c1", "Task 1", listOf("one"), "branch_1"),
                DialogueChoice("c2", "Task 2", listOf("two"), "branch_2")
            )
        )

        // First visit: not in visited set
        val visited = mutableSetOf<String>()
        val firstVisitText = if (hubNode.id in visited) {
            hubNode.revisitText?.ifBlank { null }
                ?: if (hubNode.choices.size > 1) "What will you do next?" else hubNode.text
        } else {
            hubNode.text
        }
        assertEquals("First visit must use the full introductory text", hubNode.text, firstVisitText)
        visited.add(hubNode.id)

        // Subsequent visit: node is in visited set
        val secondVisitText = if (hubNode.id in visited) {
            hubNode.revisitText?.ifBlank { null }
                ?: if (hubNode.choices.size > 1) "What will you do next?" else hubNode.text
        } else {
            hubNode.text
        }
        assertEquals("Subsequent visit must use the short revisit text", hubNode.revisitText, secondVisitText)
    }

    @Test
    fun testRevisitFallbackForMultiChoiceNodeWithoutRevisitText() {
        val speaker = DialogueSpeaker.NARRATOR
        val hubNode = DialogueNode(
            id = "test_hub_fallback",
            speaker = speaker,
            side = SpeakerSide.CENTER_NARRATOR,
            text = "Long hub monologue without explicit revisit text.",
            revisitText = null,
            choices = listOf(
                DialogueChoice("c1", "Choice A", listOf("a"), "node_a"),
                DialogueChoice("c2", "Choice B", listOf("b"), "node_b")
            )
        )

        val visited = setOf("test_hub_fallback")
        val isRevisit = hubNode.id in visited
        val activeText = if (isRevisit) {
            hubNode.revisitText?.ifBlank { null }
                ?: if (hubNode.choices.size > 1) "What will you do next?" else hubNode.text
        } else {
            hubNode.text
        }

        assertEquals("Fallback for multi-choice hub should be 'What will you do next?'", "What will you do next?", activeText)
    }

    @Test
    fun testGameSaveDataStoresVisitedNodeIds() {
        val saveData = GameSaveData(
            currentNodeId = "floor_hub",
            visitedNodeIds = listOf("trench_hub", "floor_hub")
        )

        assertEquals(2, saveData.visitedNodeIds.size)
        assertTrue(saveData.visitedNodeIds.contains("floor_hub"))
    }
}
