# Wally's World: battle sprite brief

Generated from `art/sprite_roster.json` by `voice-rpg-engine/scripts/sprite_roster.py`; edit the roster, not this file.
Every fighter, enemy and boss is mapped to a sprite key below. A sheet named after its key, dropped into
`app/src/main/assets/game/sprites/sheets/`, appears in battle as soon as the game runs the sprite-ready engine.

A memoir told as a JRPG: eight years and five states inside a big-box retailer, its freight trenches, service bays and offices. The party is Todd and Adriana; most enemies are the forces of the job made into monsters (the freight wall, the fluorescent hum, the poisoned email, the dashboard), and the bosses are the managers and machines of the company. Keep the humans grounded and recognisable from `app/src/main/assets/portraits/` (Wally's associates wear a teal vest with orange piping and a yellow smiley badge); make the abstract enemies strange and readable, ordinary workplace objects with a face, limbs and menace, like the existing 20x26 sprites they replace. Tone: weary, sincere, darkly funny, never cartoonish about the hard moments.

**To draw: 47 sheets** (3 party fighters, 26 enemy families, 18 bosses). Everything else is a recolour of one of those.

## Style (every sprite)

- 16-bit SNES-era JRPG battle sprite, side view, facing RIGHT (the engine mirrors enemies to face the party).
- Limited palette (4-8 colours per sprite), 1 px dark outline, no anti-aliasing, transparent background.
- Cell 64x64 for party fighters and regular enemies (the body about 40-56 px tall); bosses 96x96 or 128x128 as listed.
- Soles on the same row in every frame (row 58 of a 64 cell, 90 of 96, 122 of 128); floating things put their lowest point or hover shadow there. The feet slice's bottom edge is the sole line.
- Nothing but the character in a frame: no labels, captions, frame names or text.
- Frame duration 190 ms unless a move needs faster frames; events in the tag user data, counted from 1 within the tag.
- Store palette: teal and orange uniforms, fluorescent white-green light, concrete grey, safety yellow; the service bays add oil black, tire rubber and red tool chests.
- Abstract enemies: an object first (a box stack, a monitor, a memo) with one or two features that make it alive (eyes, a mouth, arms); keep each silhouette distinct at 64 px.

## Animations (Aseprite tags)

- **Party fighters**: idle (4f loop), ready (4f loop: turn ready, weapon up), charge (4f loop: speaking a chant), cast (5f, release=4), attack (5f, impact=4), hurt (4f), ko (6f, ends lying down), victory (4f loop). A fighter who is also fought as a boss adds windup, charge_ultimate, ultimate (and death).
- **Regular enemies**: required idle (4f loop), attack (5f, impact=4), hurt (4f); recommended windup (4f loop), cast (5f, release=4), death (6f; else the engine shatters it).
- **Bosses**: required idle (4f loop), windup (4f loop), attack (5f, impact=4), cast (5f, release=4), hurt (4f), charge_ultimate (4f loop), ultimate (6-8f, release=5); recommended death (6-8f), taunt (4f), p2_idle, p2_attack... (second phase).

## Delivering a sprite

1. Save `<key>.png` and its Aseprite JSON export `<key>.json` in `app/src/main/assets/game/sprites/sheets/`, with the tags above and a `feet` slice.
   Previews go in `art/sprite-previews/`, never in the sheets folder.
2. Run `python3 ../voice-rpg-engine/scripts/sprite_lint.py . --fix`, then `../voice-rpg-engine/scripts/sprite_coverage.sh <game>`.
3. Compare it with everyone else in the game's gallery, **SPRITES** tab.
4. A recolour (listed under *Recolours*) needs no art; a sheet named after its own id replaces the recolour if you want it to differ.

## Party fighters (4, 64 px)

### `hero`: Todd, Hourly Associate

Portrait: `portraits/todd.jpg`.

Todd from portraits/todd.jpg in his first years: tired eyes with dark circles, messy brown hair, stubble, the teal Wally's vest with orange piping and a smiley badge over a grey T-shirt, work gloves, jeans and steel-toe boots; a box cutter on a lanyard. Determined slouch of someone on hour nine of an unload.

*Moves*: charge: plants his feet and breathes through it, shoulders rising; cast: throws a hand forward, a wave of willpower (release=4); attack: Freight Push, shoulder-drives forward as if moving a pallet; ko: drops to one knee, then sits against a box; victory: wipes his forehead, a small tired smile.

### `todd_shop`: Todd, Shop Manager

Portrait: `portraits/todd.jpg`.

The same Todd years later running the auto service bays: navy mechanic's work shirt with the sleeves rolled, the smiley badge on the chest pocket, grease on the forearms, a heavy pneumatic impact wrench in one hand, a shop rag in the back pocket, steel-toe boots. More confident stance than the associate.

*Moves*: charge: the impact wrench spins up, sparks at the socket; cast: Volt Snap / Coolant Chill / Bay Heat, points the wrench like a wand and a jet of sparks, coolant or heat shoots out (release=4); attack: Tire Grind, swings a tire iron or rolls a tire into the foe; ko: slumps against a tool chest; victory: spins the wrench and holsters it.

### `adriana`: Adriana

Portrait: `portraits/adriana.jpg`.

Adriana from portraits/adriana.jpg: long dark wavy hair, warm brown eyes, a tan cardigan over a soft grey top, jeans; calm, grounded posture. Her 'weapon' is steadiness itself: a warm golden shield of light she can raise (Unbroken Aegis) and a coffee mug she never spills.

*Moves*: charge: hand over heart, eyes closed, golden light gathering; cast: Lifeline Mend / Steady Presence, opens her hands and a warm gold glow flows forward (release=4); attack: Truth Smite, points and a clean beam of light strikes; ko: kneels, still upright; victory: a relieved smile, mug raised.

### `adriana_inspiration`: Adriana's Inspiration

Portrait: `portraits/adriana.jpg`.

Adriana as she fights beside Todd from far away (36 encounters): a translucent, softly glowing golden version of her, hovering a few pixels above the floor.

A recolour of `adriana` (no art needed unless it should differ).

## Enemy families (26, 64 px)

### `practice_dummy`: Shift Simulator

A battered training mannequin on a wheeled base wearing a teal vest, a laminated 'new hire' card on a lanyard, a blank face with a drawn-on smiley. Used by the voice tutorial.

*Moves*: attack: rocks forward on its base; death: tips over and rolls away.

Draws: Shift Simulator (Set to 'Associate': Off, construct/physical)

### `freight_wall`: The Freight Wall

A hulking golem built from stacked cardboard freight boxes and a broken pallet base, shrink-wrap trailing like torn skin, two dark gaps between boxes for eyes, box-flap arms. Leans forward like it's about to topple onto you.

*Moves*: attack: slams down with a box-stack arm; cast: shrink-wrap lashes out; windup: the stack sways.

Draws: The Freight Wall (Forty Eight Feet of Unopened Boxes, construct/physical)

Recolours:
- `interstate_gauntlet`: The Asphalt Gauntlet (A Hundred Miles of Headlights, construct/physical): the Asphalt Gauntlet: orange-and-white construction barriers instead of boxes, brake-light red eyes (a separate sheet would sell it better)

### `fluorescent_hum`: The Fluorescent Hum

The enemy in almost every fight: a long fluorescent tube creature hanging from a broken ceiling fixture on two chains, its ballast box a jaw that buzzes, cold white-green light flickering in waves along the tube, sparks at the ends. Floats; its lowest point is the fixture's dangling chain.

*Moves*: cast: Sigil Pulse, the tube strobes and a pulse of cold light rolls out; attack: Grinding Slab, swings down on its chains; idle: a slow flicker, the hum visible as little vibration lines.

Draws: The Fluorescent Hum (3 AM Ballast Whine, construct/cryomancy)

### `dashboard`: The Dashboard

A wall monitor on a rolling stand come alive: the screen a face of red and green gauges and a jagged line graph for a mouth, power cables for arms. The Hour-Occupancy Gauge, always in the red.

*Moves*: cast and attack: Bolt Volley / Suppressive Fire, the screen flashes and fires red metric bars like bolts.

Draws: The Dashboard (The Hour-Occupancy Gauge, construct/electromancy)

Recolours:
- `register_blitz`: The Register Blitz (Every Lane a Fire, flesh/electromancy): the Register Blitz: a POS register screen, every lane light blazing red

### `the_ringer`: The Ringer

Management's pet: a smug floor lead in a pressed teal vest, a phone handset on a coiled cord swung like a whip (the 'paging wand'), a clipboard tucked under the arm, chin up.

*Moves*: attack: lashes the handset cord; cast: War Cry, shouts into the handset and a page blares out.

Draws: The Ringer (Management's Pet, flesh/physical)

### `poisoned_email`: The Poisoned Email

A floating envelope-phantom: an open email window with a sickly purple glow, the envelope flap a fanged mouth, a cursor for an eye, a trailing tail of 'Reply All' threads. Hovers.

*Moves*: cast: Void Bolt / Siphon Essence, spits a purple message bolt; attack: Enveloping Dark, wraps around the target.

Draws: The Poisoned Email (Wasn't Ready, He Said, void/shadow)

Recolours:
- `redemption_schedule`: The Redemption Schedule (Thousands Owed for Walking Away, void/shadow): the Redemption Schedule: a payment table on parchment, a heavy chain dangling from it, cold blue instead of purple

### `bay_grime`: The Bay Grime

A creeping slab of oil-soaked concrete grime: a black, glistening sludge mound with a boot half-swallowed in it, rainbow oil sheen, a drain grate for a mouth.

*Moves*: attack: rears up and slaps down; windup: bubbles.

Draws: The Bay Grime (Oil-Soaked Concrete That Eats Your Boots, construct/physical)

### `crowd_mass`: The Queue Wall

Bodies pressing forward: a lumpy wall of impatient shoppers fused into one mass, many arms holding receipts, phones and return bags, several mouths open mid-complaint.

*Moves*: attack: the whole mass surges forward; cast: War Cry, a roar of complaints.

Draws: The Queue Wall (Bodies Pressing Forward, construct/physical)

Recolours:
- `customer_grind`: The Customer Gauntlet (The Entitled and the Abusive, flesh/physical): the Customer Gauntlet: redder and angrier, more fists
- `friday_rush`: The Friday Rush (A Line of Pickups Around the Block, flesh/physical): the Friday Rush: a line of service customers with pickup-truck headlights glaring behind them (a separate sheet with a truck would sell it better)

### `shopper`: The Sixth in Line

A single impatient shopper: phone held up, foot tapping, a full cart handle under one hand, a number ticket in the other.

*Moves*: attack: Aimed Shot, flings the number ticket; cast: Volley Shot, a barrage of 'Excuse me?'s as little speech-burst sparks (no text).

Draws: The Sixth in Line (Five Ahead of You, Still Waiting, flesh/physical)

Recolours:
- `grab_and_run`: The Grab-and-Run (Eleven Seconds, Empty Shelf, flesh/physical): the Grab-and-Run: a hooded shoplifter mid-sprint with an armful of electronics

### `tire_tower`: The Tire Tower

A teetering stack of mounted tires (rims and all) that has learned to walk: lug-nut eyes glinting from the top tire, a tire-iron arm, tread marks down its sides.

*Moves*: attack: Crush, topples its top tires onto the target; cast: Steam Vent, the valve stems hiss.

Draws: The Tire Tower (Forty Mounted Sets Waiting to Apologize, construct/physical)

### `memo`: The Retirement Memo

A tall, polite sheet of company letterhead with a red wax seal for a heart, folded paper arms, a neat corporate signature curling like a smile. Polite corporate execution.

*Moves*: cast: Void Bolt, fires paper cuts; attack: wraps the target like an envelope.

Draws: The Retirement Memo (Polite Corporate Execution, void/shadow)

Recolours:
- `parting_shot_enemy`: The Parting Shot ('He'll Be Out in Two Months Anyway', void/shadow): the Parting Shot: a crumpled grey note, the whisper that travels down the hall

### `camera_eye`: The Watchful Eye

A ceiling security camera dome on a tripod of cables, one red lens eye that never blinks, a little red recording light pulsing.

*Moves*: cast and attack: Bolt Volley, flashes and fires a red scan beam.

Draws: The Watchful Eye (Jury's Camera That Never Blinks, construct/electromancy)

Recolours:
- `hostile_floor`: The Hostile Floor (Two Faces, One Spine, construct/electromancy): the Hostile Floor: two lenses on one stalk, one warm and one cold (two faces, one spine)

### `faceless_suit`: The Man They Wanted

Upper management's favourite answer: a tall man in a black suit and red tie with no face at all, just smooth shadow, a briefcase in hand.

*Moves*: cast: Siphon Essence, the faceless head tilts and drains light; attack: briefcase swing.

Draws: The Man They Wanted (Upper Management's Favorite Answer, void/shadow)

### `file_folder`: The Grievance File

A fat manila file folder walking on its spine, papers spilling like a tongue, a red 'UNSUBSTANTIATED' rubber stamp for a fist (stamp face blank, no text).

*Moves*: attack: Thorn Lash, slams the stamp; cast: Choking Pollen, a puff of loose paper.

Draws: The Grievance File (Stamped 'Unsubstantiated' Before It's Read, verdant/nature)

Recolours:
- `claim_blizzard`: The Claim Blizzard (Everyone Claims on Everyone, verdant/nature): the Claim Blizzard: icy white, loose forms swirling around it
- `zero_report`: The Unrealistic Standard (Corporate Expectations, verdant/nature): the Unrealistic Standard: a red folder with a graph arrow shooting straight up

### `paper_storm`: The Blotter Regulars

A weather system of theft: a whirling funnel of torn price tags, empty hangers and blotter clippings with two hooded silhouettes inside it.

*Moves*: cast: Bramble Whip, the funnel lashes out; attack: sweeps across like a gust.

Draws: The Blotter Regulars (Weekly Visitors, a Weather System, verdant/nature)

### `shingles_flame`: The Fourth Signal

The body's scorecard: a writhing line of nerve fire shaped like a creature, red-orange blisters along its back, an angry glow; it hurts to look at.

*Moves*: cast: Shockwave, flares; attack: Crushing Blow, lashes like a whip of fire.

Draws: The Fourth Signal (The Body Keeps the Score, construct/pyromancy)

### `goalpost_cart`: The Moving Goalposts

A yellow American-football goalpost bolted to a rolling cart, wheels squealing as it rolls away just as you reach it; a little grin on the crossbar.

*Moves*: attack: rams forward on its wheels; windup: rolls back.

Draws: The Moving Goalposts (Mounted Firmly on Wheels, construct/electromancy)

### `calibration_gauge`: The Calibration Lapse

A service-bay torque wrench and pressure gauge fused into a gangly creature, a peeling expired calibration sticker over one eye, sparking at the joints.

*Moves*: cast: Bolt Volley, the gauge needle snaps and fires sparks.

Draws: The Calibration Lapse (Dead Sticker, Live Risk, construct/electromancy)

### `debt_machine`: The Bay Debt

Years of deferred maintenance: a rusted, leaking vehicle lift and compressor grown into one lumbering machine, peeling yellow paint, a dented tool chest for a body.

*Moves*: attack: Iron Slam with the lift arm; cast: Steam Vent from a cracked hose.

Draws: The Bay Debt (Years of Deferred Maintenance, construct/physical)

Recolours:
- `pay_cut_weight`: The Pay Cut (Twenty-Four Thousand Reasons to Doubt Yourself, void/shadow): the Pay Cut: grey and leaden, a heavy weight hanging from its arm

### `edict_scroll`: The Executive Edict

A corporate decree unrolling like a scroll, navy blue with gold dots and a red seal, its ends grown into grasping paper vines that root into the floor.

*Moves*: cast: Bramble Whip, the vines lash; attack: Thorn Lash.

Draws: The Executive Edict (Sold Out From Under the Floor, verdant/nature)

### `smile_badge`: The Unstamped Smile

A giant yellow smiley-face badge on a pin-back stalk, its smile too wide and its eyes faintly red; kindness that never weighs anything.

*Moves*: cast: Choking Pollen, beams a cloying golden glow; attack: bumps forward.

Draws: The Unstamped Smile (Kindness That Never Weighs, verdant/nature)

### `report_shredder`: The Buried Report

An office paper shredder that walks on its bin, a safety report half-swallowed in its teeth, strips of paper spilling out below.

*Moves*: attack: lunges and chomps; cast: sprays shredded strips.

Draws: The Buried Report (The Wheel Was Never Loose, verdant/nature)

Recolours:
- `final_balance_sheet`: The Final Balance Sheet (Everything the Machine Cost and Could Not Take, construct/physical): the Final Balance Sheet: a ledger book in place of the report, green and red columns

### `cc_line`: The CC Line

An ally among enemies: a chain of linked office phones and envelopes forming a coat-rack-like figure that reaches over every gatekeeper's head; cool white and silver.

*Moves*: cast: Void Bolt, a message zips along the chain; attack: the top handset swings down.

Draws: The CC Line (Bypass Every Smiling Gatekeeper, void/shadow)

### `ownerless_building`: The Ownerless Building

The store four hours after close: a dark storefront facade on stubby legs, the automatic doors a closed mouth, one aisle light left on for an eye.

*Moves*: attack: the facade leans in and slams; cast: the lights flicker off in a cold wave.

Draws: The Ownerless Building (Four Hours After Close, construct/cryomancy)

### `night_visitor`: The Alternative

The 3 AM visitor from the darkest chapter: a quiet, tall shadow in the shape of a person, edges dissolving like smoke, offering one open hand. Keep it abstract and still: no weapons, no wounds, nothing graphic. Its power is the silence around it.

*Moves*: cast: the darkness around it swells (no projectile); attack: reaches out slowly; death: fades into morning light (the player refuses it).

Draws: The Alternative (The 3 AM Visitor, void/shadow)

### `aussie`: Aussie

Aussie from portraits/aussie.jpg: stocky, scowling, navy polo, lanyard badge, clipboard with an angry spreadsheet; the absentee salaried manager who only has one tool, the collective threat.

*Moves*: attack: smacks the clipboard; cast: waves the spreadsheet, red cells flying out.

Draws: Aussie (The Absentee Salaried Manager, void/shadow)

## Bosses (18 to draw, each its own sprite)

### `mattie_t_enemy`: Mattie-T, Store Manager (96 px)

Mattie-T from portraits/mattie_t.jpg: bald, light-blue dress shirt and dark tie, smiling behind a desk with a computer; the man who sent the 'not ready' email before you walked in.

*Moves*: attack: Crushing Blow (slams the keyboard); cast: Shockwave (hits Send, a purple envelope bolt); charge_ultimate: types furiously, the monitor glowing; ultimate: Cataclysm, a storm of emails swirling around him.

Element: flesh/shadow.

### `jury_enemy`: Jury, Store Manager (96 px)

Jury from portraits/jury.jpg: short auburn hair, navy blazer, arms crossed, a wall of security monitors glowing behind her; casual malice.

*Moves*: attack: points and says it twice (a sharp shockwave); cast: the monitors flicker and fire red scan lines; charge_ultimate: steps forward, witnesses' silhouettes behind; ultimate: Cataclysm, a grievance form slams down from above.

Element: flesh/shadow.

### `shingles_fire`: The Shingles Fire (96 px)

The first outbreak as a boss: a towering column of nerve fire in the shape of a burning line across a forehead, blistering red and orange, flickering with pain. Appears three times, each angrier.

*Moves*: attack: lashes; cast: flares; charge_ultimate: burns white-hot; ultimate: Cataclysm, erupts across the whole arena. p2_ (optional): the hungrier later outbreaks.

Element: construct/pyromancy.

### `gated_tour`: The Area Director (96 px)

Corporate inspection tour: an Area Director in a sharp charcoal suit and polished shoes, with five more suits silhouetted behind (one sprite, the pack as a shadowy backdrop), a tablet held like a gavel.

*Moves*: attack: taps the tablet, a red X slams down; cast: the suits behind all point at once; charge_ultimate: the pack gathers; ultimate: the whole inspection descends.

Element: flesh/shadow.

### `fall_guy_index`: District Safety Investigator (96 px)

A safety investigator in a hi-vis vest over a dress shirt, hard hat under one arm, sliding a rewritten report across an invisible table with a pen offered for your signature.

*Moves*: attack: slaps the report down; cast: the pen glows, a signature line snakes toward you; ultimate: a loose wheel rolls in and the blame lands.

Element: flesh/shadow.

### `regional_desk`: The Regional Desk (128 px)

Built to fossilize complaints: a huge dark-wood executive desk on legs, three ringing phones and a calendar for a face, drawers that open as mouths full of stacked tickets.

*Moves*: attack: a drawer slams out; cast: the phones ring and fire bolts; charge_ultimate: every phone lights up; ultimate: an avalanche of fossilised tickets.

Element: construct/electromancy.

### `one_man_close`: The One-Man Close (128 px)

Midnight, forty thousand square feet of dark: the whole store as a looming silhouette, rows of dead aisle lights, a single key glinting at its heart; the empty building pressing in.

*Moves*: attack: the dark leans in; cast: the lights go out aisle by aisle in a wave; ultimate: every door slams at once.

Element: construct/shadow.

### `parking_draw`: The Parking Lot Draw (96 px)

A dispute walking to its cars at eleven at night: two shadowy figures facing off under a sodium parking-lot light, hands hovering near their waistbands. Tense, not violent: no weapons drawn.

*Moves*: attack: the figures surge forward; cast: headlights flare; ultimate: the light pole flickers and the tension snaps (a flash, no gunfire).

Element: void/shadow.

### `overhaul_wall`: The Freight-to-Floor (128 px)

The overhaul all at once: a giant freight wall golem with bins and topstock for armour and a big red countdown clock set in its chest.

*Moves*: attack: Crushing Blow with a pallet fist; cast: boxes rain down; charge_ultimate: the clock ticks faster; ultimate: the whole rebuild collapses forward.

Element: construct/physical.

### `aspirant_zero`: The Regional Audit (96 px)

Pressure from above: a towering regional director in a grey suit wielding an oversized clipboard, a magnifying glass eye, checklist ribbons trailing.

*Moves*: attack: Iron Slam with the clipboard; cast: Steam Vent, the magnifying glass focuses a hot beam; ultimate: every checkbox turns red.

Element: construct/shadow.

### `meat_grinder`: The Overnight Meat Grinder (128 px)

Thirteen names, numbered: a huge industrial grinder machine in the dark backroom, a conveyor belt mouth, red warning lights, worn name badges hanging off its rim like trophies (no readable names).

*Moves*: attack: the belt drags forward; cast: the warning lights flare; charge_ultimate: the grinder revs; ultimate: Cataclysm.

Element: construct/pyromancy.

### `relocation_contract`: The Relocation Contract (96 px)

The collar that has been waiting: a long contract document coiling like a serpent, a heavy golden collar open at its head, clawback figures as scales.

*Moves*: attack: lunges with the collar; cast: the contract tightens; ultimate: the collar snaps shut around the arena.

Element: void/shadow.

### `azalia_enemy`: Azalia, Store Manager (96 px)

Azalia from portraits/azalia.jpg: warm smile, short brown hair, the teal vest with smiley badge over a mustard shirt; weaponised kindness that cancels every consequence.

*Moves*: attack: a gentle pat that hits like a hammer; cast: beams a golden smile that dissolves a write-up; ultimate: a flood of smiley badges.

Element: flesh/nature.

### `jay_dau_enemy`: Jay-Dau, Store Manager (96 px)

Jay-Dau from portraits/jay_dau.jpg: bald, big grin, teal vest over a dark shirt, a stack of quarterly reports under one hand; friend by daylight, hell on the clock.

*Moves*: attack: slams the reports; cast: the grin flips to a glare; p2_ (optional): the friendly face gone. Ultimate: quarterly pressure crashing down.

Element: flesh/shadow.

### `amandy_enemy`: Amandy, Store Lead (96 px)

Amandy from portraits/amandy.jpg: dark hair pulled back, teal vest, a walkie-talkie raised, arms crossed; the screaming assistant manager at full tilt.

*Moves*: attack: shouts into the radio (a red shockwave); cast: fire, the redone plan flung at you; ultimate: a screaming storm of demands.

Element: flesh/pyromancy.

### `sriniviii_enemy`: Sriniviii, Store Manager (96 px)

Sriniviii from portraits/sriniviii.jpg: neat dark hair, teal vest over a white shirt, hands clasped, a polite smile; the morning verdict after every overnight.

*Moves*: attack: a sharp gesture; cast: wheels the goalposts away; ultimate: the verdict lands.

Element: flesh/shadow.

### `abdoolie_enemy`: Abdoolie, Store Manager (96 px)

Abdoolie from portraits/abdoolie.jpg: thin, grey work shirt with the smiley badge, hands at his sides, a cold stillness and flat declarative stare; he sounds like Ohmar.

*Moves*: attack: a pause, then a cold strike; cast: a ripple of silence; ultimate: the cadence repeats until the room freezes.

Element: flesh/shadow.

### `ohmar_enemy`: Ohmar, the Store Lead (96 px)

Ohmar from portraits/ohmar.jpg: the biggest man in the building, dark turban, black polo with the smiley badge, arms folded, a stillness that does the threatening. Never shouts.

*Moves*: windup: leans forward, arms still folded; attack: Heavy Slam, a hand flat on the table; cast: Shockwave, a flat declarative stare that ripples out; charge_ultimate: the closed door, the formal chair, the pause before the question; ultimate: Cataclysm, the voice never rises and the room freezes.

Element: flesh/shadow.

## Not drawn: remove from the game

These enemies aren't reached by the story; remove them (and their encounters) from `enemies.json` at the sprite rollout instead of drawing them, or the sprite contract will block the release:
- `paperwork_tide`: The Paperwork Tide (Violation After Violation After Violation, verdant/nature): in no encounter (The Blotter Regulars took its sprite)
- `paralysis_smile`: The Paralysis of Kindness (No Consequence Follows, verdant/nature): boss in no encounter (Azalia's fight uses The Unstamped Smile)
- `paradox_face`: The Paradox of Jay-Dau (Friend by Daylight, Hell on the Clock, flesh/shadow): boss in no encounter (Jay-Dau's own fight covers it)
- `abdoolie_ghost`: Abdoolie's Ghost (The Voice That Sounds Like Ohmar, void/shadow): in no encounter (Abdoolie fights in person)

## Notes for the game

- Adriana's Inspiration fights in 36 encounters as a recolour of Adriana; draw her own sheet (a floating, glowing pose set) if the recolour isn't enough.
- The unused enemies under 'remove' can stay if they're meant for a future chapter; then each needs a sheet before release.
