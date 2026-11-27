# Todd's Shop Captain skills left out of his kit

Todd is one fighter whose kit grows through the story (`classes/floor_captain.json`: 3 starting spells and 9
`spellGrants`, 12 spells by the end). These six Shop Captain spells were left out because each overlaps one he
already learns, and adding them would take him past the 10-12 spells the spell console is built for. They are still
defined in `spells/spells.json`, so bringing one back is a single grant.

| Spell id | Name | School | Kind | Power | Description |
|---|---|---|---|---|---|
| `lube_line` | Lube Line | Grunt Work (PHYSICAL) | attack | 40 | The basic rhythm of the service line: drain, filter, fill, torque. Free, tireless, always available. |
| `tire_grind` | Tire Grind | Grunt Work (PHYSICAL) | attack | 55 | Break the bead, spin the mount, seat the tire — the machine gives nothing for free, so you take the torque. |
| `bay_charge` | Bay Charge | Grunt Work (PHYSICAL) | attack | 52 | Move where the work is, every bay at once, until the whole shop hums in tune. |
| `grease_clear` | Grease Clear | Grunt Work (PHYSICAL) | area attack | 46 | One sweep of the bay floor — every work order in the shop clears at once. |
| `jack_hold` | Jack Hold | Grunt Work (PHYSICAL) | guard | 0 | Plant the jack stand before you reach under the frame. Halve the next blow — nothing drops on your watch. |
| `belt_mend` | Belt Mend | Integrity (HOLY) | heal | 50 | Patch the tech who's been running all day — a swapped task, a cold drink from your bin, the line keeps moving. |

## Bringing one back

Add it to a grant in `classes/floor_captain.json`, keyed to a story flag the story sets (only additions, never
replacements):

```json
{ "flag": "flag_lamar_bays", "spellIds": ["bay_heat", "tire_grind"] }
```

Then run the engine's checks against this game (`VB_TEST_FILTER="*BalanceContractTest*"
../voice-rpg-engine/scripts/test_content_packs.sh wallys-world`): the balance report shows whether the new spell is
ever the best choice, and the fights may need re-tuning (`BalanceTunerTest`, see the engine's
`docs/GAME_CREATION_GUIDE.md`).
