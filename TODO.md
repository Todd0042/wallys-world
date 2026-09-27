# Wally's World (The Squeeze) — Feature Roadmap & TODO

## Future Roadmap Items

### 1. Custom Player Selfie Portrait with Retail Exhaustion Filters
*Status: Planned / Backlog (Streamlined New Game flow prioritized for now)*

#### Overview
Allow players to snap a selfie or select a photo from their device to use as their personal protagonist portrait throughout the story and combat screens, styled to match the gritty retail aesthetic of *The Squeeze*.

#### Proposed Pipeline & Technical Architecture
1. **Camera Capture & Photo Picker**:
   - Integrate `androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia` and `TakePicture` with `FileProvider`.
   - Crop to 1:1 aspect ratio square.
2. **AI Background Removal (Selfie Segmentation)**:
   - Use Google MLKit Selfie Segmentation (`com.google.mlkit:segmentation-selfie`) to compute an alpha confidence mask of the player.
   - Strip the real-world background and composite the player onto a gritty retail warehouse backdrop (e.g., `story/squeeze_utah_trench.jpg` or service bay pallet racks).
3. **"Raccoon Eyes" (Extreme Shift Exhaustion Filter)**:
   - Face landmark detection (MLKit Face Detection) to locate eye orbits.
   - Apply a blended radial darkening shader beneath the lower eyelids (desaturated purple/brown tint) to simulate severe sleep deprivation and overnight freight exhaustion.
4. **CRT Scanline & Grain Shader**:
   - Overlay subtle horizontal scanlines (alternating 1-2px dark scanlines) and analog noise/dither to seamlessly integrate modern camera captures with the retro aesthetic.
5. **Storage & Engine Persistence**:
   - Save processed bitmap to `context.filesDir/custom_hero_portrait.jpg`.
   - Store path in `PlayerCustomization.customPortraitPath` so it automatically loads into `StoryAssetLoader`, `StoryScreen`, `RetroBattleScreen`, and dialogue frames.
