# Combat Companions & Allies: Planning Roster

This document compiles potential party members and combat companions drawn from the story across all six acts. It serves as a comprehensive planning guide for introducing multi-character combat parties into the engine.

---

## 1. Summary Matrix by Act

> [!IMPORTANT]
> **The Bedrock Anchor Rule**: Either **Adriana** (physical) or **Adriana's Inspiration** (ethereal/ghost) is present in **EVERY SINGLE ENCOUNTER** in the entire game.
> - **Adriana (Physical)** joins encounters where she is narratively present in the room or crisis (e.g., Lamar grievance hearings, St. Augustine 3 AM collapse, Final Balance Sheet).
> - **Adriana's Inspiration** appears in all other encounters where Todd is on the warehouse floor, in the bays, on the road, or in corporate offices alone.

| Act | Core Companion(s) | Other Candidate Allies | Tactical / Narrative Role |
| :--- | :--- | :--- | :--- |
| **Act I: The Utah Grind** | **Adriana's Inspiration** (F - Ghost) | **Jodie** (M) | Freight unloads, backroom speed, and quiet homefront emotional support keeping Todd grounded through 4 AM shifts. |
| **Act II: The Lamar Squeeze** | **Adriana** (F - In Person) &<br>**Adriana's Inspiration** (F - Ghost) | **Miss Trudy** (F),<br>**Cap'n Skagg** (M) | Facing the HR grievance hearing and corporate bias hand-in-hand with Adriana, supported by veteran warmth and bay mentors. |
| **Act III: The Borderlands Squeeze** | **Adriana's Inspiration** (F - Ghost) | **Azalia** (F) | Navigating the 80-mile state line commute and conflict-averse leadership with comforting reminders of home. |
| **Act IV: The Madness (Pueblo)** | **Adriana's Inspiration** (F - Ghost) | **Jay-Dau** (M) | High-risk overnight inventory pushes ("#1 in the Nation") and chaotic parking lot standoffs; surviving sleep deprivation. |
| **Act V: The Crucible (St. Augustine)** | **Adriana** (F - In Person) &<br>**Adriana's Inspiration** (F - Ghost) | *None (Just Todd & Adriana)* | The climactic 3 AM reckoning where Adriana literally saves Todd's life, and surviving the hostage hours of retail collapse. |
| **Act VI: The Aftermath (Florida Bays)** | **Adriana** (F - In Person) &<br>**Adriana's Inspiration** (F - Ghost) | **Tani** (F),<br>**Cap'n H** (M),<br>**Timmy** (M) | Elite shop-floor teamwork in the bays, unbreakable veteran defense against corporate inquisitions, and the final balance sheet. |

---

## 2. Core Campaign-Wide Anchor: The Two Adrianas

### A. Adriana *(Physical / In-Person — Female)*
* **Who She Is**: Todd's wife, confidante, and life partner. She lived through every relocation across five states, endured blatant gender discrimination in Lamar when passed over for Shop Manager, and was the sole anchor pulling Todd back from the brink during the 3 AM breakdown in St. Augustine.
* **When She Joins**: Battles where she is physically present on the scene:
  * **Act II (Lamar)**: The Brick Wall & HR grievance hearings (`brick_wall_hearing`, `jury_showdown`), directly taking on corporate bad faith together.
  * **Act V (St. Augustine)**: The 3 AM Abyss (`florida_three_am`), anchoring Todd through sheer presence, love, and reality check.
  * **Act VI (Florida Bays)**: The Final Balance Sheet (`act6_final_balance`), weighing the true human toll of the corporate years.
* **Combat Archetype**: **Active Support / Anchor / Cleanser**
* **Mechanical Nature**:
  * Standard full combatant: has HP, MP, Attack, Defense, Speed.
  * Targetable and damageable by foes; can be KO'd and revived.
  * Normal party defeat conditions apply.
* **Abilities**:
  * **Grounded Reality**: Cleanses confusion, panic, and despair; restores MP.
  * **Unbroken Bond**: Absorbs a lethal blow directed at Todd, ensuring he survives with 1 HP.
  * **Name the Truth**: Exposes corporate double-speak, shredding enemy Attack and Defense.
  * **The 3 AM Lifeline**: Massive emergency heal and barrier when Todd drops into critical health.

---

### B. Adriana's Inspiration *(Spiritual Presence / Ethereal Support — Female / Ghost)*
* **Who She Is**: Todd's mental image and emotional lifeline to Adriana when he is isolated on the clock. Even when miles apart or deep in a 14-hour warehouse shift, the thought of her voice, her warmth, and home keeps him from breaking under corporate insanity.
* **When She Joins**: **Every single combat encounter** across Acts I through VI where Adriana is not physically in the room (freight unloads, customer rushes, executive tours, oil rushes, night stocking, store manager confrontations).
* **Combat Archetype**: **Ethereal Guardian / Pure Support (Zero Attacks)**
* **Mechanical Nature**:
  * **Untargetable & Immune**: Treated as a "ghost" companion. Foes cannot target or attack her; she takes zero damage, has no HP bar (or an infinite/hidden one), and cannot be afflicted by status debuffs or crowd control.
  * **Loss-Condition Neutral**: Encounter victory or defeat depends solely on Todd (and any other physical companions). Whether Adriana's Inspiration is present or not has no bearing on defeat conditions; she effectively cannot die.
  * **Purely Support (No Basic Attack)**: Has no offensive basic attack and no damage-dealing abilities. Her turn on the ATB gauge is strictly dedicated to healing, clearing debuffs, granting protective barriers, and restoring MP/morale.
