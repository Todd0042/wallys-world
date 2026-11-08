<p align="center">
  <a href="https://ko-fi.com/todd0042">
    <img src="https://raw.githubusercontent.com/Todd0042/creator-assets/main/banners/todd_creator_banner_v1.0.png" alt="Support Todd on Ko-fi" width="100%" />
  </a>
</p>

---

# 🛒 Wally's World: Retail Survival Voice JRPG

[![Version](https://img.shields.io/badge/Version-1.22.0-ff2a85.svg)](https://github.com/Todd0042/wallys-world/releases)
[![License: PolyForm Noncommercial](https://img.shields.io/badge/License-PolyForm%20Noncommercial%201.0.0-00f0ff.svg)](LICENSE)
[![Platform: Android 8.0+](https://img.shields.io/badge/Platform-Android%208.0%2B%20(API%2026%2B)-3DDC84.svg?logo=android&logoColor=white)](https://developer.android.com)
[![16 KB Page Size](https://img.shields.io/badge/16%20KB-Compatible-success.svg)](https://developer.android.com/16kb-page-size)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-7F52FF.svg?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![UI: Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose%202024.10.01-4285F4.svg?logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Unit Tests](https://img.shields.io/badge/Unit%20Tests-Passing-39ff14.svg)](app/src/test/java/com/voicerpg/engine/)
[![Engine: VoiceRPG](https://img.shields.io/badge/Engine-VoiceRPG%20v2.0.0-teal.svg)](https://github.com/Todd0042/voice-rpg-engine)
[![Support on Ko-fi](https://img.shields.io/badge/Ko--fi-Support%20Creator-F16061?style=flat&logo=ko-fi&logoColor=white)](https://ko-fi.com/todd0042)

> **A comedic workplace survival voice JRPG for Android where hands-free incantations, tactical retail ATB combat, and real-life retail absurdities collide — featuring streamlined Associate Badge registration, Adriana party allies, and 100% screenless Pocket Mode for your commute.**

```
       _________________________________________________________________________
      |  STORE MANAGER CHAD                         HP [████████████░░░]  82%   |
      |  "Who authorized overtime on aisle 4?!"     MP [███████████████] 100%   |
      |_________________________________________________________________________|
      |  ASSOCIATE: "By the employee handbook, breakroom breather now!"         |
      |  RESONANCE: MYTHIC (132%) >>> MORALE RESTORED TO FULL ALLY FLANK!      |
      |_________________________________________________________________________|
```

---

## 📖 Table of Contents

* **Part 1 — Consumer Overview & Quick Start**
  * [🛒 What Is Wally's World?](#-what-is-wallys-world)
  * [⏰ How a Shift Works in 3 Steps](#-how-a-shift-works-in-3-steps)
  * [🪪 Associate Badge Registration & Custom Vest Tints](#-associate-badge-registration--custom-vest-tints)
  * [📦 The 6-Act Retail Survival Saga & Adriana Allies](#-the-6-act-retail-survival-saga--adriana-allies)
  * [🚶 Pure Story Mode & Screenless Commute Pocket Mode](#-pure-story-mode--screenless-commute-pocket-mode)
  * [🚀 Quick Download & Installation (Android APK)](#-quick-download--installation-android-apk)
* **Part 2 — Technical Architecture & Engine Integration**
  * [1. Powered by VoiceRPG Engine](#1-powered-by-voicerpg-engine)
  * [2. How Wally's World Configures the Engine (`GameContent.kt`, Retail Movesets)](#2-how-wallys-world-configures-the-engine)
  * [3. Turn-Based Retail Battle Mechanics (`CombatModels.kt`, `MovesetTable.kt`)](#3-turn-based-retail-battle-mechanics)
  * [4. Pure Story Mode & Dialogue Auto-Play (`StoryScreen.kt`)](#4-pure-story-mode--dialogue-auto-play)
  * [5. Audio Setup Wizard Bypass & Fast Character Flow](#5-audio-setup-wizard-bypass--fast-character-flow)
  * [6. Multi-Repo Synchronization Workflow (`sync_engine_to_games.sh`)](#6-multi-repo-synchronization-workflow)
  * [7. Automated Unit Verification Suite (`tests/`)](#7-automated-unit-verification-suite)
  * [8. Clean-Room Provenance & Non-Commercial Licensing](#8-clean-room-provenance--non-commercial-licensing)

---

# Part 1 — Consumer Overview & Quick Start

## 🛒 What Is Wally's World?

**Wally's World** is a satirical narrative voice JRPG for Android that transforms the daily gauntlet of superstore retail life into a high-stakes, hilarious retro adventure.

Step into the steel-toed work boots of a newly hired department associate. Battle through chaotic Black Friday rushes, rogue floor managers demanding unreasonable metric quotas, defective pallet jacks, and irrational return-desk customers:
- **🗣️ Voice-Activated Workplace Maneuvers**: Chant real retail survival tactics aloud (*"Customer service smile"*, *"Code blue announcement"*, *"Spill cleanup kit"*, *"Overtime surge"*).
- **⚡ Voice Resonance Mechanics**: The clearer and more authoritative your delivery, the higher your Resonance rating, granting massive morale and stamina recovery bonuses up to 3.0x power.
- **🤝 Ally with Workplace Legends**: Form an unbreakable shift alliance with Adriana and summon **Adriana's Inspiration** to keep your squad's morale from hitting zero.

---

## ⏰ How a Shift Works in 3 Steps

1. **Clock In & Listen**: Dialogue and situational emergencies are narrated via distinct Android TTS voice characters.
2. **Issue Spoken Directives**: Speak your retail ability or target to resolve floor conflicts (*"Adriana box cutter flurry"*, *"Clean spill on aisle 7"*).
3. **Survive the Shift**: Keep your Morale (HP) and Energy (MP) high to successfully clock out and level up your associate tier.

---

## 🪪 Associate Badge Registration & Custom Vest Tints

Start playing immediately without lengthy audio calibration screens:
- Enter your **Name** and **Job Title** (e.g. *Cart Wrangler*, *Inventory Specialist*, *Lead Cashier*).
- Personalize your associate character sprite with customizable **Vest Tints** and **Aura Colors**.

---

## 📦 The 6-Act Retail Survival Saga & Adriana Allies

- **Act 1: The Orientation Maze**: Survive mandatory video training modules and corporate policy quizzes.
- **Act 2: The Stockroom Catacombs**: Navigate towering pallet stacks and missing inventory manifests.
- **Act 3: Pueblo Encounter & Overnight Logistics**: Night-shift restocking challenges and road travel.
- **Act 4: The Road to Florida**: Regional transfers and inter-store retail competition.
- **Act 5: The Crucible**: Peak holiday madness and double-coupon chaos in St. Augustine.
- **Act 6: Aussie & The Auto Care Center**: The grand climax and final balance sheet reconciliation.

---

## 🚶 Pure Story Mode & Screenless Commute Pocket Mode

- **Pure Story Mode**: Sit back and enjoy the narrative like an interactive audiobook; dialogue automatically progresses without stopping for manual input.
- **Pocket Walk Mode**: Put on your headphones, lock the screen into a battery-saving OLED black touch-guard, and play hands-free during your daily walk or commute.

---

## 🚀 Quick Download & Installation (Android APK)

1. Grab **`wallys-world-v1.22.0-debug.apk`** from [Releases](https://github.com/Todd0042/wallys-world/releases).
2. Install on any Android 8.0+ device (API 26 or higher).
3. Tap **Allow** for microphone access.

---

# Part 2 — Technical Architecture & Engine Integration

## 1. Powered by VoiceRPG Engine

Wally's World runs entirely on the open-source **[VoiceRPG Engine](https://github.com/Todd0042/voice-rpg-engine)** framework.

The core speech recognizer, acoustic volume and pitch analyzers, ATB initiative system, and multi-voice TTS pipelines are provided by the engine. Wally's World layers custom workplace content, satirical dialogue trees, and associate character stats on top of this rock-solid base.

For complete engine architectural specifications, visit:  
👉 **[https://github.com/Todd0042/voice-rpg-engine](https://github.com/Todd0042/voice-rpg-engine)**

---

## 2. How Wally's World Configures the Engine

Wally's World configures the engine using dynamic data models:
- **`GameContent.kt`**: Maps retail workplace scenes, customer encounters, and associate rosters.
- **Speaker TTS Profiles**: Binds distinct pitch and speed profiles to managers, customers, and associates.

---

## 3. Turn-Based Retail Battle Mechanics

Workplace battles adapt the engine's 5 spell categories:
- `ATTACK`: Direct floor action (*"Barcode Scan Strike"*, *"Box Cutter Slice"*).
- `AOE_ATTACK`: Full-aisle management (*"Paging All Associates"*, *"Intercom Announcement"*).
- `HEAL`: Breakroom recovery and morale boosts (*"Coffee Break"*, *"Adriana's Inspiration"*).
- `DEFENSE`: Conflict de-escalation (*"Managerial Waiver"*, *"Store Policy Guard"*).
- `MANA`: Energy drinks and 15-minute breaks.

---

## 4. Pure Story Mode & Dialogue Auto-Play

Implements the engine's non-blocking auto-play mode in [`StoryScreen.kt`](app/src/main/java/com/voicerpg/engine/ui/story/StoryScreen.kt):
- Prompts are automatically selected at branching points when Pure Story Mode is enabled.
- Combat encounters can be toggled to auto-resolve or prompt for quick voice shouts.

---

## 5. Audio Setup Wizard Bypass & Fast Character Flow

Wally's World streamlines game onboarding by bypassing legacy audio diagnostic wizards and taking players straight to character creation in [`AssociateBadgeScreen`](app/src/main/java/com/voicerpg/engine/ui/creation/CharacterCreationScreen.kt).

---

## 6. Multi-Repo Synchronization Workflow

Engine updates are synchronized seamlessly using:
```bash
/path/to/voice-rpg-engine/scripts/sync_engine_to_games.sh /path/to/wallys-world
```

---

## 7. Automated Unit Verification Suite

Wally's World includes unit test coverage for retail movesets, choice matching, and save state integrity:
```bash
# Run unit tests:
./gradlew testDebugUnitTest

# Assemble debug APK:
./gradlew assembleDebug
```

---

## 8. Clean-Room Provenance & Non-Commercial Licensing

- **Original Workplace Parody:** Wally's World is a parody of corporate superstore culture and retail experiences.
- **PolyForm Noncommercial 1.0.0:** Free for personal and hobbyist entertainment. For commercial inquiries, contact **[todd.0042.git@gmail.com](mailto:todd.0042.git@gmail.com)**.

---

<p align="center">
  If you enjoy playing Wally's World, consider supporting open-source development:<br/><br/>
  <a href="https://ko-fi.com/todd0042" target="_blank">
    <img src="https://img.shields.io/badge/☕_Support_Wally's_World_on_Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Support on Ko-fi">
  </a>
</p>

---

<p align="center">
  <a href="https://ko-fi.com/todd0042">
    <img src="https://raw.githubusercontent.com/Todd0042/creator-assets/main/banners/todd_creator_banner_v2.0.png" alt="Support Todd on Ko-fi" width="100%" />
  </a>
</p>
