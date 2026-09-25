package com.voicerpg.engine.content

import com.voicerpg.engine.combat.AffinityTable
import com.voicerpg.engine.combat.EnemyFamily
import com.voicerpg.engine.combat.School
import com.voicerpg.engine.combat.StatusCatalogTable
import com.voicerpg.engine.engine.SpellThesaurus
import com.voicerpg.engine.model.SpellSchool
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class EngineDecoupledAssetsTest {

    private fun loadPack(): GameContentPack {
        val assetsDir = listOf(
            File("app/src/main/assets/game"),
            File("src/main/assets/game"),
            File("assets/game")
        ).firstOrNull { it.isDirectory }
        assertNotNull("Assets directory should be found", assetsDir)
        GameContent.reset()
        GameContent.initializeFromDirectory(assetsDir!!)
        return GameContent.pack
    }

    @Test
    fun testManifestExtendedFields() {
        val pack = loadPack()
        val manifest = pack.manifest

        assertTrue("worldName must not be blank", manifest.worldName.isNotBlank())
        assertTrue("defaultHeroName must not be blank", manifest.defaultHeroName.isNotBlank())
        assertTrue("defaultHeroTitle must not be blank", manifest.defaultHeroTitle.isNotBlank())
        assertTrue("quickNames must have entries", manifest.quickNames.isNotEmpty())
        assertTrue("characterTitles must have entries", manifest.characterTitles.isNotEmpty())
        assertTrue("creationEmbarkPrompt must not be blank", manifest.creationEmbarkPrompt.isNotBlank())
        assertTrue("creationVoiceKeywords must have entries", manifest.creationVoiceKeywords.isNotEmpty())
    }

    @Test
    fun testEnvironmentsLoadedAndImageAssetsExist() {
        val pack = loadPack()
        assertTrue("Environments must not be empty", pack.environments.isNotEmpty())

        val rootAssets = listOf(
            File("app/src/main/assets"),
            File("src/main/assets"),
            File("assets")
        ).firstOrNull { it.isDirectory }
        assertNotNull("Root assets directory should be found", rootAssets)

        for ((id, env) in pack.environments) {
            assertEquals(id, env.id)
            assertTrue("displayName must not be blank for $id", env.displayName.isNotBlank())
            assertTrue("backgroundAsset must not be blank for $id", env.backgroundAsset.isNotBlank())

            // Verify landscape background asset exists on disk
            val landscapeFile = File(rootAssets, env.backgroundAsset)
            assertTrue("Landscape asset '${env.backgroundAsset}' must exist on disk", landscapeFile.exists())

            // Verify portrait background asset exists on disk (_p variant)
            val dotIdx = env.backgroundAsset.lastIndexOf('.')
            val portraitPath = env.backgroundAsset.substring(0, dotIdx) + "_p" + env.backgroundAsset.substring(dotIdx)
            val portraitFile = File(rootAssets, portraitPath)
            assertTrue("Portrait asset '$portraitPath' must exist on disk", portraitFile.exists())
        }

        // Test alias resolution
        val trenchByAlias = GameContent.environmentById("dungeon")
        assertNotNull("Environment should resolve by alias 'dungeon'", trenchByAlias)
        assertEquals("trench", trenchByAlias?.id)

        val salesFloorByAlias = GameContent.environmentById("castle")
        assertNotNull("Environment should resolve by alias 'castle'", salesFloorByAlias)
        assertEquals("sales_floor", salesFloorByAlias?.id)
    }

    @Test
    fun testStatusCatalogDecoupled() {
        val pack = loadPack()
        assertTrue("Status catalog must not be empty", pack.statusCatalog.isNotEmpty())

        // Test StatusCatalogTable delegation
        assertTrue("StatusCatalogTable.DEFS should contain BURN", StatusCatalogTable.DEFS.containsKey("BURN"))
        val burnDef = StatusCatalogTable.DEFS["BURN"]!!
        assertEquals("DOT", burnDef.kind)
        assertTrue("BURN must have tiers", burnDef.tiers.isNotEmpty())
        assertEquals(1, burnDef.tiers["BASIC"]?.turns)
    }

    @Test
    fun testAffinityMatrixDecoupled() {
        val pack = loadPack()
        val affinity = pack.affinityMatrix
        assertNotNull("AffinityMatrix must be loaded", affinity)

        val pyromancyFlesh = AffinityTable.affinity(School.PYROMANCY, EnemyFamily.FLESH)
        assertEquals(1.2f, pyromancyFlesh, 0.001f)

        val line = AffinityTable.narrationLine(School.PYROMANCY, "Freight Wall", 1.5f)
        assertNotNull("Narration line should be generated", line)
        assertTrue("Narration line must contain enemy name", line!!.contains("Freight Wall"))
        assertTrue("Narration line must contain school name", line.contains("pyromancy"))
    }

    @Test
    fun testThesaurusDecoupled() {
        val pack = loadPack()
        assertTrue("Thesaurus roots should be loaded", pack.thesaurusRoots.isNotEmpty())

        val pyroRoots = SpellThesaurus.getKeywordsForSchool(SpellSchool.PYROMANCY)
        assertTrue("Pyro roots should contain 'heat'", pyroRoots.contains("heat"))

        val matches = SpellThesaurus.findMatches("feel the heat of the fire", SpellSchool.PYROMANCY)
        assertTrue("Matches should contain 'heat'", matches.contains("heat"))
    }

    @Test
    fun testEncountersEnvironmentId() {
        val pack = loadPack()
        assertTrue("Encounters must not be empty", pack.encounters.isNotEmpty())
        for ((_, enc) in pack.encounters) {
            assertTrue("Encounter '${enc.id}' must have an environmentId", enc.environmentId.isNotBlank())
        }
    }
}