* **Playful, Grounding & Domestic Abilities**:
  * **"The Backrub"**: Eases tension and sore muscles after hours on concrete. Restores party HP and clears Exhaustion and Slow.
  * **"Inspiring Words"**: A gentle, loving whisper reminding Todd of life outside the warehouse. Dispels Mental Debuffs (Panic, Confusion, Despair) and grants MP regeneration over time.
  * **"Pack Your Lunch"**: That little note and sandwich packed with care. Deploys a protective damage barrier around Todd and restores stamina.
  * **"Remember Why You're Doing This"**: A sudden surge of purpose. Grants Todd an enduring buff that prevents fatal damage for 1 turn.
  * **"A Deep Breath"**: A grounding moment of quiet clarity. Lowers Todd's threat generation and reduces incoming physical and emotional damage for 2 turns.
  * **"It's Just Groceries"**: The ultimate perspective check against corporate panic. Dispels enemy intimidation buffs and restores party composure.

---

## 3. The Bay Guardians (Act 6 Comrades)

### Tani *(Bay Lead — Precision & Pride — Female)*
* **Who She Is**: The sharp, fiercely protective lead technician in Act 6. She holds the line against Aussie’s clipboard panic and insists that the crew's standard of work is what protects the customer, not corporate timers.
* **Eligible Battles & Acts**:
  * **Act VI**: The Customer Gauntlet (`act6_customer_gauntlet`), The All-Hands Inquisition (`act6_phantom_threat`), and shop-floor conflicts.
* **Combat Archetype**: **Fast Striker / Armor Shredder / Speed DPS**
* **Proposed Abilities**:
  * **Pneumatic Torque**: Rapid physical strike with the pneumatic gun that ignores a portion of enemy Defense.
  * **Diagnostic Eye**: Analyzes enemy patterns, boosting Todd’s Critical Hit rate.
  * **Reject the Metric**: Dispels enemy haste/speed buffs and team panic debuffs.
  * **Crew Shield**: Intercepts incoming damage aimed at junior techs or lower-HP allies.

### Cap'n H *(Hector — Veteran Bay Lead — Male)*
* **Who He Is**: Nine years in the pit, having outlasted 3 store managers and 11 shop managers. The ultimate veteran survivor who knows that corporate suits come and go, but proper lug torque is eternal.
* **Eligible Battles & Acts**:
  * **Act VI**: The All-Hands Inquisition (`act6_phantom_threat`) and shop battles.
* **Combat Archetype**: **Heavy Tank / Bulwark / Counter-Attacker**
* **Proposed Abilities**:
  * **Nine-Year Armor**: Taunts enemies and drastically reduces incoming physical damage.
  * **Impact Thunder**: Heavy AoE shockwave attack using the commercial pneumatic impact gun.
  * **Torqued to Spec**: Passive aura—party basic attacks cannot miss.
  * **Outlast the Suits**: Continuous gradual HP regeneration; immune to intimidate and fear debuffs.

---

## 4. Mentors, Supervisors & Early Allies (Acts 1–3)

### Jodie *(Freight Supervisor / Area HR — Male)*
* **Who He Is**: Todd’s initial supervisor on the Utah 4 AM unloads. He respects Todd's work ethic in the freight trenches, and later—after moving to Area HR in Colorado—personally offers Todd the promotion and transfer out of Utah.
* **Eligible Battles & Acts**:
  * **Act I (Utah)**: The 4 AM Unload (`trench_unload`), Front-End Storm (`floor_war`), and backroom scrambles.
  * **Act II (Lamar transition)**: Early Colorado arrival fights.
* **Combat Archetype**: **Backroom Vanguard / Tempo Controller**
* **Proposed Abilities**:
  * **Pallet Jack Blitz**: High-tempo rush attack that delays enemy turn order on the ATB gauge.
  * **Trench Cadence**: Haste buff that speeds up party action gauges.
  * **Area Voucher**: Reduces party stamina/MP costs for 3 turns.
  * **Line Clear**: Sweeping physical AoE attack clearing out frontline minions.

### Miss Trudy *(Legacy Store Manager — Lamar — Female)*
* **Who She Is**: The beloved, grandmotherly store manager of the Lamar store in early Act 2 who treats her crew like family before corporate forces her into early retirement to install Jury.
* **Eligible Battles & Acts**:
  * **Act II**: The Highway Oasis (`lamar_oil_rush`) and early Act 2 encounters before her ouster.
