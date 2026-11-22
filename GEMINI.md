<!-- voicerpg-engine-rule:start -->
# VoiceRPG Engine Rule (installed by voice-rpg-engine; do not edit in the game)

This game runs on the shared **VoiceRPG engine** (`../voice-rpg-engine`, next to this repo). The same
engine code runs in every VoiceRPG game: echoes-of-logos, wallys-world, commander-america-rpg,
superstore-saga.

## The engine is read-only in this repo
These paths are exact copies of the engine and are listed in `.engine-sync/OWNED_PATHS`:
- `app/src/main/java/com/voicerpg/engine/**` (all engine code, including `MainActivity.kt`)
- `app/src/main/assets/game/commands/**` and `app/src/main/assets/game/localization/**`
- `app/src/test/java/com/voicerpg/engine/**` (engine tests) and `app/src/test/fixtures/template-pack/**`

**Do not edit, add or delete files there.** A pre-commit hook and the game's CI
(`.engine-sync/guard.sh`) reject any change that doesn't match the synced engine version, and
editing `.engine-sync/` by hand is detected too. Do not use `--no-verify`.

## What belongs in this repo
- Game content: `app/src/main/assets/game/**` (except `commands/` and `localization/`), plus portraits,
  story art, environments and audio under `app/src/main/assets/`.
- App identity: `applicationId`, app name, icon and other resources in `app/build.gradle.kts` and `app/src/main/res/`.
- Game-specific tests: `app/src/test/java/com/voicerpg/game/**`.

## When the game needs something the engine can't do
1. Make the change in `../voice-rpg-engine`, **content-neutral**: no names, story, spells or assets
   from any game in engine code. Per-game behaviour is a JSON field with a default that leaves the
   other games unchanged.
2. In the engine: `./gradlew testDebugUnitTest`, then `./scripts/test_content_packs.sh` (runs the
   engine tests against every game's content), then commit.
3. `./scripts/sync_engine_to_games.sh --verify` sends it to every game. Commit the sync in each game.

An engine test failing on this game's content means either the content breaks an engine contract
(fix the content) or the test assumes template data (fix the test in the engine, e.g. with
`TemplateFixture`). Never change or delete an engine test inside a game.
<!-- voicerpg-engine-rule:end -->

# VoiceRPG Engine: Agent Guidelines & Engineering Rules

# VoiceRPG Engine: Agent Guidelines & Engineering Rules

This repository is the **standalone, reusable engine** for voice-commanded JRPGs on Android (Kotlin, Jetpack Compose, Android Speech & TTS APIs). All game content has been stripped out and replaced with **drop-in JSON templates** under `app/src/main/assets/game/`. When working on this codebase, adhere strictly to the rules below.

---

## 1. Content Neutrality (THE core rule)

- **Engine code never references game content.** `app/src/main` must not hardcode character names, story chapters, spell names, dialogue, encounters, or art/music filenames. The completed game (`echoes-of-logos` / *Echoes of the Logos*) is a **separate repo and must never be reintroduced here**.
- All content lives in `app/src/main/assets/game/**` as JSON, loaded at runtime by `GameContent`:
  - `manifest.json` (title, starting scene/node, default encounter, victory/defeat lines)
  - `characters/*.json`, `classes/*.json`, `spells/spells.json`
  - `enemies/enemies.json`, `encounters/encounters.json`
  - `story/scenes.json`, `story/nodes.json`
- Bundled art/music referenced by those JSON files live under `app/src/main/assets/{portraits,story,audio,sprites}`.
- New game content = **JSON + assets only**. If a change requires touching `app/src/main`, it must be a genuinely generic engine improvement, not content.

## 2. Tests Are Content-Agnostic Guarantees

The unit suite (`./gradlew testDebugUnitTest`) must stay **green with any drop-in content**. Two test flavors are required:

1. **Schema/invariant tests** that iterate `GameContent` and assert engine-contract invariants (every node link resolves, no dead-ends except `game_completed`, every choice has a `voiceKeyword`, every battle trigger resolves to an encounter, flag names are non-blank, hub `requiredFlags` resolve, scene entries resolve, full reachability).
2. **Engine-mechanics tests** that exercise behavior on whatever the template data is (resonance calibration, tutorial flow, combat economy, voice resolution, save/persistence).

Never write a test that asserts a specific story/person/place. The template story ("Proving Grounds", "Echo Hall", the Guardian) is a **fixture**, and only tests the state machine's mechanics, not the fiction.

## 3. Story Graph Conventions (engine contract)

- **No endless loops:** hub choices set a `completionFlag`, completed choices are eliminated on return, and a hub whose sub-stories are all complete auto-redirects via `hubCompletion.requiredFlags` + `hubCompletion.redirectToNodeId`.
- **No dead ends:** every node must continue via `nextNodeId`, `choices`, `hubCompletion`, or a battle trigger (`triggerBattleEncounterId` + `nextNodeId`). The **only** terminal node is one that sets `game_completed`.
- Scenes bind background + music + entry node; `chapterIndex`/`actNumber`/milestone fields feed the recap and chapter-warp menu — nothing hardcoded.

## 4. Resonance Calibration Invariant

- `SpellChantPresets` builds generic per-tier chants from any spell name; `AcousticProfile` constants per tier are fixed.
- The engine's thematic matcher (root lexicon in `SpellThesaurus`) must cover each spell's name with **exactly one** root word. Zero-root names are unreachable at TRANSCENDENTAL; two-root names overflow BASIC. Keep the lexicon per-school and generic; `testAllSpellChantPresetsAcrossAllResonanceTiers` guards this for the whole spell catalog.
- **Resonance is sacred:** it is the only skill multiplier (1.0x–3.0x). Affinity and stats may never exceed or replace it.

## 5. ViewModel Tests: The Settle Pattern (livelock guard)

Driving `StoryViewModel`/`TutorialBattleViewModel`/`CombatViewModel` in tests that rapidly cancel + relaunch animation jobs on the same event loop can livelock kotlinx-coroutines' `LockFreeLinkedList.finishAdd` and hang the suite for minutes. Follow the pattern in `TutorialBattleTest`: advance state, then **wait for a ref/state change and settle** (small `delay` loop) before the next step. Never `advance()` in a hot loop without a settle.

## 6. Voice & Audio-First (retained engine pillars)

- All dialogue and combat actions must be operable hands-free: TTS narration, `Read choices`, meta-commands ("Status", "Enemies", "Options", "Pocket mode", "Auto listen", "Toggle narration"), and auto-listen re-arm after TTS.
- Bind distinct physical TTS voices per character via `android.speech.tts.Voice`; characters declare `preferredVoiceId` (fallback: pitch/rate modulation). Only characters with a non-null `preferredVoiceId` appear in `GameContent.preferredVoiceIds` / `CombatNarrator.PREFERRED_VOICE_IDS`.

## 7. Verification Before Any Commit

- Always run the full unit suite: `./gradlew testDebugUnitTest` (must be clean).
- Compilation of engine code: `./gradlew compileDebugKotlin` (must be clean).