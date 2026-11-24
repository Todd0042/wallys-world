<p align="center">
  <a href="https://ko-fi.com/todd0042">
    <img src="https://raw.githubusercontent.com/Todd0042/creator-assets/main/banners/todd_creator_banner_v1.0.png" alt="Support Todd on Ko-fi" width="100%" />
  </a>
</p>

---

# 🛒 Wally's World: Retail Survival Voice JRPG

[![Version](https://img.shields.io/badge/Version-1.22.0-ff2a85.svg)](https://github.com/Todd0042/wallys-world/releases)
[![License: PolyForm Noncommercial 1.0.0](https://img.shields.io/badge/License-PolyForm%20Noncommercial%201.0.0-00f0ff.svg)](LICENSE)
[![Platform: Android 8.0+](https://img.shields.io/badge/Platform-Android%208.0%2B%20(API%2026%2B)-3DDC84.svg?logo=android&logoColor=white)](https://developer.android.com)
[![16 KB Page Size](https://img.shields.io/badge/16%20KB-Compatible-success.svg)](https://developer.android.com/16kb-page-size)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-7F52FF.svg?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![UI: Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose%202024.10.01-4285F4.svg?logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Voice Control: Hands-Free](https://img.shields.io/badge/Controls-Hands--Free%20Voice-orange.svg)](app/src/main/java/com/voicerpg/engine/audio/SpeechManager.kt)
[![Speech: Android Offline STT](https://img.shields.io/badge/Speech-Android%20Offline%20STT-3DDC84.svg)](https://developer.android.com/reference/android/speech/SpeechRecognizer)
[![Combat: Cadence & Timing](https://img.shields.io/badge/Combat-Cadence%20%26%20Timing-yellow.svg)](app/src/main/java/com/voicerpg/engine/engine/ResonanceEngine.kt)
[![Audio: Dynamic Ducking](https://img.shields.io/badge/Audio-Dynamic%20Ducking-green.svg)](app/src/main/java/com/voicerpg/engine/audio/)
[![Unit Tests](https://img.shields.io/badge/Unit%20Tests-Passing-39ff14.svg)](app/src/test/java/com/voicerpg/engine/)
[![Engine: VoiceRPG](https://img.shields.io/badge/Engine-VoiceRPG%20v2.0.0-teal.svg)](https://github.com/Todd0042/voice-rpg-engine)
[![Support on Ko-fi](https://img.shields.io/badge/Ko--fi-Support%20Creator-F16061?style=flat&logo=ko-fi&logoColor=white)](https://ko-fi.com/todd0042)

> **A comedic workplace survival voice JRPG for Android where hands-free incantations, tactical retail ATB combat, and real-life retail absurdities collide — featuring streamlined Associate Badge registration, Adriana party allies, real-time acoustic resonance scoring, and 100% screenless Pocket Mode for your commute.**

```
       _________________________________________________________________________
      |  STORE MANAGER CHAD                         HP [████████████░░░]  82%   |
      |  "Who authorized overtime on aisle 4?!"     MP [███████████████] 100%   |
      |_________________________________________________________________________|
      |  ASSOCIATE: "By the employee handbook, breakroom breather now!"         |
      |  RESONANCE: MYTHIC (132%) >>> MORALE RESTORED TO FULL ALLY FLANK!      |
      |  TACTICAL TAGS: [ATTACK] [AOE] [HEAL] [DEFENSE] [MANA]                  |
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
* **Part 2 — Consolidated Technical Documentation & Architecture Reference**
  * [1. Clean Architecture & Framework Integration (`com.voicerpg.engine.*`)](#1-clean-architecture--framework-integration)
  * [2. How Wally's World Configures the Engine (`GameContent.kt`)](#2-how-wallys-world-configures-the-engine)
  * [3. Real-Time Speech Recognition & Continuous Audio Arbitration Loop (`SpeechManager.kt`)](#3-real-time-speech-recognition--continuous-audio-arbitration-loop)
  * [4. Resonance Engine & Acoustic-Poetic Scoring Math (`ResonanceEngine.kt`, `SpellThesaurus.kt`)](#4-resonance-engine--acoustic-poetic-scoring-math)
  * [5. Real-Time Audio DSP & Dynamic Music Ducking Pipeline (`MusicManager.kt`)](#5-real-time-audio-dsp--dynamic-music-ducking-pipeline)
  * [6. Turn-Based Retail Battle Mechanics & Conveyor ATB (`CombatModels.kt`, `MovesetTable.kt`)](#6-turn-based-retail-battle-mechanics--conveyor-atb)
  * [7. MLKit & TFLite Selfie Character Creation Pipeline (`SelfiePortraitProcessor.kt`)](#7-mlkit--tflite-selfie-character-creation-pipeline)
  * [8. Multi-Repo Synchronization Workflow (`sync_engine_to_games.sh`)](#8-multi-repo-synchronization-workflow)
  * [9. Automated Unit Verification Suite (`tests/`)](#9-automated-unit-verification-suite)
  * [10. Clean-Room Provenance & Non-Commercial Licensing](#10-clean-room-provenance--non-commercial-licensing)

---

# Part 1 — Consumer Overview & Quick Start

## 🛒 What Is Wally's World?

**Wally's World** is a satirical narrative voice JRPG for Android that transforms the daily gauntlet of superstore retail life into a high-stakes, hilarious retro adventure.

Step into the steel-toed work boots of a newly hired department associate. Battle through chaotic holiday rushes, rogue floor managers demanding unreasonable metric quotas, defective pallet jacks, and irrational return-desk customers:
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
- Optionally snap a selfie using on-device MLKit face segmentation to generate an authentic 16-bit retail associate ID portrait.

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

# Part 2 — Consolidated Technical Documentation & Architecture Reference

## 1. Clean Architecture & Framework Integration

Wally's World runs entirely on the source-available **[VoiceRPG Engine](https://github.com/Todd0042/voice-rpg-engine)** framework, cleanly decoupling narrative content from underlying engine subsystems:

```
+-----------------------------------------------------------------------+
|                         WALLY'S WORLD CLIENT                          |
|         (Jetpack Compose UI, Material 3, Associate Badge Screen)       |
+-----------------------------------------------------------------------+
                                   |
                                   v
+-----------------------------------------------------------------------+
|                         VOICERPG CORE ENGINE                          |
|  +--------------------+  +--------------------+  +-----------------+  |
|  |   SpeechManager    |  |  ResonanceEngine   |  |   CombatEngine  |  |
|  | (Audio Arbitration)|  | (Acoustic Scoring) |  |   (ATB Matrix)  |  |
|  +--------------------+  +--------------------+  +-----------------+  |
+-----------------------------------------------------------------------+
                                   |
                                   v
+-----------------------------------------------------------------------+
|                       WORKPLACE CONTENT LAYER                         |
|  GameContent.kt | MovesetTable.kt | StoryScenes.kt | AssociateRoster  |
+-----------------------------------------------------------------------+
```

Core framework guarantees:
- **Zero Cloud Latency & Total Privacy**: 100% on-device speech processing with `EXTRA_PREFER_OFFLINE` via `SpeechRecognizer.createOnDeviceSpeechRecognizer` on Android 12+ (API 31+).
- **16 KB Page Alignment**: Fully compliant with Android 15's 16 KB page-size architecture requirements.

---

## 2. How Wally's World Configures the Engine

Wally's World configures the engine using dynamic data models in [`GameContent.kt`](app/src/main/java/com/voicerpg/engine/content/GameContent.kt):
- **Workplace Encounters**: Registers floor managers (Store Manager Chad, District VP Azalia), coupon demanding customers, and coworker allies.
- **Speaker TTS Profiles**: Binds distinct pitch, speed, and gender profiles to managers, customers, and associates.

---

## 3. Real-Time Speech Recognition & Continuous Audio Arbitration Loop

The hands-free conversational loop is coordinated by [`SpeechManager.kt`](app/src/main/java/com/voicerpg/engine/audio/SpeechManager.kt) and [`IntentParser.kt`](app/src/main/java/com/voicerpg/engine/engine/IntentParser.kt).

### Audio Arbitration State Machine

```
  +--------------+   Narration Begins    +-------------------+
  |     IDLE     | --------------------> |   TTS_NARRATING   |
  +--------------+                       +-------------------+
         ^                                         |
         | Intent Dispatched                       | Synthesis Complete
         |                                         v
  +------------------+   Utterance Ready +-------------------+
  |  INTENT_DISPATCH | <---------------- |     MIC_ARMED     |
  +------------------+                   +-------------------+
         |                                         |
         v                                         | Voice Energy Detected
  +------------------+                             v
  |  RESONANCE_EVAL  | <----------------- +-------------------+
  +------------------+    RMS Threshold   |    RECOGNIZING    |
                                          +-------------------+
```

- **Audio Chime Suppression**: Notification audio streams are temporarily muted during microphone listening windows to eliminate distracting OS audio pings.
- **Dynamic Intent Parsing**: Utterances are mapped to live combat targets, customer personas, or register keypad functions with zero latency.

---

## 4. Resonance Engine & Acoustic-Poetic Scoring Math

Spoken workplace maneuvers and customer de-escalations are evaluated by [`ResonanceEngine.kt`](app/src/main/java/com/voicerpg/engine/engine/ResonanceEngine.kt):

$$R = S_{\text{acoustic}} + S_{\text{cadence}} + S_{\text{poetic}} + S_{\text{novelty}}$$

Where:

1. **Acoustic Energy ($S_{\text{acoustic}}$)**:
   Evaluated from peak decibel volume and fundamental pitch contour variation $\Delta f_0$:
   $$S_{\text{acoustic}} = \min\left(30, \max\left(0, \frac{\text{dB}_{\text{peak}} - 45}{40} \times 30\right)\right) + S_{\text{pitch}}$$

2. **Vocal Cadence ($S_{\text{cadence}}$)**:
   Measures pacing and rhythmic meter across syllables:
   $$S_{\text{cadence}} = 25 \times \exp\left(-\frac{(T_{\text{utterance}} - T_{\text{optimal}})^2}{2\sigma^2}\right)$$

3. **Phonetic Thesaurus Matching ($S_{\text{poetic}}$)**:
   Matches spoken phrases against workplace keyword thesauruses (`SpellThesaurus.kt`) using normalized Levenshtein distance:
   $$\text{Sim}(u, t) = 1 - \frac{\text{lev}(u, t)}{\max(|u|, |t|)}$$
   Words with $\text{Sim}(u, t) \ge 0.75$ contribute up to 35 points to $S_{\text{poetic}}$.

4. **Novelty Bonus ($S_{\text{novelty}}$)**:
   Rewards variations in phrasing across consecutive turns (up to 10 points), penalizing repetitive macro shouting.

### Resonance Multiplier Tiers

| Tier Name | Score Range | Damage / Recovery Multiplier | Visual & Audio Flair |
| :--- | :--- | :--- | :--- |
| **Novice** | $0 \le R < 40$ | **1.00x** (Standard effect) | Standard register beep |
| **Apprentice** | $40 \le R < 70$ | **1.15x** Base Boost | Green phosphor blink |
| **Adept** | $70 \le R < 100$ | **1.35x** High Efficiency | Blue scanner flash |
| **Master** | $100 \le R < 130$ | **1.85x** Critical Override | Dual amber warning light |
| **Mythic** | $130 \le R < 155$ | **2.25x** Manager Authorization | Red strobe & siren tone |
| **Transcendental** | $R \ge 155$ | **3.00x** (Absolute Cap) | Golden corporate broadcast flash |

---

## 5. Real-Time Audio DSP & Dynamic Music Ducking Pipeline

Ambient store music tracks and intercom announcements are modulated in real-time by [`MusicManager.kt`](app/src/main/java/com/voicerpg/engine/audio/MusicManager.kt):

$$V_{\text{bgm}}(t) = V_{\text{base}} \cdot \Big(1 - \alpha \cdot \mathbb{I}_{\text{speaking}}(t)\Big)$$

Where:
- $V_{\text{base}}$ is the configured master background volume.
- $\alpha \approx 0.70$ is the speech ducking attenuation coefficient (reducing ambient music to $-10.5\text{ dB}$).
- $\mathbb{I}_{\text{speaking}}(t) \in \{0, 1\}$ is the boolean speech indicator provided by the arbitration engine.

Audio tracks are normalized to **$-16\text{ LUFS}$** (44.1 kHz Vorbis `.ogg`) to ensure consistent loudness across speakers and mobile headsets.

---

## 6. Turn-Based Retail Battle Mechanics & Conveyor ATB

Workplace battles adapt the engine's 5 spell categories:
- `ATTACK`: Direct floor action (*"Barcode Scan Strike"*, *"Box Cutter Slice"*).
- `AOE_ATTACK`: Full-aisle management (*"Paging All Associates"*, *"Intercom Announcement"*).
- `HEAL`: Breakroom recovery and morale boosts (*"Coffee Break"*, *"Adriana's Inspiration"*).
- `DEFENSE`: Conflict de-escalation (*"Managerial Waiver"*, *"Store Policy Guard"*).
- `MANA`: Energy drinks and 15-minute breaks.

Conveyor ATB Initiative gauges fill proportionally to Associate Agility $\text{Spd}_a$ versus Boss Frustration $\text{Spd}_b$:

$$\Delta \text{Gauge}_i = \frac{\text{Spd}_i}{\text{TickRate}} \times \Delta t$$

---

## 7. MLKit & TFLite Selfie Character Creation Pipeline

Wally's World includes an on-device portrait pipeline using Google MLKit Selfie Segmentation:
- Captures front-facing camera input locally without transmitting imagery over the network.
- Applies automated background extraction, posterization, and 16-bit color reduction to produce a retro pixel-art associate portrait.

---

## 8. Multi-Repo Synchronization Workflow

Engine updates are synchronized seamlessly from upstream `voice-rpg-engine`:

```bash
# Pull latest engine improvements while preserving custom campaign scripts:
cd ../voice-rpg-engine && ./scripts/sync_engine_to_games.sh wallys-world

# Audit sync status:
cd ../voice-rpg-engine && ./scripts/sync_engine_to_games.sh --check
```

---

## 9. Automated Unit Verification Suite

Wally's World includes unit test coverage for retail movesets, choice matching, and save state integrity:

```bash
# Run unit tests:
./gradlew testDebugUnitTest

# Assemble debug APK:
./gradlew assembleDebug
```

---

## 10. Clean-Room Provenance & Non-Commercial Licensing

- **Original Workplace Parody**: Wally's World is a work of parody celebrating the resilient humor of retail workers.
- **PolyForm Noncommercial 1.0.0**: Free for personal, recreational, and educational gaming. For commercial inquiries, contact **[Todd.0042.git@gmail.com](mailto:Todd.0042.git@gmail.com)**.

---

<p align="center">
  If you enjoy playing Wally's World, consider supporting its development:<br/><br/>
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
