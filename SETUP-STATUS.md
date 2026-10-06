# Setup Status — CU Battlecode

> Last Updated: 2026-10-06  
> Environment: Windows 10/11

---

## Software Installed

| Software | Version | Required For | Status |
|---|---|---|---|
| Java JDK | 25.0.1 (≥21 required) | Engine, Bots | ✅ Installed & Working |
| Gradle | 8.10 (via wrapper) | Engine build | ✅ Working |
| Node.js | 24.11.1 (≥18 required) | Client visualizer, Galaxy frontend | ✅ Installed |
| npm | 11.6.2 | Package management | ✅ Installed |
| Python | 3.14.0 | Galaxy backend, crossplay | ⚠️ Installed (higher than Galaxy's 3.10 requirement) |
| Docker | 29.7.2 | Saturn, Titan, Galaxy services | ✅ Installed |
| Git | Latest | Version control | ✅ Installed |

## Software Missing / Not Verified

| Software | Required For | Status |
|---|---|---|
| Conda (Miniconda/Anaconda) | Galaxy development environment | ❓ Not verified |
| Go 1.18+ | Saturn/Titan development | ❓ Not verified |
| Google Cloud SDK | Galaxy staging/production | ⬜ Not needed yet |
| Terraform 1.3.4+ | Infrastructure deployment | ⬜ Not needed yet |
| PostgreSQL | Galaxy production database | ⬜ Not needed yet (SQLite for dev) |

---

## Battlecode26 Engine

| Item | Status | Notes |
|---|---|---|
| Repository cloned | ✅ | `d:\CsquareClub\battlecode\battlecode26` |
| Git remote intact | ✅ | `origin → https://github.com/battlecode/battlecode26.git` |
| Branch | ✅ | `master` |
| `gradlew clean` | ✅ | Runs successfully |
| Engine compilation | ✅ | `gradle :engine:build` passes |
| Example bots compilation | ✅ | `examplefuncsplayer` compiles |
| Headless match execution | ✅ | Match runs to completion |
| Replay file generation | ✅ | `.bc26` file created in `matches/` |
| Match result output | ✅ | Winner printed to stdout |
| Client visualizer setup | ✅ | Run `npm run watch` in client/ |
| Client visualizer working | ✅ | Available at http://localhost:3000 |

## Galaxy Platform

| Item | Status | Notes |
|---|---|---|
| Repository cloned | ✅ | `d:\CsquareClub\battlecode\galaxy` |
| Git remote intact | ✅ | `origin → https://github.com/battlecode/galaxy.git` |
| Branch | ✅ | `main` |
| Conda environment | 🔲 | Not yet created |
| Backend (Django) setup | 🔲 | Not yet attempted |
| Backend migrations | 🔲 | Not yet attempted |
| Backend running | 🔲 | Not yet attempted |
| Frontend (Vite) setup | 🔲 | Not yet attempted |
| Frontend running | 🔲 | Not yet attempted |
| Saturn (Docker) setup | 🔲 | Not yet attempted |
| Titan (Docker) setup | 🔲 | Not yet attempted |

---

## Match Pipeline Status

```
[✅] Bot A (examplefuncsplayer) compiled
        ↓
[✅] Bot B (examplefuncsplayer) compiled
        ↓
[✅] Battlecode Engine running
        ↓
[✅] Match executed (2000 rounds or win condition)
        ↓
[✅] Replay file generated (.bc26)
        ↓
[✅] Visualizer can load replay
        ↓
[✅] Match can be viewed/replayed
```

---

## Verified Commands

```powershell
# Clean build
.\gradlew.bat clean

# Run headless match (default config)
.\gradlew.bat headless

# Run headless match (custom teams/map)
.\gradlew.bat headless -Pmaps=DefaultSmall -PteamA=examplefuncsplayer -PteamB=examplefuncsplayer

# Replay output location
matches\*.bc26
```

---

## Known Issues

1. **Gradle deprecation warnings**: Build uses deprecated features incompatible with Gradle 9.0 — non-blocking
2. **Deprecated API usage**: `TeamClassLoaderFactory.java` uses deprecated API — non-blocking
3. **Python version mismatch**: System Python 3.14 vs Galaxy requirement 3.10 — will need Conda for Galaxy
4. **Engine bytecode sandbox warnings**: `--add-opens` JVM flags required — handled by build.gradle
