# Next Steps

## DONE
- **Phase 0 (Inspect Everything First)**: Both repositories (`battlecode26` and `galaxy`) have been thoroughly inspected. The file `ARCHITECTURE-AUDIT.md` was created documenting the structure, dependencies, and communication patterns of the entire system.
- **Phase 1 (Verify Original Game)**: The `battlecode26` engine has been successfully compiled and verified locally. The headless match simulation works and produces replay files. The local client visualizer has been installed, launched, and successfully loaded in the browser at `http://localhost:3000`.
- **Phase 2 (Create Safe CU Development Structure)**: Established a clean Git branching structure. `cu-battlecode-game` and `cu-battlecode-platform` were cloned directly from the local MIT repos to preserve history while isolating our changes. The scaffold and docs repositories were initialized.
- **Phase 3 (Create CU Game Repository)**: The CU specific branding has been introduced into the game engine (`cu-battlecode-game`). The theme was officially transitioned from "Rats vs Cats" to "Programmers vs Bugs" and resources were changed from "Cheese" to "Coffee". All variables, Flatbuffers Schema, TypeScript bindings, and Python bindings were successfully updated and the engine compiles successfully!
- **Phase 4 (Create Participant Scaffold)**: The `cu-battlecode-scaffold` repository has been fully created. The CU engine (`2026.cu.1`) was published locally via Gradle `maven-publish`, and the scaffold is configured to build and run local bot matches against this updated engine. A `build.gradle` with a `run` task is fully functional and `examplefuncsplayer` bots compile and execute successfully.

- **Phase 5 (Local Visualizer Customization)**: Updated the client visualizer in `cu-battlecode-game/client/visualizer`. Swapped out the art assets (e.g. replacing cheese sprites with coffee sprites, cat sprites with bug sprites, rat sprites with programmer sprites) and updated UI strings to reflect the new CU theme. The visualizer compiles cleanly and loads accurately.

## WORKING
- **Engine Build**: Java 25 compiles the core engine and example bots without fatal errors (some deprecation warnings).
- **Match Execution**: `gradlew headless` successfully runs a complete game (e.g., examplefuncsplayer vs examplefuncsplayer on DefaultSmall) and saves `.bc26` replay files.
- **Visualizer**: Node/React-based client builds and runs via `npm run watch`. It serves the frontend allowing `.bc26` replays to be loaded and viewed.
- **Documentation**: Initial setup status (`SETUP-STATUS.md`) and architecture audit (`ARCHITECTURE-AUDIT.md`) are complete.

## NOT WORKING
- **Python Version Mismatch**: System Python is 3.14, whereas Galaxy requires 3.10 and Battlecode Crossplay expects 3.12. We will likely need to use Conda environments to manage this when we tackle the Galaxy backend and crossplay bots.
- **Galaxy Components**: None of the Galaxy backend, frontend, Saturn workers, or Titan scanners have been initialized or tested locally yet.

## REQUIRES HUMAN DECISION
1. **Repository Structure Strategy**: We need to decide whether to create our CU variations as separate git branches within the existing repositories, or create entirely new forks/repositories for `cu-battlecode-game` and `cu-battlecode-platform` that link back to the MIT source as upstreams. 
2. **Game Design**: We need to establish the basic mechanics and theme for the "CU Battlecode" variant (currently Rats vs Cats in the MIT 2026 version).

## NEXT ACTION
**Phase 6 (Galaxy Backend Setup)**: Now that the core engine and visualizer are complete, we need to move to `cu-battlecode-platform`. First we must set up the `galaxy` Django backend, properly map its PostgreSQL database requirements, and resolve the Python 3.14 vs 3.10 version mismatch (potentially using Conda or Docker).
