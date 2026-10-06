import os, glob
for f in glob.glob('d:/CsquareClub/battlecode/cu-battlecode-game/schema/js/**/*.js', recursive=True) + glob.glob('d:/CsquareClub/battlecode/cu-battlecode-game/schema/js/**/*.ts', recursive=True) + glob.glob('d:/CsquareClub/battlecode/cu-battlecode-game/client/**/*.ts', recursive=True) + glob.glob('d:/CsquareClub/battlecode/cu-battlecode-game/client/**/*.tsx', recursive=True) + glob.glob('d:/CsquareClub/battlecode/cu-battlecode-game/client/**/*.js', recursive=True):
    if os.path.isfile(f):
        with open(f, 'r', encoding='utf-8') as file:
            content = file.read()
        content = content.replace('programmer-king', 'lead-programmer').replace('ProgrammerKing', 'LeadProgrammer').replace('programmer_king', 'lead_programmer')
        with open(f, 'w', encoding='utf-8') as file:
            file.write(content)
