# Image Prompts — The Squeeze: A Wally's World Memoir

Copy-paste-ready Gemini 2.5 Flash Image / Imagen 3 prompts for every graphical asset the game
actually loads. Each block is self-contained: paste the whole block into Gemini and say
"generate". Deliver at **1280x720 landscape** (title + story backgrounds) or **640x800
portrait** (character portraits) to match the engine's asset loaders.

**Do not hand-edit these files.** They are the in-repo placeholders the engine loads from
`app/src/main/assets/`. A generated image replaces the matching file name.

---

## Global rule 1 — the Melting Smiley rule (applies to EVERY prompt)

Every smiley-face graphic in the entire game — price badges, hanging store signs, wall posters,
uniform pins, background details, the title card — **must be a melting smiley**: the iconic
round face drooping and running like warm wax, eyes sagging, the smile smearing downward. No
normal, happy, intact smiley faces anywhere. This is the visual identity of the whole campaign.
If a prompt below doesn't call it out explicitly, add "with a melting smiley" to whatever smiley
the scene contains.

## Global rule 2 — signage text (applies to EVERY prompt)

In-store wall signage may read "Always Low Morale" (the campaign's own inverse slogan) as plain
wall graphics. Do **not** use the real "Everyday Low Price", "Always Save Money", "rollback",
"Always" slogans of any real chain, the yellow spark, or any real retailer's wordmark/logo. This is a
fictional megastore named **Wally's World**; keep every real-brand mark out by construction.
No barcodes, no real logos, no founder likenesses, no real store names.

## Style header (paste before any prompt for consistency)

> Gritty but warm editorial photography, muted early-2000s American retail toning, slightly
> desaturated mustard-and-steel palette, soft fluorescent overhead light, honest working-class
> portraiture, subtle film grain, photorealistic, 35mm. No real logos, no barcodes, no text
> except what the prompt itself names and the mandatory melting-smiley graphics.

---

## 1. Title screen background
**File:** `app/src/main/assets/story/squeeze_title.jpg` (1280x720)
**Also burned as the adaptive-launcher artwork source (`app-icon.jpg` logo family).**

> Wide establishing shot of a giant fictional superstore front from across a huge rain-slicked
> parking lot at dusk. The building stretches for blocks under mustard-yellow signage reading
> "WALLY'S WORLD" in bold rounded letters (no other text). Warm light spills from the glass
> entrance; a lone orange-vested employee pushes a long train of carts toward the door, and the
> giant sign above the entrance carries a single **melting smiley** — the face drooping with wax
> running down it. Overhead low clouds, a faint rainbow, a distant pickup truck. Nostalgic,
> slightly melancholy early-2000s retail grandeur. No real logos, no real brand marks.

## 2. Front-end / registers scene
**File:** `app/src/main/assets/story/squeeze_utah_front_end.jpg` (1280x720)

> Interior of a cavernous fictional superstore checkout lobby in a Utah-frontier-styled morning:
> dozens of register lanes under buzzing fluorescent tubes, worn teal-and-orange employee vests,
> shoppers queued with full carts. A weary older cashier waves kindly while the young freight
> associate (Todd) struggles to hoist a heavy appliance onto the belt. Behind the registers a
> hanging sign shows a big **melting smiley**, the wax face dripping. Overhead speaker grilles,
> chipped tiles, warm but tired light. No text, no real logos.

## 3. Trench / floor-stocker scene
**File:** `app/src/main/assets/story/squeeze_utah_trench.jpg` (1280x720)

> Low-angle shot deep inside a giant megamart's back-stock "the trench" — a long canyon of
> tall steel racking stacked with pallets of boxes. A young freight associate in an orange vest
> walks a thin aisle holding a heavy cardboard box, head bowed with exhaustion. Dust motes in a
> shaft of fluorescent light, forklift silhouette far behind, torn shrink-wrap hanging. On one
> pallet a lone **melting smiley** sticker droops. Moody, cinematic, claustrophobic scale.
> No text, no logos.

## 4. Office / manager's desk
**File:** `app/src/main/assets/story/squeeze_utah_office.jpg` (1280x720)

> A cramped back-office inside a big-box store: cluttered desk with an old CRT monitor showing a
> green inventory spreadsheet, office chair, wall of laminate shelving piled with file boxes, a
> single frosted window looking onto the sales floor. A weary store manager in a teal shirt with
> an orange tie leans back with a clipboard while the young associate stands in the doorway. On
> the wall hangs a **melting smiley** poster, face running. Fluorescent cast. No readable text.

## 5. Sales floor / center aisle
**File:** `app/src/main/assets/story/squeeze_utah_floor.jpg` (1280x720)

> Overhead-ish wide shot of the vast main aisle of a fictional megastore: towering shelves of
> merchandise in neat rows, huge wall graphics in muted mustard (no real text) reading only
> "ALWAYS LOW MORALE" as plain wallpaper on otherwise bare walls. Shoppers with carts,
> orange-vested employees stocking shelves with a pallet jack, a PA speaker hanging from the
> ceiling. A giant **melting smiley** drinks from the ceiling on a hanging banner, wax dripping.
> Bright but flat fluorescent light, busy but orderly. No real logos, no barcodes.

## 6. Todd — the hero
**File:** `app/src/main/assets/portraits/todd.jpg` (640x800, portrait)

> Middle-distance portrait of a young man, early 20s, wearing a cheap teal-and-orange employee
> vest over a wrinkled white polo. Nametag-less; instead a **melting smiley** button on the vest,
> face running. He looks tired but quietly determined, slight stubble, messy brown hair, one
> eyebrow raised, holding a folded cardboard box under his arm. Studio-style editorial portrait
> with soft fluorescent key light, plain slightly-blurred superstore aisle behind him, muted
> mustard palette. 35mm, photorealistic. No real logos.

## 7. Jodie — the floor's senior hand (a man, late 60s)
**File:** `app/src/main/assets/portraits/jodie.jpg` (640x800, portrait)

> Editorial portrait of a man in his late 60s, the floor's senior hand — very short, bristly
> white hair, weathered kind face, strong forearms, wearing the worn teal-and-orange employee
> vest over a flannel shirt. He holds a clipboard with a yellow highlighter tucked behind his
> ear勝利. On the clipboard, a custom three-tier name badge — top tier: a small **melting smiley**
> icon on blue with the text "blah blah sometimes"; middle tier: a plain white strip reading
> "401000500"; bottom tier: a blue strip reading "aka jodie". The badge text is small and only
> half-readable in the photo (editorial do-not-fully-render instruction) but unmistakably in
> that three-tier shape. Soft back-office light, honest working-class warmth. 35mm
> photorealistic. Melting smiley only; no real logos.

## 8. Mattie-T — store manager (a man)
**File:** `app/src/main/assets/portraits/mattie_t.jpg` (640x800, portrait)

> Editorial portrait of a man in his late 30s, balding, wearing a tidy blue dress shirt with a
> tie, sitting in a manager's swivel chair at a computer desk. Behind him a frosted window and a
> wall poster of a **melting smiley** (face running) done in the muted brand palette. Blue-hour
> palette lighting — cool dusk light through the window, warm face light from the CRT. He looks
> weary but sharp, glasses low on his nose, one hand resting on a well-worn clipboard. 35mm
> photorealistic editorial. The melting smiley is the only graphic; no real logos, no readable
> text.

## 9. Narrator / storyteller
**File:** `app/src/main/assets/portraits/narrator.jpg` (640x800, portrait)

> Mysterious but warm portrait of an unseen storyteller represented as a softly glowing
> silhouette — a faintly humanoid shape of warm hearth-light with two bright eyes, no distinct
> face, against a deep plum-black background with subtle book-page texture. Impressionistic,
> calm, inviting, slightly magical memoir-nostalgia. Loose painterly glow, NOT photorealistic
> (this one is intentionally abstract). No text.

---

## Act 2 — Lamar, Colorado

## 10. Lamar — the highway oasis / service shop
**File:** `app/src/main/assets/story/squeeze_colorado_lamar.jpg` (1280x720)

> Wide shot of a fictional megastore service shop on a flat high-plains highway corridor in
> winter: six bays under a sagging canopy, a line of semi-trucks and dusty pickups pulled up at
> the pumps, faded orange-and-teal equipment (no readable text). A lone shop manager in a teal
> vest stands under the canopy with a clipboard, breath steaming in the cold, a stack of oil jugs
> by the bay door. A **melting smiley** hangs on the canopy sign, the wax face running in the
> wind. Low winter sun, long shadows, honest small-town commerce. No real logos, no readable
> text.

## 11. Lamar — the store floor under the new watch
**File:** `app/src/main/assets/story/squeeze_colorado_store.jpg` (1280x720)

> Interior of a big-box store floor gone quiet and tight: perfectly neat aisles with not a single
> worker chatting, ceiling-mounted cameras every few rows, an orange-vested associate glancing
> over their shoulder, a store manager's silhouette watching from the mezzanine. A far wall reads
> "ALWAYS LOW MORALE" in muted mustard as plain wallpaper, and a **melting smiley** poster droops
> on an endcap. Flat fluorescent light, the atmosphere of being watched. No real logos, no
> readable text.

## 12. Lamar — the area office / the brick wall
**File:** `app/src/main/assets/story/squeeze_colorado_office.jpg` (1280x720)

> A fluorescent hallway and small area office inside a big-box store: a stack of file folders on a
> plastic office desk, one folder open showing a single word stamped across a page —
> "UNSUBSTANTIATED" (half-readable, editorial do-not-fully-render instruction) — a tired couple
> sitting across from an empty investigator's chair, a frosted-glass meeting-room door behind. A
> **melting smiley** coffee cup on the desk, face running. Cold institutional light, muted
> mustard accents. No real logos, no readable text except the one half-read stamped word.

## 13. Lamar — the community hall / Christmas party
**File:** `app/src/main/assets/story/squeeze_colorado_hall.jpg` (1280x720)

> A rented community hall set for an awkward office holiday party under harsh fluorescent glare:
> paper tablecloths, a punch bowl, sad catering trays, cheap tinsel. A sharp-faced store manager
> in a neat blazer stands mid-laugh with a drink while a weary shop manager in a teal vest stands
> apart, two witnesses glancing between them. A drooping **melting smiley** balloon and a garland
> banner frame the scene. Ugly lighting, social dread. No readable text, no real logos.

## 14. Lamar — the road out
**File:** `app/src/main/assets/story/squeeze_colorado_road.jpg` (1280x720)

> A packed box truck in a gravel driveway at dusk on the Colorado high plains: furniture lashed
> under load straps, the house behind it dark and emptied, a tall figure loading the last box
> with one hand pressed to his forehead beneath the brim of his cap. A single **melting smiley**
> sticker droops on the last box. Flat empty highway in the distance, cold blue dusk light, the
> truck's taillights glowing red. No readable text, no real logos.

## 15. Miss Trudy — legacy store manager
**File:** `app/src/main/assets/portraits/trudy.jpg` (640x800, portrait)

> Editorial portrait of a warm, weathered woman in her 60s — a legacy store manager. Silver hair
> pulled back, kind creased eyes, a teal-and-orange vest over a comfortable cardigan, a worn
> **melting smiley** button on the collar. She smiles with real warmth, tired but genuine,
> holding a plastic coffee cup. Soft back-office light, blurred storefront behind her. 35mm
> photorealistic, muted mustard palette. No name tags, no real logos.

## 16. Jury — the new store manager
**File:** `app/src/main/assets/portraits/jury.jpg` (640x800, portrait)

> Editorial portrait of a sharp-faced woman in her 40s — a newly installed store manager known
> for surveillance. A neat dark blazer over a teal shirt, a thin smile that doesn't reach flat
> eyes, arms crossed, standing in a doorway with a wall of security monitors faintly blurring
> behind her. A small **melting smiley** pin on the lapel, face running. Cool fluorescent light,
> brittle tension. 35mm photorealistic. No name tags, no real logos, no readable text.

## 17. Adriana — Todd's wife
**File:** `app/src/main/assets/portraits/adriana.jpg` (640x800, portrait)

> Editorial portrait of a capable, quietly tired woman in her early 30s — the protagonist's wife.
> Wavy dark hair, warm intelligent eyes with dark circles behind them, an open cardigan over a
> blouse, one hand folded on a stack of papers beside a mug of coffee. Soft warm kitchen light
> against a blurred lamp-lit window. She looks kind, steady, and quietly furious. 35mm
> photorealistic, honest working-class warmth. No name tags, no real logos, no readable text.

## 18. Cap'n Skagg — area manager
**File:** `app/src/main/assets/portraits/skagg.jpg` (640x800, portrait)

> Editorial portrait of a weathered, big-hearted man in his 50s — a veteran area manager. Broad
> shoulders, salt-and-pepper close-cropped hair, deep laugh lines, an open-collar shirt under a
> well-worn jacket with a small **melting smiley** pin, face running. He stands on a truck-stop
> apron with a semi and the dusk high plains behind him, one hand on his hip, looking at you with
> knowing, kind eyes. 35mm photorealistic, warm working-class dignity. No name tags, no readable
> text, no real logos.

---

## Act 3 — The Georgia–South Carolina Borderlands

## 19. State-line commute
**File:** `app/src/main/assets/story/squeeze_carolina_commute.jpg` (1280x720)

> Pre-dawn on a two-lane country road crossing from Georgia into South Carolina: a rented farmhouse with a single warm porch light shrinking in the side mirror, kudzu and scrub pines along the shoulder, a green highway sign for the state line (no readable text), low banks of fog, and a tired sedan in the middle distance heading toward a flat, distant megastore. A thermos on the dash, a folded orange vest on the passenger seat. Gritty but warm editorial tone, muted early-2000s palette, soft fluorescent glow from the big box on the horizon. No real logos, no barcodes, no text except one green state-line sign rendered half-read.

## 20. Gated hierarchy / leadership tour
**File:** `app/src/main/assets/story/squeeze_carolina_store.jpg` (1280x720)

> Wide interior shot of a big-box store's main aisle during a leadership walkthrough: a small pack of executives in pressed shirts and polished shoes being shown around by a single smiling store manager, while a line of junior salaried managers in teal-and-orange vests stand at the edge of the sales floor, clearly kept out, watching through the endcap stacks. Above them a hanging banner carries a single **melting smiley** (wax face dripping), and a far wall reads "ALWAYS LOW MORALE" as plain muted wallpaper. Fluorescent light, empty-cart silence, tension in the bodies. No real logos, no readable badges.

## 21. The neglected service shop / paralysis of kindness
**File:** `app/src/main/assets/story/squeeze_carolina_bays.jpg` (1280x720)

> Interior of a run-down big-box service shop: six bays under a sagging roof, worn toolboxes with missing wheels, unlabeled parts bins, a lift that looks decades old, work-order boards jammed with yellow tickets. A tired shop manager in a teal vest inspects a greasy torque wrench while green apprentices watch him from a distance, hopeful and wary. A peeling wall poster of a **melting smiley** hangs by the office door, wax running down its face. Warm-but-tired fluorescent light, honest working-class grit. No real logos, no readable text.

## 22. The safety breach / regional office
**File:** `app/src/main/assets/story/squeeze_carolina_office.jpg` (1280x720)

> A fluorescent-lit hallway and office at the back of a big-box store: a small manager's desk stacked with binders and a loose-wheel report, a single warm CRT monitor showing a spreadsheet, frosted glass doors leading down a corridor. An exhausted shop manager in a teal vest stands at the desk holding a printed complaint, one hand on a keyboard, a hard copy of the report visible on the desk. On the wall a **melting smiley** poster droops. Tense, quiet, slightly claustrophobic. No real logos, no readable text.

## 23. The second scar / road out of the borderlands
**File:** `app/src/main/assets/story/squeeze_carolina_road.jpg` (1280x720)

> Dusk on a scrub-pine highway pointed west out of the borderlands: a rented box truck loaded to the seams with furniture and boxes, taillights glowing, Georgia pines and a dark porch light receding behind it. A scarred, tired man in an orange vest sits at the wheel, one hand on the dash, a bandage edge visible above his eyebrow. A single **melting smiley** sticker droops on the last cardboard box strapped to the load. Long shadows, warm dying light, a quiet road into the mountains ahead. No real logos, no readable text.

## 24. Azalia — the borderlands store manager
**File:** `app/src/main/assets/portraits/azalia.jpg` (640x800, portrait)

> Editorial portrait of a warm, soft-featured woman in her late 40s — the store manager of a neglect-plagued big-box service shop. She wears the teal-and-orange vest over a button-up blouse, a worn **melting smiley** button on the chest, face running like warm wax. She smiles kindly, genuinely, eyes that look at you with real care — and just behind the warmth, a faint brittleness, the small tell of someone who has never once stamped a consequence. Soft fluorescent office light, blurred service-shop aisle behind her, muted mustard palette. 35mm, photorealistic. No real logos, no name tags.

---

## Act 4 — Pueblo, Colorado

## 25. The one-man close
**File:** `app/src/main/assets/story/squeeze_pueblo_close.jpg` (1280x720)

> Wide interior of a big-box store front end at closing time: every open register backed up six deep, a blinking service-desk beacon far off, carts jammed at the doors. In the middle of the teal-and-orange crowd a single manager in a teal vest moves hard between two lanes, one hand already reaching for the walkie at his hip, looking back over his shoulder at a customer holding up six fingers. A hanging **melting smiley** banner droops over the check lanes, wax running. Harsh evening fluorescent light, late-shift desperation, the loneliness of a building run by one person. No real logos, no readable text.

## 26. The backroom overhaul offer
**File:** `app/src/main/assets/story/squeeze_pueblo_backroom.jpg` (1280x720)

> A cavernous big-box backroom at nine in the morning: a folding table loaded with coffee carafes and legal pads, a wall-size whiteboard scribbled with freight-flow diagrams, and a row of uncomfortable managers in pressed shirts listening to a speakerphone on the table. One exhausted manager in a teal vest stands slightly apart, arms crossed, the only one looking at the whiteboard with real understanding. A **melting smiley** poster peels on the steel column beside the dock door. Warm industrial light, dust in the air, the weight of a company restructuring itself. No real logos, no readable text.

## 27. The freight-to-floor overhaul
**File:** `app/src/main/assets/story/squeeze_pueblo_overhaul.jpg` (1280x720)

> Big-box backroom and sales-floor seam mid-rebuild: a pure unload line running like a rail from the dock — associates passing cases hand to hand in a single fluid motion — while across the aisle a bin-and-topstock crew works a tall legion of labeled shelves. In the foreground a manager in a teal vest walks the line, clipboard in one hand, the whole building in motion around him. A far wall reads "ALWAYS LOW MORALE" in muted mustard, and a **melting smiley** sticker droops on a pallet. Bright humming fluorescent light, organized energy, a machine that finally runs. No real logos, no readable text.

## 28. The education of Richard
**File:** `app/src/main/assets/story/squeeze_pueblo_training.jpg` (1280x720)

> A small fluorescent office inside a big-box store: a young corporate climber in a freshly pressed shirt and sharp new badge holds a stocking report upside-down and slightly sideways, smiling with practiced confidence, while a tired veteran manager in a teal vest points at a bin diagram on a whiteboard with patient, knowing patience. A single **melting smiley** coffee mug sits between them, face running. Warm-though-institutional light, the comedy and tragedy of a man being taught his own job by the man underneath him. No real logos, no readable text.

## 29. The store manager's office — the paradox
**File:** `app/src/main/assets/story/squeeze_pueblo_office.jpg` (1280x720)

> The smoke-gray interior of a big-box store manager's office: a broad desk stacked with freight reports, a wall of scheduled shifts, and three figures — a warm, broad-smiling store manager in shirtsleeves leaning against the desk; beside him a small, thin, Hispanic woman in a store-lead vest with a hostile, flat stare; and a slightly heavier-set Hispanic woman with a serene sweet smile that doesn't quite reach her eyes, one hand resting on a file folder. A **melting smiley** clock droops on the wall. Cold fluorescent light, polite false warmth, the colleague-physics of an office where smiles do subtraction. No real logos, no readable text.

## 30. The overnight graveyard
**File:** `app/src/main/assets/story/squeeze_pueblo_overnight.jpg` (1280x720)

> A big-box sales floor at three in the morning: pallets of freight breathing in near-darkness, the only light a row of emergency fluorescents and the red glow of a dock sign, no people anywhere. In the middle distance a single silhouette in a teal vest stands in the wide aisle, the whole hundred-thousand-square-foot building pressing in around them. On a steel column a **melting smiley** poster has sagged into an almost skull-like run. Abandoned silence, the loneliness of a machine run by no one, the graveyard shift. No real logos, no readable text.

## 31. The road to Florida
**File:** `app/src/main/assets/story/squeeze_pueblo_road.jpg` (1280x720)

> Near-dawn on a highway stretching east out of the high plains toward a flat, soulless horizon: a packed box truck with taillights glowing, the Pueblo sprawl and its big-box slab receding in the mirror, a folded relocation-contract folder with a small **melting smiley** sticker on the corner lying on the dash beside a thermos and a billfold. The driver's hand on the wheel shows a fresh bandage work at the edge of a scarred forehead above the brim of the cap. Cold blue dawn against the orange sodium of the lot behind, a collar already around the next store. No real logos, no readable text.

## 32. Jay-Dau — store manager, Pueblo
**File:** `app/src/main/assets/portraits/jay_dau.jpg` (640x800, portrait)

> Editorial portrait of a charismatic man in his 40s — a big-box store manager. Broad smile, warm coffee-colored skin, a teal-and-orange vest over a crisp dark shirt, one hand resting on a stack of overnight reports. The face splits evenly down the middle: the left side warmly lit and genuinely friendly, the right side falling into shadow, flat and corporate-serious. A small **melting smiley** button on the collar, face running. Soft-focus back office behind him, muted mustard palette. 35mm photorealistic. No name tags, no real logos, no readable text.

## 33. Amandy — store lead, Pueblo
**File:** `app/src/main/assets/portraits/amandy.jpg` (640x800, portrait)

> Editorial portrait of a small, thin Hispanic woman in her 30s — a big-box store lead. Tightly pulled-back hair, a teal store-lead vest over a black shirt, arms crossed, chin up, a hard flat stare with no warmth in it and every word of the day held behind closed lips. One hand holds a dead walkie. Harsh fluorescent office light, the posture of someone who runs a shift by volume and never says thank you. 35mm photorealistic, muted mustard palette. No name tags, no real logos, no readable text.

## 34. Steffie — store lead, Pueblo
**File:** `app/src/main/assets/portraits/steffie.jpg` (640x800, portrait)

> Editorial portrait of a slightly heavier-set Hispanic woman in her 30s — a big-box store lead. Average height, soft round face, warm glossy smile that looks genuinely kind, one hand gently resting on her chest in an open-heart gesture — while the other hand, half-hidden behind a file folder, is slightly tensed. Eyes that are warm on the surface and flat just behind it. Teal store-lead vest over a blouse, small **melting smiley** pin, face running. Soft office light blurring into shadow at the edges. 35mm photorealistic. No name tags, no readable text.

## 35. Richard — regional compliance aspirant
**File:** `app/src/main/assets/portraits/richard.jpg` (640x800, portrait)

> Editorial portrait of a young man in his late 20s — a regional compliance manager on his way up the corporate ladder. Broad-shouldered, freshly pressed light-blue shirt, a crisp new badge, hair styled stiffly, a big gleaming smile of practiced confidence. He holds a stocking report folded in a way that reveals he has no idea how to read it — but the smile assures you otherwise. A single **melting smiley** pin droops on his lapel, face running. Clean fluorescent light, boardroom eagerness, the empty confidence of a man about to be taught his own job. 35mm photorealistic. No name tags, no readable text.

## Act 5 — St. Augustine, Florida

## 36. The asphalt gauntlet
**File:** `app/src/main/assets/story/squeeze_florida_road.jpg` (1280x720)

> Florida Interstate 95 at night between Jacksonville and St. Augustine: a single car heading south into the dark, brake-light walls ahead, construction barriers with blinking arrow boards, swamp-dark billboards and sodium street lamps, a glare of Florida sunrise just starting on the horizon behind. On a roadside board a **melting smiley** is drawn, face slowly running. The commute as a psychological torture test made landscape. Bright humming fluorescent headlight light, gritty and endless. 35mm photorealistic, film grain. No real logos, no readable text.

## 37. The honeymoon floor
**File:** `app/src/main/assets/story/squeeze_florida_store.jpg` (1280x720)

> The overnight floor of a big-box store in its golden months: freight moving like a river, associates passing cases hand to hand in one fluid motion, bins breathing, a store manager in shirtsleeves shaking hands with a manager in a teal vest with both of his, beaming genuine approval. The store glows green and alive with improbable optimism. A **melting smiley** pin droops on a vest, face running; a far wall reads "ALWAYS LOW MORALE" in muted mustard. Bright, almost-kind fluorescent light — the machine at its best behavior. 35mm photorealistic, film grain. No real logos, no readable text.

## 38. The flip — the office
**File:** `app/src/main/assets/story/squeeze_florida_office.jpg` (1280x720)

> A big-box store manager's office after the honeymoon has flipped: charts on the wall with goalposts literally drawn mounted on wheels, a cold predatory stare from the manager behind the broad desk, and a tired teal-vest manager standing before him at the end of a night shift, deflated. A **melting smiley** coffee mug sits between them, face running. Harsh morning light through the blinds, the warmth gone from the room. 35mm photorealistic, film grain. No real logos, no readable text.

## 39. The hostage backroom
**File:** `app/src/main/assets/story/squeeze_florida_backroom.jpg` (1280x720)

> An ownerless backroom after close: folded shirts in a dead color on a peg wall, a single teal-vest manager alone under a bank of fluorescent lights at 2 AM recounting pegs nobody will check, a clock high on the wall, the dim exit door glowing at the far end of an empty store stretching beyond. A single **melting smiley** sticker droops on a pallet, face fully run. The building holding a man past his shift, fluorescent hum you can almost hear. 35mm photorealistic, film grain. No real logos, no readable text.

## 40. The sanctuary floor
**File:** `app/src/main/assets/story/squeeze_florida_overnight.jpg` (1280x720)

> The overnight floor at 3 AM, the good crew: warm honest people working together — a cart girl laughing, a receiver sharing coffee, a kid's photo taped to a cart — and a teal-vest manager standing watch between them and a harsh doorway of daylight at the far end. Genuine warmth in the dark, the pure opposite of the office. A **melting smiley** pin on the manager's vest, face running. Quiet, human, luminous fluorescent light. 35mm photorealistic, film grain. No real logos, no readable text.

## 41. The 3 AM
**File:** `app/src/main/assets/story/squeeze_florida_3am.jpg` (1280x720)

> The cavernous backroom at 3 AM on medical leave: one man sitting alone on the baler with his hands in his lap, a single struggling fluorescent panel overhead, deep shadow swallowing the rafters, the exit door a far faint glowing rectangle, a stopped clock, and the first crack of dawn light beginning at a high window. Solemn, dark, isolating — never a depiction of harm, only the weight of a long night and the light that finally comes. A **melting smiley** sticker on the wall, face completely run. Heavy shadow, film grain, 35mm photorealistic. No real logos, no readable text.

## 42. Sriniviii — store manager
**File:** `app/src/main/assets/portraits/sriniviii.jpg` (640x800, portrait)

> Editorial portrait of an intense, unrelenting South Asian man in his 40s — a big-box store manager. Neat short hair, sharp pressed shirt, and for now a genuine two-handed warmth: a broad approving smile, direct intense eyes that don't blink, teal vest over a white shirt, small **melting smiley** pin, face running. Warm-to-flat transition light, the man who can praise you like gold and then read you like a ledger. 35mm photorealistic. No name tags, no readable text.

## 43. Ohmar — store lead
**File:** `app/src/main/assets/portraits/ohmar.jpg` (640x800, portrait)

> Editorial portrait of a huge, unnervingly calm man in his late 30s — the store lead and the region's enforcer. Impeccably pressed dark polo, arms folded across broad shoulders, a small polite flat smile that does not reach the eyes, head tilted slightly like weather, radiating controlled menace without raising his voice. A **melting smiley** pin on his chest, face run to a smear. Cold fluorescent office light, black backdrop, the kind of quiet that empties a hallway. 35mm photorealistic. No name tags, no readable text.

---

## Act 6 — The Aftermath (Florida, the Pay Cut to the Balance Sheet)

## 44. The crash back to hourly
**File:** `app/src/main/assets/story/squeeze_act6_crash.jpg` (1280x720)

> The main floor of a big-box store in flat, unforgiving daylight — stripped of the protective isolation of the overnight shift: long aisles of tall racking under the full merciless hum of daytime fluorescents, a front end busy with registers, shoppers moving in orderly rows. A lone hourly team lead in a teal-and-orange vest walks a center aisle with a pricing gun, looking up at the same lights he once managed. A far wall reads "ALWAYS LOW MORALE" in muted mustard wallpaper, and a hanging banner carries a **melting smiley**, face running like warm wax. The harsh, relentless, entirely indifferent brightness of a building that doesn't know what a person gave up to stay in it. 35mm photorealistic, film grain. No real logos, no readable text.

## 45. Timmy's store — the brief sanctuary
**File:** `app/src/main/assets/story/squeeze_act6_timmy.jpg` (1280x720)

> The warm interior of a Florida big-box store in its rare quiet golden hours: associates actually talking to one another as they stock shelves, a store manager with an open, honest face shaking hands with a new hourly team lead and looking him in the eye, a receiver sharing coffee with a cart girl. Same machinery as any other store — racking, fluorescents, pallets — but the air is different: the specific, rare silence of a building that hasn't been broken yet. A **melting smiley** pin droops on a vest, face running. Soft, almost-kind fluorescent light, genuine human warmth between people. 35mm photorealistic, film grain. No real logos, no readable text.

## 46. Abdoolie's store — the same building, different gravity
**File:** `app/src/main/assets/story/squeeze_act6_abdoolie.jpg` (1280x720)

> The main floor of a big-box store under a new, colder gravity: the same racking and fluorescents as any other day, but the associates move slightly faster and glance slightly sideways, heads down in the aisles. In the mezzanine office doorway stands a slender, immaculate manager in a dark shirt, perfectly still, hands clasped, watching the floor with a flat, patient, unreadable calm — the ghost of the old regime in a new body, danger carried entirely in voice and procedure. A **melting smiley** poster droops on a steel column, wax long run. Harsh identical fluorescent light, an atmosphere you can feel but not see. 35mm photorealistic, film grain. No real logos, no readable text.

## 47. The front-end grind — the customer gauntlet
**File:** `app/src/main/assets/story/squeeze_act6_front_end.jpg` (1280x720)

> The cavernous front end of a big-box store at full tilt: row after row of register lanes backed up with shoppers, a crowded service desk with a blinking beacon, carts jammed in the aisles. A tired associate in a teal-and-orange vest stands at the service desk absorbing a complaint from an angry customer leaning over the counter while a line of waiting shoppers watches. The constant, relentless, petty erosion of ten hours of public-facing work made landscape. A **melting smiley** banner droops over the check lanes, wax running. Harsh fluorescent light, the machine and the public meeting at full volume. 35mm photorealistic, film grain. No real logos, no readable text.

## 48. The shop tech pit — the underground haven
**File:** `app/src/main/assets/story/squeeze_act6_shop_pit.jpg` (1280x720)

> Six automotive bays in the service pit of a big-box store — the only part of the building the machine forgot to surveil: concrete floor stained with motor oil, impact wrenches thundering, a car on a lift with a tire already off, tool carts with drawers open, the smell of burnt rubber in the air. A veteran mechanic in a dark work shirt and a tired hourly associate in a teal-and-orange vest work side by side at a bay while a team lead watches over them with genuine, competent, protective care. A single **melting smiley** sticker droops on a tool cart, face run. Warm industrial light mixing with honest daylight from the bay doors, loud real work. 35mm photorealistic, film grain. No real logos, no readable text.

## 49. The balance sheet — the unbroken soul
**File:** `app/src/main/assets/story/squeeze_act6_resolution.jpg` (1280x720)

> A single automotive bay at the end of a last shift: the overhead door cracked, Florida morning light cutting one clean line across the concrete, an impact wrench hung on its correct peg above a tool cart, the bay floor swept and still. A man in a dark work shirt stands at the bay edge, cap in hand, looking out through the open door into the light with the complete, verified stillness of a person who refused to be destroyed. A **melting smiley** sticker on the tool cart, face fully run. Warm sunrise light, the smell of motor oil, the weight of the whole memoir in one quiet frame. 35mm photorealistic, film grain. No real logos, no readable text.

## 50. Abdoolie — store manager
**File:** `app/src/main/assets/portraits/abdoolie.jpg` (640x800, portrait)

> Editorial portrait of a slender, immaculate man in his 50s — the new store manager who replaced the brief sanctuary. A worn but meticulously pressed dark shirt with sleeves perfectly rolled, thin sharp features, a small precise mouth, and a flat, level, patient gaze that never rises and never varies. He is not physically large — the danger is entirely in the calm: the measured cadence, the unblinking stillness of a man about to ask you to walk him through a number. Store-office backdrop, fluorescent light, no emotion leaking anywhere. A **melting smiley** pin on his collar, face run to a smear. 35mm photorealistic. No name tags, no readable text.

## 51. Timmy — store manager, the brief sanctuary
**File:** `app/src/main/assets/portraits/timmy.jpg` (640x800, portrait)

> Editorial portrait of a warm, steady man in his 50s — the store manager who still knows every associate by name. Round kind face, graying hair, glasses low on his nose, an open smile that reaches genuine eyes — eyes that don't move the way trick eyes move. Teal-and-orange vest over a comfortable button shirt, one hand extended in an honest handshake, the other resting on a well-worn clipboard. A **melting smiley** pin on the vest, face running. Soft back-office light with a blurred store floor behind him, decency in every line. 35mm photorealistic. No name tags, no readable text.

## 52. Tani — shop team lead
**File:** `app/src/main/assets/portraits/tani.jpg` (640x800, portrait)

> Editorial portrait of a capable, fiercely protective woman in her 40s — an automotive shop team lead. Dark work shirt with rolled sleeves, hair pulled back, strong forearms, one hand resting on the grip of an impact wrench across her shoulder; warm eyes that invite you in and a jaw set with a quiet promise: nobody touches her crew. She stands at the open edge of a service bay with a lift and tool cart blurred behind her. A **melting smiley** sticker on her shirt pocket, face run. Warm industrial light, honest working-class dignity. 35mm photorealistic. No name tags, no readable text.

## 53. Cap'n H — shop team lead
**File:** `app/src/main/assets/portraits/capn_h.jpg` (640x800, portrait)

> Editorial portrait of a weathered, generous veteran in his 60s — an automotive shop team lead who runs the bays on trust and skill. Gray-streaked beard, deep laugh lines, a grease-smudged dark work shirt with sleeves off strong forearms, a **melting smiley** sticker worn like a badge. He stands with arms crossed at a bay edge, honest kind eyes, the easy authority of a man who has done the work right for nine years and watches everyone's back. Impact wrenches and tool carts blurred behind him. Warm bay light. 35mm photorealistic. No name tags, no readable text.

---

## Portrait Variants (9:16, 720×1280)

These are the companion portrait-orientation backgrounds for every landscape scene above.
Name each file `<original_stem>_p.jpg` and place it beside the landscape file in `app/src/main/assets/story/`.
The engine's `StoryAssetLoader.loadBackground()` automatically prefers `_p.jpg` in portrait mode
and falls back to the landscape file when no portrait variant exists — so these are purely additive.

**Every portrait prompt below inherits the global style header and both global rules
(melting smiley, no real logos/text). Paste the style header before each prompt when generating.**

Composition rule that applies to every portrait variant:
> Optimised for 9:16 vertical mobile — strong vertical composition, main subject centred in
> upper two-thirds of frame, lower third kept deliberately dark and muted to allow the
> dialogue UI panel to overlay cleanly. No letterboxing stripes. No floating whitespace at
> the top. Fill the full 720×1280 frame with subject matter.

---

## P1. Title screen — portrait variant
**File:** `app/src/main/assets/story/squeeze_title_p.jpg` (720×1280, portrait 9:16)

> Tall vertical shot of the fictional Wally's World superstore facade shot from the parking lot at dusk,
> the building stretching upward to fill most of the frame: the giant rounded "WALLY'S WORLD" sign
> at the top quarter with a single **melting smiley** above the entrance doors, its face drooping with
> wax running down the fascia. The glass entrance doors glow warm at the mid-frame, a lone
> orange-vested employee pushing a cart train toward them. Rain-slicked asphalt fills the lower third,
> the employee's reflection broken on the wet ground. Overhead low clouds close in from the top.
> Nostalgic, slightly melancholy early-2000s retail grandeur. No real logos, no real brand marks.

## P2. Front-end / registers — portrait variant
**File:** `app/src/main/assets/story/squeeze_utah_front_end_p.jpg` (720×1280, portrait 9:16)

> Low-angle vertical shot looking up a single register lane toward the fluorescent tube ceiling:
> the worn teal-and-orange cashier's vest in the near foreground, shoppers queued tall in the frame,
> a young freight associate struggling to hoist a heavy appliance onto the belt at mid-frame.
> Hanging above it all, a big **melting smiley** sign on wires, wax face dripping toward the lens.
> The lane stretches the full height of the image; speaker grilles and chipped tiles visible above.
> Warm but tired fluorescent light, Utah-frontier morning. No text, no real logos.

## P3. Trench / floor-stocker — portrait variant
**File:** `app/src/main/assets/story/squeeze_utah_trench_p.jpg` (720×1280, portrait 9:16)

> Vertical shot straight down a narrow back-stock canyon: tall steel racking walls rising on both
> sides to the top of the frame, pallets of boxes stacked high. A young freight associate in an
> orange vest walks toward camera, head bowed with exhaustion, a heavy cardboard box under one arm.
> A shaft of fluorescent light falls from high above; a lone **melting smiley** sticker droops on
> a near pallet. Deep shadow fills the lower third and the far distance. The forklift silhouette
> is a ghost shape at the very top. Moody, cinematic, claustrophobic vertical scale.
> No text, no logos.

## P4. Office / manager's desk — portrait variant
**File:** `app/src/main/assets/story/squeeze_utah_office_p.jpg` (720×1280, portrait 9:16)

> Vertical shot from behind the manager's desk looking up at a cramped back-office: a cluttered
> desk surface (clipboard, old CRT with green spreadsheet) fills the lower third; the weary store
> manager in a teal shirt with orange tie leans back in the mid-frame; a wall of laminate shelving
> piled with file boxes rises to the top quarter; a **melting smiley** poster hangs high on the
> wall, face running. Frosted window above lets fluorescent sales-floor light seep in.
> The young associate stands in the doorway framed by the top of the door. No readable text.

## P5. Sales floor / center aisle — portrait variant
**File:** `app/src/main/assets/story/squeeze_utah_floor_p.jpg` (720×1280, portrait 9:16)

> Vertical shot down the main center aisle of a fictional megastore looking toward the far wall:
> towering shelves rise on both sides framing the corridor, a giant **melting smiley** banner hangs
> overhead at the top quarter, wax dripping. A far wall at mid-frame reads "ALWAYS LOW MORALE"
> in muted mustard as plain wallpaper. An orange-vested associate with a pallet jack works the
> near aisle at mid-frame; shoppers with carts recede toward the bottom. A PA speaker hangs
> from the ceiling in the upper third. Bright flat fluorescent light, busy but orderly.
> No real logos, no barcodes.

## P6. Lamar — service shop — portrait variant
**File:** `app/src/main/assets/story/squeeze_colorado_lamar_p.jpg` (720×1280, portrait 9:16)

> Vertical exterior shot: the sagging canopy of a fictional megastore service shop rises to the
> top third, its faded orange-and-teal signage and a **melting smiley** (wax face running in the
> wind) filling the upper frame. A lone shop manager in a teal vest stands under the canopy at
> mid-frame, breath steaming in the cold, a stack of oil jugs by his feet. Semi-trucks and dusty
> pickups line the bottom third; flat high-plains highway stretches behind the building.
> Low winter sun, long shadows, honest small-town commerce. No real logos, no readable text.

## P7. Colorado store floor — portrait variant
**File:** `app/src/main/assets/story/squeeze_colorado_store_p.jpg` (720×1280, portrait 9:16)

> Vertical shot looking up the main aisle of a big-box store gone tight and silent:
> a mezzanine silhouette watching from above fills the top quarter; ceiling-mounted cameras
> every few rows descend through the frame; an orange-vested associate glances nervously over
> their shoulder at mid-frame; the bottom third is a perfectly neat aisle with not a single
> worker chatting. A far wall reads "ALWAYS LOW MORALE" in muted mustard; a **melting smiley**
> poster droops on an endcap at mid-frame. Flat fluorescent light, the atmosphere of being watched.
> No real logos, no readable text.

## P8. Area office / brick wall — portrait variant
**File:** `app/src/main/assets/story/squeeze_colorado_office_p.jpg` (720×1280, portrait 9:16)

> Vertical shot of the fluorescent hallway and area office: frosted-glass meeting-room door fills
> the top quarter; a plastic office desk with file folders and a **melting smiley** coffee cup
> (face running) occupies the mid-frame; a tired couple sits across from an empty investigator's
> chair in the lower half. One open folder shows a single half-read stamped word —
> "UNSUBSTANTIATED" — barely legible. Cold institutional light, muted mustard accents.
> No real logos, no readable text except the one half-read stamped word.

## P9. Community hall / Christmas party — portrait variant
**File:** `app/src/main/assets/story/squeeze_colorado_hall_p.jpg` (720×1280, portrait 9:16)

> Vertical shot of a rented community hall set for an awkward office holiday party under harsh
> fluorescent glare: garland banner and a drooping **melting smiley** balloon frame the top third;
> a sharp-faced store manager in a neat blazer stands mid-laugh at mid-frame, drink in hand;
> a weary shop manager in a teal vest stands slightly apart at the lower-mid frame, two witnesses
> glancing between them. Paper tablecloths and sad catering trays fill the bottom third.
> Ugly lighting, social dread. No readable text, no real logos.

## P10. Road out of Colorado — portrait variant
**File:** `app/src/main/assets/story/squeeze_colorado_road_p.jpg` (720×1280, portrait 9:16)

> Vertical dusk shot: a packed box truck in a gravel driveway fills the lower half of the frame,
> furniture lashed under load straps, the house behind it dark and emptied at mid-frame. A tall
> figure loads the last box at the truck's open back, one hand pressed to his forehead beneath
> his cap brim. A single **melting smiley** sticker droops on the last cardboard box. The flat
> empty Colorado highway recedes into the horizon at the top third; cold blue dusk sky above.
> The truck's taillights glow red in the lower frame. No readable text, no real logos.

## P11. State-line commute — portrait variant
**File:** `app/src/main/assets/story/squeeze_carolina_commute_p.jpg` (720×1280, portrait 9:16)

> Pre-dawn vertical shot through the windshield and rearview mirror: a rented farmhouse with
> a single warm porch light shrinks in the rearview at the top quarter; kudzu and scrub pines
> crowd the sides; a green state-line highway sign (no readable text) looms at mid-frame.
> On the dash a thermos and a folded orange vest occupy the lower third; low banks of fog and
> a flat, distant megastore glow on the horizon at the top third. Gritty but warm editorial tone,
> muted early-2000s palette. No real logos, no barcodes, no text except one half-read sign.

## P12. Gated hierarchy / leadership tour — portrait variant
**File:** `app/src/main/assets/story/squeeze_carolina_store_p.jpg` (720×1280, portrait 9:16)

> Vertical interior shot: a hanging banner with a **melting smiley** (wax face dripping) fills
> the top quarter; beneath it a small pack of executives in pressed shirts and polished shoes
> are being shown around by a smiling store manager at mid-frame; in the foreground below, a
> line of junior managers in teal-and-orange vests stand at the edge of the sales floor, clearly
> excluded, watching through the endcap stacks from the lower half of the frame. A far wall reads
> "ALWAYS LOW MORALE" in muted mustard wallpaper. Fluorescent light, empty-cart silence, tension
> in the bodies. No real logos, no readable badges.

## P13. Neglected service shop — portrait variant
**File:** `app/src/main/assets/story/squeeze_carolina_bays_p.jpg` (720×1280, portrait 9:16)

> Vertical shot inside a run-down service shop bay looking up at the ceiling: a decades-old lift
> with a car on it dominates the upper frame; the sagging roof and a peeling **melting smiley**
> poster near the office door occupy the top quarter. A tired shop manager in a teal vest
> inspects a greasy torque wrench at mid-frame; green apprentices watch from the lower third,
> hopeful and wary. Work-order boards jammed with yellow tickets line one wall. Warm-but-tired
> fluorescent light, honest working-class grit. No real logos, no readable text.

## P14. Safety breach / regional office — portrait variant
**File:** `app/src/main/assets/story/squeeze_carolina_office_p.jpg` (720×1280, portrait 9:16)

> Vertical shot in the manager's back office: a **melting smiley** poster droops at the top of
> the wall above the desk; a CRT monitor with a green spreadsheet glows at the upper-mid frame.
> An exhausted shop manager in a teal vest stands at the desk at mid-frame holding a printed
> complaint, one hand on the keyboard. A hard copy of the report is visible on the desk surface
> in the lower third. Frosted glass doors lead down a corridor framing the very bottom.
> Tense, quiet, slightly claustrophobic. No real logos, no readable text.

## P15. Road out of the borderlands — portrait variant
**File:** `app/src/main/assets/story/squeeze_carolina_road_p.jpg` (720×1280, portrait 9:16)

> Vertical dusk shot from the cab of a box truck looking forward down a scrub-pine highway: the
> road stretches to a vanishing point at the top quarter, Georgia pines and a dark porch light
> receding in the passenger-side mirror at the upper edge. The cab interior fills the lower half:
> a scarred, tired man at the wheel, one hand on the dash, a bandage edge visible above his
> eyebrow. A single **melting smiley** sticker droops on the last cardboard box visible through
> the rear window. Long shadows, warm dying light. No real logos, no readable text.

## P16. One-man close — portrait variant
**File:** `app/src/main/assets/story/squeeze_pueblo_close_p.jpg` (720×1280, portrait 9:16)

> Vertical shot looking the length of the front end at closing time: a hanging **melting smiley**
> banner droops from the ceiling at the top quarter, wax running. Six-deep register queues fill
> the mid-frame, the blinking service-desk beacon far off at the back wall. A single manager in
> a teal vest moves hard between two lanes at mid-frame, one hand already reaching for the walkie
> at his hip. Carts jammed at the automatic doors fill the lower third; evening fluorescent
> light is harsh. The loneliness of a building run by one person. No real logos, no readable text.

## P17. Backroom overhaul offer — portrait variant
**File:** `app/src/main/assets/story/squeeze_pueblo_backroom_p.jpg` (720×1280, portrait 9:16)

> Vertical shot of the cavernous big-box backroom: a **melting smiley** poster peels on the tall
> steel column beside the dock door at the top quarter; a wall-size whiteboard covered in
> freight-flow diagrams spans the upper-mid frame. A row of uncomfortable managers in pressed
> shirts sits around a folding table at mid-frame, a speakerphone at the centre. One exhausted
> manager in a teal vest stands slightly apart in the foreground lower-mid, arms crossed, the
> only one looking at the whiteboard with real understanding. Warm industrial light. No real logos,
> no readable text.

## P18. Freight-to-floor overhaul — portrait variant
**File:** `app/src/main/assets/story/squeeze_pueblo_overhaul_p.jpg` (720×1280, portrait 9:16)

> Vertical shot along the unload line from the dock to the floor: a pure freight relay running
> like a rail from the dock at the top third — associates passing cases hand-to-hand in one fluid
> motion descending through the frame. A bin-and-topstock crew works labeled shelves at mid-frame.
> In the foreground lower-mid, a manager in a teal vest walks the line, clipboard in hand. A far
> wall reads "ALWAYS LOW MORALE" in muted mustard; a **melting smiley** sticker droops on a pallet
> at the bottom. Bright humming fluorescent light, organised energy. No real logos, no readable text.

## P19. Education of Richard — portrait variant
**File:** `app/src/main/assets/story/squeeze_pueblo_training_p.jpg` (720×1280, portrait 9:16)

> Vertical shot inside a small fluorescent office: a whiteboard with a bin diagram fills the upper
> third; a tired veteran manager in a teal vest points at it from mid-frame. Across the desk below
> him a young corporate climber in a freshly pressed shirt holds a stocking report upside-down and
> smiles with practiced confidence. A **melting smiley** coffee mug sits between them on the desk
> surface at the lower-mid frame, face running. Warm-though-institutional light, the comedy and
> tragedy of a man being taught his own job by the man underneath him. No real logos, no readable text.

## P20. Store manager's office paradox — portrait variant
**File:** `app/src/main/assets/story/squeeze_pueblo_office_p.jpg` (720×1280, portrait 9:16)

> Vertical shot inside the smoke-gray store manager's office: a **melting smiley** clock droops
> high on the wall at the top quarter. The broad desk stacked with freight reports fills the lower
> half; a wall of scheduled shifts lines one side. Three figures occupy the mid-frame: a warm,
> broad-smiling store manager in shirtsleeves leaning against the desk; beside him a small thin
> store-lead with a hostile flat stare; and a slightly heavier-set woman with a serene smile that
> doesn't reach her eyes, one hand on a file folder. Cold fluorescent light, polite false warmth.
> No real logos, no readable text.

## P21. Overnight graveyard — portrait variant
**File:** `app/src/main/assets/story/squeeze_pueblo_overnight_p.jpg` (720×1280, portrait 9:16)

> Vertical shot down the center aisle of a big-box sales floor at three in the morning: high
> emergency fluorescents and the red glow of a dock sign cast the only light from the ceiling
> down. Pallets of freight breathe in the near darkness at the bottom third. A single silhouette
> in a teal vest stands at mid-frame in the wide aisle, the whole hundred-thousand-square-foot
> building pressing in. On a steel column at upper-mid frame a **melting smiley** poster has
> sagged into an almost skull-like run. Abandoned silence, the graveyard shift. No real logos,
> no readable text.

## P22. Road to Florida — portrait variant
**File:** `app/src/main/assets/story/squeeze_pueblo_road_p.jpg` (720×1280, portrait 9:16)

> Near-dawn vertical shot from inside the cab looking east: the highway stretches toward a flat
> soulless horizon at the top quarter; the Pueblo sprawl and its big-box slab recede in the mirror
> at the upper edge. The dash fills the lower third: a folded relocation-contract folder with a
> small **melting smiley** sticker on the corner, a thermos, and a billfold. The driver's hand on
> the wheel shows a fresh bandage at the edge of a scarred forehead above the cap brim. Cold blue
> dawn against the orange sodium of the lot behind. No real logos, no readable text.

## P23. Asphalt gauntlet — portrait variant
**File:** `app/src/main/assets/story/squeeze_florida_road_p.jpg` (720×1280, portrait 9:16)

> Vertical night shot standing on I-95: construction barriers with blinking arrow boards tower on
> both sides of the frame, swamp-dark above; brake-light walls from halted cars stretch toward the
> top. A single car heads south in the lower-mid lane. A roadside billboard at the upper third
> carries a drawn **melting smiley**, face slowly running. The first suggestion of Florida sunrise
> glows at the horizon at the very top. Sodium street lamps line both sides. The commute as
> psychological torture made landscape. Gritty and endless, 35mm film grain. No real logos,
> no readable text.

## P24. Honeymoon floor — portrait variant
**File:** `app/src/main/assets/story/squeeze_florida_store_p.jpg` (720×1280, portrait 9:16)

> Vertical shot looking up the overnight floor: freight moves like a river from the dock at the
> top third — associates passing cases hand-to-hand in one fluid motion, bins breathing, the
> store glowing green and alive with improbable optimism. At mid-frame a store manager in
> shirtsleeves shakes hands with a manager in a teal vest with both of his, beaming genuine
> approval. A **melting smiley** pin droops on a vest, face running. A far wall reads "ALWAYS
> LOW MORALE" in muted mustard. Bright, almost-kind fluorescent light. 35mm film grain.
> No real logos, no readable text.

## P25. The flip — office — portrait variant
**File:** `app/src/main/assets/story/squeeze_florida_office_p.jpg` (720×1280, portrait 9:16)

> Vertical shot inside the store manager's office after the honeymoon has flipped: charts with
> goalposts literally drawn mounted on wheels cover the wall at the upper third. A cold predatory
> stare from the manager behind the broad desk dominates the mid-frame. A tired teal-vest manager
> stands in the lower foreground at the end of a night shift, deflated. A **melting smiley** coffee
> mug sits on the desk between them, face running. Harsh morning light through the blinds strips
> the room at the upper edge. 35mm film grain. No real logos, no readable text.

## P26. Hostage backroom — portrait variant
**File:** `app/src/main/assets/story/squeeze_florida_backroom_p.jpg` (720×1280, portrait 9:16)

> Vertical shot looking down the length of an ownerless backroom after close: a dim exit door
> glows as a tiny rectangle at the top of the frame. A stopped clock high on the wall occupies
> the upper-mid frame. A bank of fluorescent lights directly overhead lights the scene harshly.
> A single teal-vest manager sits alone on the baler at mid-frame, recounting pegs at 2 AM.
> Folded shirts in a dead color on a peg wall line both sides; an empty store stretches beyond.
> A **melting smiley** sticker droops on a pallet at the lower third. Fluorescent hum made visible.
> 35mm film grain. No real logos, no readable text.

## P27. Sanctuary floor — portrait variant
**File:** `app/src/main/assets/story/squeeze_florida_overnight_p.jpg` (720×1280, portrait 9:16)

> Vertical shot looking up the overnight floor at 3 AM, the good crew: a harsh doorway of
> daylight looms at the top quarter like a threat held at bay. In the warm fluorescent middle:
> a cart girl laughing with a receiver sharing coffee at mid-frame, a kid's photo taped to a
> cart below. A teal-vest manager stands watch between the crew and the daylight doorway, quiet
> and protective, at the upper-mid frame. Genuine warmth in the dark, pure opposite of the office.
> A **melting smiley** pin on the manager's vest, face running. Quiet, human, luminous light.
> 35mm film grain. No real logos, no readable text.

## P28. The 3 AM — portrait variant
**File:** `app/src/main/assets/story/squeeze_florida_3am_p.jpg` (720×1280, portrait 9:16)

> Vertical shot inside the cavernous backroom at 3 AM: a high window at the very top shows the
> first crack of dawn light beginning to filter through. Deep shadow swallows the rafters through
> the upper frame. A single struggling fluorescent panel provides the only middle light. One man
> sits alone on the baler at mid-frame, hands in his lap, a stopped clock on the wall just above
> him. The exit door is a far faint glowing rectangle at the very bottom of the frame. A **melting
> smiley** sticker on the wall, face completely run. Solemn, dark, isolating — the weight of a
> long night and the light that finally comes. Heavy shadow, film grain. No real logos, no readable text.

## P29. Act 6 — Crash back to hourly — portrait variant
**File:** `app/src/main/assets/story/squeeze_act6_crash_p.jpg` (720×1280, portrait 9:16)

> Vertical shot looking up a main aisle of a big-box store in flat unforgiving daytime: a hanging
> **melting smiley** banner droops from the ceiling at the top quarter, wax running down. Tall
> racking walls rise on both sides through the full frame. Full daytime fluorescents light every
> inch mercilessly from above. A lone hourly team lead in a teal-and-orange vest walks the center
> aisle at mid-frame, pricing gun in hand, looking up at the lights he once managed. A far wall
> reads "ALWAYS LOW MORALE" in muted mustard at the top third. The bottom third is open aisle,
> shoppers and carts. 35mm film grain. No real logos, no readable text.

## P30. Act 6 — Timmy's brief sanctuary — portrait variant
**File:** `app/src/main/assets/story/squeeze_act6_timmy_p.jpg` (720×1280, portrait 9:16)

> Vertical shot inside a Florida big-box store during its rare golden quiet hours: racking walls
> rise on both sides of the frame, soft fluorescent light from above. At the top third associates
> actually talk to one another as they stock shelves. At mid-frame a store manager with an open
> honest face shakes hands with a new hourly team lead, looking him in the eye. Below them at the
> lower-mid frame a receiver shares coffee with a cart girl. A **melting smiley** pin droops on
> a vest, face running. The specific rare silence of a building that hasn't been broken yet.
> 35mm film grain. No real logos, no readable text.

## P31. Act 6 — Abdoolie's store — portrait variant
**File:** `app/src/main/assets/story/squeeze_act6_abdoolie_p.jpg` (720×1280, portrait 9:16)

> Vertical shot looking up the main aisle of a big-box store under a new colder gravity: a
> mezzanine office doorway frames the top quarter — in it stands a slender, immaculate manager
> in a dark shirt, perfectly still, hands clasped, watching the floor below with flat patient
> unreadable calm. Associates move through the mid-frame aisle slightly faster, heads down,
> glancing sideways. A **melting smiley** poster droops on a steel column at mid-frame, wax long
> run. The bottom third is open aisle, the store indistinguishable from any other except the
> atmosphere you can feel but not see. Harsh identical fluorescent light. 35mm film grain.
> No real logos, no readable text.

## P32. Act 6 — Customer gauntlet (front-end) — portrait variant
**File:** `app/src/main/assets/story/squeeze_act6_front_end_p.jpg` (720×1280, portrait 9:16)

> Vertical shot looking up from behind the service desk: a blinking service-desk beacon hangs at
> the top quarter. Register lane after lane backs up behind the beacon in the upper frame. An angry
> customer leans over the service counter at mid-frame, voice projected at a tired associate in a
> teal-and-orange vest who absorbs the complaint with practiced stillness. A waiting line of shoppers
> recedes into the lower third. A **melting smiley** banner droops over the check lanes at the upper
> edge, wax running. Harsh fluorescent light, the machine and the public meeting at full volume.
> 35mm film grain. No real logos, no readable text.

## P33. Act 6 — Shop tech pit — portrait variant
**File:** `app/src/main/assets/story/squeeze_act6_shop_pit_p.jpg` (720×1280, portrait 9:16)

> Vertical shot inside a service bay looking up at the car on the lift overhead: the vehicle fills
> the top third, a tire already off; impact-wrench cables hang down; the lift arms frame the upper
> mid. A veteran mechanic in a dark work shirt and a tired hourly associate in a teal-and-orange
> vest work side by side at the mid-frame, competent and focused. A team lead with genuine
> protective authority watches from the lower-mid foreground. A **melting smiley** sticker droops
> on a near tool cart, face run. Warm industrial bay light mixing with daylight through the bay
> doors at the bottom third. 35mm film grain. No real logos, no readable text.

## P34. Act 6 — Balance sheet / resolution — portrait variant
**File:** `app/src/main/assets/story/squeeze_act6_resolution_p.jpg` (720×1280, portrait 9:16)

> Vertical shot inside a single automotive bay at the end of a last shift: the overhead bay door
> is cracked at the bottom of the frame, Florida morning light cutting one clean line across the
> concrete floor. The swept, still bay floor fills the lower third. An impact wrench hangs on its
> correct peg above a tool cart at the lower-mid frame; a **melting smiley** sticker on the cart,
> face fully run. A man in a dark work shirt stands at the bay edge at mid-frame, cap in hand,
> looking out through the open door into the morning light at the top third — the complete,
> verified stillness of a person who refused to be destroyed. Warm sunrise light fills the top
> of the frame, the smell of motor oil implied in every shadow. 35mm film grain.
> No real logos, no readable text.

---

## Regeneration notes

- If Gemini refuses a prompt for "any real retailer trademark", the image already uses the fictional
  "Wally's World" name — just re-run; the fallback is fine.
- The **melting smiley** and **Always Low Morale** rules are baked into every block above; an
  intact, happy smiley or the real "Everyday Low Price" wording is the one thing that's an
  automatic reject-and-regenerate.
- Portraits are hot-swappable by file name alone (`todd.jpg`, `jodie.jpg`, `mattie_t.jpg`,
  `narrator.jpg`, `trudy.jpg`, `jury.jpg`, `adriana.jpg`, `skagg.jpg`, `azalia.jpg`,
  `jay_dau.jpg`, `amandy.jpg`, `steffie.jpg`, `richard.jpg`, `sriniviii.jpg`,
  `ohmar.jpg`, `abdoolie.jpg`, `timmy.jpg`, `tani.jpg`, `capn_h.jpg`) — the
  engine never references specific art beyond these names, so you may upgrade any of them
  without a rebuild.
- Portrait background variants follow the `<stem>_p.jpg` naming convention
  (e.g. `squeeze_title_p.jpg`). The engine falls back to the landscape file automatically when
  a `_p.jpg` is absent — so you can ship portrait variants scene-by-scene without a full set.
  Landscape images also work fine in portrait mode (they will be top-aligned and FillWidth-scaled
  with the gradient vignette masking the letterbox at the bottom).