* **Combat Archetype**: **Morale Healer / Defensive Ward**
* **Proposed Abilities**:
  * **Southern Grace**: Restores party HP and clears exhaustion.
  * **Associate Care**: Casts a protective shield absorbing incoming damage.
  * **Warm Welcome**: Calms enemy fury, lowering enemy attack power.
  * **Legacy Blessing**: Grants Todd a persistent regen buff that lasts after combat.

### Cap'n Skagg *(Colorado Area Manager — Male)*
* **Who He Is**: The genuine mentor figure in Act 2. Unlike the spreadsheet drones, Skagg actually inspects the stores hands-on, teaches his managers, and quickly sees through Mattie-T’s defamatory email.
* **Eligible Battles & Acts**:
  * **Act II**: Mentoring Todd, inspecting the Lamar shop bays, and confronting corporate bad faith.
* **Combat Archetype**: **Field Commander / Buffer / Administrative Striker**
* **Proposed Abilities**:
  * **Floor Inspection**: Reveals all enemy weaknesses, stats, and impending actions.
  * **Executive Overrule**: Interrupts and cancels an enemy's charged spell or boss ultimate.
  * **Field Training**: Buffs Todd’s Attack, Defense, and Speed for 3 turns.
  * **Real Leadership**: Party-wide boost to resonance generation.

### Azalia *(Store Manager — The Borderlands — Female)*
* **Who She Is**: The South Carolina store manager in Act 3. Warm, kind, and deeply supportive of Todd, but so conflict-averse that she un-does every disciplinary write-up, paralyzing store accountability.
* **Eligible Battles & Acts**:
  * **Act III**: The State Line Commute (`carolina_neglect`) and early Borderlands struggles.
* **Combat Archetype**: **Pacifist Buffer / Evasion Enabler**
* **Proposed Abilities**:
  * **Kindness Cloak**: Lowers enemy accuracy and soothes aggression.
  * **De-escalate**: Weakens enemy physical attacks.
  * **Forgiving Stance**: Grants the party high evasion against standard attacks.

---

## 5. Complex Comrades & Trainees (Acts 4 & 6)

### Jay-Dau *(Store Manager — Pueblo — Male)*
* **Who He Is**: Todd’s genuine personal friend after hours, sharing drinks and mutual respect, yet a terrifying daytime manager who runs an unsparing meat grinder burning through 13 overnight managers in a single year.
* **Eligible Battles & Acts**:
  * **Act IV (Pueblo)**: Overnight inventory overhaul (`pueblo_freight_to_floor`), pushing Pueblo to "#1 in the Nation", and chaotic parking lot brawls (`pueblo_parking_draw`).
* **Combat Archetype**: **High-Risk Berserker / Aggressive Corporate Operator**
* **Proposed Abilities**:
  * **Number One in the Nation**: Drastically buffs party Attack and Speed, but reduces party Defense.
  * **Double Shot**: Heavy burst physical/ranged damage with unpredictable targeting.
  * **After-Hours Alliance**: High MP/stamina restoration between fight phases.
  * **Midnight Oil**: Instantly fills an ally's ATB gauge at the cost of minor chip damage.

### Timmy *(Store Manager — The Brief Sanctuary — Male)*
* **Who He Is**: The compassionate store manager in early Act 6 who knows everyone by name and restores Todd's dignity after the salaried crash, before corporate promotes him out.
* **Eligible Battles & Acts**:
  * **Act VI**: Chapter 29 battles (`act6_pay_cut` aftermath) before Abdoolie takes over.
* **Combat Archetype**: **Guardian / Morale Paladin**
* **Proposed Abilities**:
  * **Human Decency**: Casts party-wide damage barriers and grants immunity to fear.
  * **Open Door Policy**: Draws enemy aggro to protect vulnerable party members.
  * **Lead by Name**: Heals party MP and clears negative status conditions.

---

## 6. Engine Mechanics & Architecture Considerations

1. **Party Roster in Encounters**:
   * Encounters in `encounters.json` define a `party` array (e.g. `party: ["todd_shop", "adriana_inspiration"]` or `party: ["todd_shop", "adriana", "capn_skagg"]`).
   * By rule, **every encounter** will list either `"adriana"` or `"adriana_inspiration"` in its party array.

2. **Ghost / Ethereal Support Flag (`isGhost` / `isUntargetable`)**:
   * To support **Adriana's Inspiration**, character definition (e.g. in `characters/adriana_inspiration.json`) or party slot can declare:
     ```json
     "isGhost": true,
     "isUntargetable": true,
     "canDie": false,
     "canAttack": false
     ```
   * **Targeting AI**: Enemy AI filters out any party member with `isUntargetable == true`.
   * **Wipe Condition**: Battle loss checks evaluate only mortal combatants:
     ```kotlin
     val isPartyDefeated = party.filter { !it.isGhost }.all { it.isDead }
     ```
   * **Action Options**: In battle, Adriana's Inspiration has no basic "Attack" command; her action wheel/menu presents support disciplines, spells, and items exclusively.

3. **Audio & Narration Presence**:
   * Adriana's Inspiration can feature gentle, intimate TTS lines or whispered voice clips that chime in when a buff or heal is triggered hands-free via voice commands (e.g., *"Take a deep breath, Todd"* or *"Remember, it's just groceries"*).
