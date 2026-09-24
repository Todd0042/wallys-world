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

## Regeneration notes

- If Gemini refuses a prompt for "any real retailer trademark", the image already uses the fictional
  "Wally's World" name — just re-run; the fallback is fine.
- The **melting smiley** and **Always Low Morale** rules are baked into every block above; an
  intact, happy smiley or the real "Everyday Low Price" wording is the one thing that's an
  automatic reject-and-regenerate.
- Portraits are hot-swappable by file name alone (`todd.jpg`, `jodie.jpg`, `mattie_t.jpg`,
  `narrator.jpg`, `trudy.jpg`, `jury.jpg`, `adriana.jpg`, `skagg.jpg`, `azalia.jpg`) — the
  engine never references specific art beyond these names, so you may upgrade any of them
  without a rebuild.
