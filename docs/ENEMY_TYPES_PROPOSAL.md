# Enemy Types Proposal: Wally's World

Status: **proposal for Todd's approval** (2026-11-27). Nothing in the game's JSON has changed. It covers
`docs/COMBAT_PROGRESSION_PLAN.md` (engine repo) decision 18 (type names, proposed by Claude and approved by Todd) and the
Wally's World item in section 4: "widen enemy types beyond 4 families; type names proposed for approval".

**Today:** 56 enemies in four families (CONSTRUCT 22, FLESH 16, VOID 11, VERDANT 7), and almost every one has a
`selfElement` copied from its moveset (SHADOW on 21, PHYSICAL on 14). That causes the three coverage failures below: in
Todd's first three fights his whole kit is PHYSICAL, and the Freight Wall and the Ringer impair PHYSICAL through
their element, while the Poisoned Email resists it as VOID. This proposal uses all seven families and drops the copied
elements, keeping elements only where they say something (the shingles are fire, the empty building is cold).

**Assumed rules** (E6 isn't built yet; confirm when it is):
- Damage multiplier = family value from the matrix; a school in `weak` becomes **2.0**, a school in `resist` becomes
  **0.8** (override; never immune).
- `element` keeps today's meaning (same-school hits capped at 0.8).
- `armor`: none / light / heavy = flat reduction per hit; piercing spells ignore it.
- Engine ids stay; only display and spoken names change (`combat/affinity_matrix.json`).

---

## 1. Display names

Todd's "spells" are the ways a worker gets through a shift, and the enemies are what the store throws at him. The schools
are **ways of working**; the families are **what wears you down**.

### Schools

| Engine id | Display name | Why |
|---|---|---|
| PHYSICAL | **Grunt Work** | Line Drill, Freight Push, Tire Grind, Lube Line: the work itself. |
| ELECTROMANCY | **Know-How** | Volt Snap (the impact gun), Spark Ideas, Floor Charge: the right tool and the clever fix. |
| CRYOMANCY | **Cool Head** | Coolant Chill, Quiet Chill, Deep Freeze: staying calm and letting the heat die. |
| PYROMANCY | **Fired Up** | Bay Heat, Flare Up, Heat Grill: the honest flash of anger, used on purpose. |
| HOLY | **Integrity** | Truth Smite ("name the reality out loud") and every heal: Adriana's school. |
| SHADOW | **Back Channels** | Night Shift, Backroom Whisper, Shadow Doubt: the conversation out of camera range. |
| NATURE | **Growth** | Grow Crew, Root Cause, Second Seed: training people and fixing causes. |

### Families

| Engine id | Display name | Who |
|---|---|---|
| FLESH | **Management** | Store managers and leads (Mattie-T, Jury, Azalia, Jay-Dau, Amandy, Sriniviii, Abdoolie, Ohmar, Aussie), the Ringer, the Hostile Floor. Integrity and Back Channels work; a calm, flat response is what they expect. |
| UNDEAD | **Metrics** | The Dashboard, the Watchful Eye, the Calibration Lapse, the Unrealistic Standard, the Moving Goalposts, the Meat Grinder: numbers that never die. Know-How fixes the system; "the truth" means nothing to a gauge. |
| CONSTRUCT | **The Building** | Freight walls, tire towers, bay grime, deferred maintenance, the fluorescent hum, the one-man close, the ownerless building. Grunt Work takes it down; whispers don't move boxes. |
| VERDANT | **The Public** | The Friday Rush, the Sixth in Line, the Queue Wall, Grab-and-Run, Blotter Regulars, the Parking Lot Draw, the Customer Gauntlet: people, in numbers. Cool Head de-escalates; anger makes it worse. |
| VOID | **Inner Demons** | The Shingles Fire, the Fourth Signal, the Asphalt Gauntlet, the Pay Cut, the Parting Shot, the Alternative: what the job does to the body and mind. Growth, Cool Head and Integrity answer them; grinding harder or getting angry feeds them. |
| RADIANT | **Corporate** | The Area Director, the Regional Desk, the Regional Audit, the Safety Investigator, the Man They Wanted, the Final Balance Sheet: the polished upper tier. Integrity hits hardest; clever fixes bore them. |
| SILENCE | **Paperwork** | The Poisoned Email, memos, the CC line, grievance files, buried reports, edicts, contracts, claims: paper that silences people. Fired Up (refuse it loudly) burns it; staying polite signs it. |

The `narrations` templates should be reworded ("devastates it" reads as magic), for example
`"{enemyName} buckles - {school} gets through!"`.

---

## 2. Proposed affinity matrix

Rows are schools, columns families. **Bold** = 1.5 or more, _italic_ = 0.8.

| School \ Family | Management (FLESH) | Metrics (UNDEAD) | The Building (CONSTRUCT) | The Public (VERDANT) | Inner Demons (VOID) | Corporate (RADIANT) | Paperwork (SILENCE) |
|---|---|---|---|---|---|---|---|
| **Fired Up** (PYROMANCY) | 1.2 | 1.0 | 1.0 | _0.8_ | _0.8_ | 1.0 | **2.0** |
| **Cool Head** (CRYOMANCY) | 1.2 | 1.0 | 1.0 | **1.5** | **1.5** | 1.0 | _0.8_ |
| **Know-How** (ELECTROMANCY) | 1.0 | **2.0** | 1.2 | 1.0 | 1.0 | _0.8_ | 1.2 |
| **Growth** (NATURE) | 1.0 | **1.5** | _0.8_ | 1.2 | **2.0** | _0.8_ | 1.0 |
| **Integrity** (HOLY) | **1.5** | _0.8_ | 1.0 | 1.0 | **1.5** | **2.0** | 1.2 |
| **Back Channels** (SHADOW) | **1.5** | 1.0 | _0.8_ | 1.0 | _0.8_ | 1.2 | 1.0 |
| **Grunt Work** (PHYSICAL) | 1.0 | 1.0 | **1.5** | 1.2 | _0.8_ | 1.0 | 1.0 |

---

## 3. Every enemy

All 30 bosses get an explicit `weak` and `resist`. The Fluorescent Hum (in 26 of the 40 fights) is weak to Know-How, so the
idea of weaknesses gets taught early and often.

| id | name | boss | family | element | weak | resist | armor | rationale |
|---|---|---|---|---|---|---|---|---|
| `freight_wall` | The Freight Wall |  | The Building | - | - | - | light | 48 feet of boxes: only the work itself takes it down. |
| `fluorescent_hum` | The Fluorescent Hum |  | The Building | - | Know-How | - | none | The 3 AM ballast whine: whoever knows how swaps the ballast (Know-How). In ~25 fights, so it teaches the idea early. |
| `metrics_dashboard` | The Dashboard |  | Metrics | - | - | - | none | The hour-occupancy gauge: fix the system, not yourself. |
| `the_ringer` | The Ringer |  | Management | - | - | - | none | Management's pet: a manager by proxy. |
| `poisoned_email` | The Poisoned Email |  | Paperwork | - | - | - | none | The email that says he "wasn't ready": paper. |
| `mattie_t_enemy` | Mattie-T | yes | Management | - | Grunt Work | Back Channels | light | First boss, Todd alone: a finished truck is the one argument she can't answer; office politics is her game. |
| `practice_dummy` | Shift Simulator |  | The Building | - | - | - | none | Shift simulator; element removed so the drill reads neutral-or-better for every school. |
| `bay_grime` | The Bay Grime |  | The Building | - | - | - | light | Oil-soaked concrete: scrub it. |
| `tire_tower` | The Tire Tower |  | The Building | - | - | - | light | Forty mounted sets: mount them. |
| `friday_rush` | The Friday Rush |  | The Public | - | - | - | none | A line of pickups around the block: keep calm and serve. |
| `retirement_memo` | The Retirement Memo |  | Paperwork | - | - | - | none | Polite corporate execution, on letterhead. |
| `jury_watch` | The Watchful Eye |  | Metrics | - | - | - | none | The camera that never blinks: surveillance is a metric. |
| `want_man` | The Man They Wanted | yes | Corporate | - | Integrity | Grunt Work | none | Upper management's favorite answer: naming the truth at the hearing (Adriana) beats it; no amount of work moves a decision already made. |
| `grievance_file` | The Grievance File |  | Paperwork | - | - | - | none | Stamped "Unsubstantiated" before it's read. |
| `jury_enemy` | Jury | yes | Management | - | Integrity | Cool Head | light | The slur, said twice with witnesses: naming it (Integrity) lands; staying quiet lets it slide. |
| `shingles_fire` | The Shingles Fire | yes | Inner Demons | Fired Up | Cool Head | Fired Up | none | The body keeps the score: cool down (Coolant Chill), don't feed the burn. |
| `calibration_lapse` | The Calibration Lapse |  | Metrics | - | - | - | none | Dead calibration sticker: Know-How fixes it. |
| `bay_debt` | The Bay Debt |  | The Building | - | - | - | light | Years of deferred maintenance. |
| `executive_edict` | The Executive Edict |  | Paperwork | - | - | - | none | Sold out from under the floor, by memo. |
| `gated_tour` | The Area Director | yes | Corporate | - | Cool Head | Know-How | light | Corporate inspection tour: composure under inspection wins; your clever fixes bore them. |
| `unstamped_smile` | The Unstamped Smile |  | Paperwork | - | - | - | none | Kindness never put on paper: it weighs nothing. |
| `buried_report` | The Buried Report |  | Paperwork | - | - | - | none | The report that said the wheel was never loose. |
| `fall_guy_index` | District Safety Investigator | yes | Corporate | - | Know-How | Back Channels | light | Looking for a scapegoat: the calibration records (Know-How) prove the wheel was fine; deals in the back room feed the hunt. |
| `cc_protocol` | The CC Line |  | Paperwork | - | - | - | none | The CC line: paper that bypasses every gatekeeper. |
| `regional_desk` | The Regional Desk | yes | Corporate | - | Fired Up | Cool Head | heavy | Built to fossilize complaints: only a loud escalation (Fired Up) gets through; polite emails fossilize. |
| `sixth_in_line` | The Sixth in Line |  | The Public | - | - | - | none | Five ahead of you, still waiting. |
| `queue_wall` | The Queue Wall |  | The Public | - | - | - | light | Bodies pressing forward (was CONSTRUCT): it's people. |
| `register_blitz` | The Register Blitz |  | The Public | - | - | - | none | Every lane a fire. |
| `one_man_close` | The One-Man Close | yes | The Building | - | Know-How | Grunt Work | heavy | 40,000 square feet, one key: work smart (Know-How); you cannot out-grunt the building alone. |
| `blotter_regulars` | The Blotter Regulars |  | The Public | - | - | - | none | Weekly police-blotter visitors. |
| `grab_and_run` | The Grab-and-Run |  | The Public | - | - | - | none | Eleven seconds, empty shelf. |
| `claim_blizzard` | The Claim Blizzard |  | Paperwork | - | - | - | none | Everyone files claims on everyone. |
| `hostile_floor` | The Hostile Floor |  | Management | - | - | - | none | Two faces, one spine: floor politics. |
| `parking_draw` | The Parking Lot Draw | yes | The Public | - | Cool Head | Fired Up | none | A dispute walking to its cars, hand at the waist: de-escalate; anger gets someone hurt. |
| `overhaul_wall` | The Freight-to-Floor | yes | The Building | - | Grunt Work | Back Channels | heavy | The rebuild under a clock: pure work; talk doesn't move fixtures. |
| `aspirant_zero` | The Regional Audit | yes | Corporate | - | Grunt Work | Fired Up | light | The regional audit: a floor actually done right passes; losing your temper fails it. |
| `zero_report` | The Unrealistic Standard |  | Metrics | - | - | - | none | The unrealistic standard: a number. |
| `meat_grinder` | The Overnight Meat Grinder | yes | Metrics | - | Know-How | Grunt Work | light | Thirteen names a year: fix the system (Know-How); grinding harder feeds it. |
| `relocation_contract` | The Relocation Contract | yes | Paperwork | - | Fired Up | Cool Head | light | The collar that has been waiting: refuse it loudly; politeness signs it. |
| `interstate_gauntlet` | The Asphalt Gauntlet | yes | Inner Demons | - | Cool Head | Grunt Work | none | A hundred miles of headlights: a cool head gets you home; you can't muscle the commute. |
| `goalpost_cart` | The Moving Goalposts | yes | Metrics | - | Cool Head | Grunt Work | light | Moving goalposts: stop chasing and stand still; chasing harder moves them further. |
| `ohmar_enemy` | Ohmar, the Store Lead | yes | Management | - | Cool Head | Fired Up | light | The region's enforcer wants a reaction: give him calm, never anger. |
| `ownerless_building` | The Ownerless Building | yes | The Building | Cool Head | Fired Up | Cool Head | heavy | Four hours after close, nobody owns it: get fired up and demand the keys; the cold is its element. |
| `shingles_four` | The Fourth Signal | yes | Inner Demons | Fired Up | Cool Head | Fired Up | none | The fourth signal: same body, same lesson. |
| `redemption_schedule` | The Redemption Schedule | yes | Paperwork | - | Know-How | Grunt Work | light | Thousands owed for walking away: Know-How finds the clause; working harder won't pay it. |
| `the_alternative` | The Alternative | yes | Inner Demons | - | Integrity | Fired Up | none | The 3 AM visitor: Adriana in person (Integrity) is what answers it; anger feeds it. |
| `parting_shot_enemy` | The Parting Shot | yes | Inner Demons | - | Cool Head | Fired Up | none | "He'll be out in two months anyway": let it go (Cool Head); biting back proves it. |
| `pay_cut_weight` | The Pay Cut | yes | Inner Demons | - | Know-How | Grunt Work | none | Twenty-four thousand reasons to doubt yourself: your skills (Know-How) are worth more; working harder doesn't fix a pay cut. |
| `phantom_manager` | Aussie | yes | Management | - | Know-How | Grunt Work | none | The absentee salaried manager: the timestamps (Know-How) show he's never there; covering his shifts feeds the phantom. |
| `customer_grind` | The Customer Gauntlet | yes | The Public | - | Cool Head | Fired Up | light | The entitled and the abusive: de-escalate; anger escalates. |
| `final_balance_sheet` | The Final Balance Sheet | yes | Corporate | - | Integrity | Know-How | heavy | Everything the machine cost: Adriana's integrity is what it couldn't take; the machine knows every trick. |
| `azalia_enemy` | Azalia | yes | Management | - | Know-How | Cool Head | light | The write-up left unmade: do the process right (Know-How); patience is her stall. |
| `jay_dau_enemy` | Jay-Dau | yes | Management | - | Fired Up | Grunt Work | light | The friend on the clock: call him out (Fired Up); working harder just covers for him. |
| `amandy_enemy` | Amandy | yes | Management | Fired Up | Cool Head | Fired Up | light | Chaos in the aisles: calm it; her temper is her element. |
| `sriniviii_enemy` | Sriniviii | yes | Management | - | Grunt Work | Fired Up | light | The morning verdict: the finished floor is the answer; arguing loses. |
| `abdoolie_enemy` | Abdoolie | yes | Management | - | Fired Up | Cool Head | light | The flat cadence breaks when someone shows real feeling; calm just matches it. |

---

## 4. Coverage check

Kits as in the characters today (`hero` = the Floor Captain kit Todd uses in the first three fights; `todd_shop` for the rest;
`adriana` in person in four fights; `adriana_inspiration` everywhere else, no attacks). Breathe and Attune don't count.

### What each fighter is good against

| Fighter | Attack schools (proposed) | Strong (1.5+) against | Resisted (0.8) by |
|---|---|---|---|
| Todd (`hero`, Floor Captain kit, first 3 fights) | Grunt Work | Grunt Work: The Building | Grunt Work: Inner Demons |
| Todd (`todd_shop`, rest of the game) | Cool Head, Know-How, Grunt Work, Fired Up | Cool Head: The Public, Inner Demons; Know-How: Metrics; Grunt Work: The Building; Fired Up: Paperwork | Cool Head: Paperwork; Know-How: Corporate; Grunt Work: Inner Demons; Fired Up: The Public, Inner Demons |
| Adriana (in person, 4 fights) | Integrity | Integrity: Management, Inner Demons, Corporate | Integrity: Metrics |
| Adriana's Inspiration | (no attacks) | - | - |

### Results

### Today (current schools, families and matrix)
Fails (best party school < 1.0): 3
- `trench_unload` vs `freight_wall` (party hero, adriana_inspiration): Grunt Work 0.8
- `floor_war` vs `the_ringer` (party hero, adriana_inspiration): Grunt Work 0.8
- `mattie_t_showdown` vs `poisoned_email` (party hero, adriana_inspiration): Grunt Work 0.8
Members with no neutral-or-better school vs an enemy (party still covered): 5
- `trench_unload`: hero vs `freight_wall`
- `floor_war`: hero vs `the_ringer`
- `mattie_t_showdown`: hero vs `poisoned_email`
- `brick_wall_hearing`: adriana vs `grievance_file`
- `jury_showdown`: adriana vs `grievance_file`
No reachable weakness: (50 slots)
Enemy slots with a reachable weakness (>=1.5): 56 of 106
Member schools never strictly best in any fight they are in: none

### Proposed types, parties as listed today
Fails (best party school < 1.0): 0
Members with no neutral-or-better school vs an enemy (party still covered): 2
- `florida_three_am`: adriana vs `metrics_dashboard`
- `act6_final_balance`: adriana vs `metrics_dashboard`
No reachable weakness: `metrics_dashboard` (floor_war), `the_ringer` (floor_war), `poisoned_email` (mattie_t_showdown), `hostile_floor` (pueblo_claim_blizzard), `hostile_floor` (pueblo_paradox), `hostile_floor` (florida_morning_verdict)
Enemy slots with a reachable weakness (>=1.5): 100 of 106
Member schools never strictly best in any fight they are in: none

**Findings**
- **Today, 3 encounters fail** (Todd's first three fights; see above): every Floor Captain attack is PHYSICAL and is
  impaired by the Freight Wall's and the Ringer's PHYSICAL element and by the Poisoned Email's VOID family. With the
  proposal, none fail.
- **Todd's first three fights have one school.** He can only use Grunt Work, so the Dashboard, the Ringer and the Poisoned
  Email have no reachable weakness. Decision 6 (Todd starts with 2-3 spells) is the place to fix it: give him one
  non-Grunt attack from the start (Volt Snap or Coolant Chill), and the first fight teaches weaknesses through the Fluorescent Hum.
- **The Hostile Floor** (Management, in three Pueblo/Florida fights with `adriana_inspiration`) has no reachable
  weakness: Todd's shop kit has no Integrity or Back Channels. Fine for a minion; Back Channels in Todd's growing kit would fix it.
- **Adriana in person** has one attack (Truth Smite, Integrity), resisted by Metrics: she is stuck at 0.8 against the
  Dashboard in "The 3 AM" and "The Final Balance Sheet", and Todd covers it. Expected for the healer (plan 3.5: one attack).
- **Schools never the best choice:** none among Todd's four shop schools. **Back Channels and Growth have no attacks
  in any kit Todd uses today**: Night Shift, Shadow Doubt, Backroom Whisper and Drain Energy (Night Guardian) and Root Cause (no kit) exist but go unused
  once the class choice is removed (decision 6). They're the natural pool for Todd's later spell grants: Back Channels answers
  Management, Growth answers Metrics and Inner Demons.

---

## 5. Party spells whose school looks wrong

None in the kits in use. Every spell's school matches what it describes (Volt Snap is the impact gun, Coolant Chill
the radiator, Bay Heat the shop at full tilt, Truth Smite naming the truth). Two notes:
- **Todd's shop kit is 4 of 7 attacks Grunt Work** (Lube Line, Grease Clear, Tire Grind, Bay Charge). If Todd wants
  more variety, Bay Charge ("every bay at once, until the whole shop hums") could move to **Know-How**; not needed for coverage.
- The unused class kits (Process Engineer's four Know-How spells, Service Steward's heals) duplicate what Todd and
  Adriana already have, so only Night Guardian's Back Channels and Root Cause (Growth) add something new.

**Piercing candidates** (ignore armor; the Building and Corporate bosses are heavy): Volt Snap, Truth Smite.

---

## 6. For Todd to decide

1. The names, especially **Inner Demons** (the shingles, the pay cut, the 3 AM) and **The Public** for customers.
2. **"The Alternative" (`florida_three_am`)** is the memoir's suicidal-ideation chapter ("You do not defeat it with a spell. You
   refuse it with a name: Adriana."). Proposed: Inner Demons, weak to Integrity (Adriana in person), resists Fired Up. Todd
   may prefer this fight to have **no weakness callouts at all**: a "Weak!" or "Integrity gets through!" line there could
   read wrong. Same question, milder, for the Pay Cut and the Shingles fights.
3. Whether Todd's starting kit (decision 6) gets a second school from the first fight.
4. Which unused class spells become Todd's later grants (Back Channels and Growth proposed).
5. The weak = 2.0 / resist = 0.8 override rule.
6. Dropping most `selfElement` values (they're copied from movesets and make the party's own schools look resisted).
