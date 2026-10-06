import os, glob
import re

replacements = [
    (r'\bMIT Battlecode\b', 'CU Battlecode'),
    (r'\bMIT\b', 'Chandigarh University'),
    (r'\bRat King\b', 'Lead Programmer'),
    (r'\bBaby Rat\b', 'Programmer'),
    (r'\bRat Trap\b', 'Programmer Trap'),
    (r'\bCat Trap\b', 'Bug Trap'),
    (r'\bRat\b', 'Programmer'),
    (r'\bCat\b', 'Bug'),
    (r'\bCheese\b', 'Coffee'),
    (r'\brat king\b', 'lead programmer'),
    (r'\bbaby rat\b', 'programmer'),
    (r'\brat trap\b', 'programmer trap'),
    (r'\bcat trap\b', 'bug trap'),
    (r'\brat\b', 'programmer'),
    (r'\bcat\b', 'bug'),
    (r'\bcheese\b', 'coffee'),
    (r'\bRats\b', 'Programmers'),
    (r'\bCats\b', 'Bugs'),
    (r'\brats\b', 'programmers'),
    (r'\bcats\b', 'bugs'),
]

directories_to_scan = [
    'd:/CsquareClub/battlecode/cu-battlecode-platform/frontend/src/content/**/*.ts',
    'd:/CsquareClub/battlecode/cu-battlecode-platform/frontend/src/views/**/*.tsx',
    'd:/CsquareClub/battlecode/cu-battlecode-platform/frontend/src/components/**/*.tsx'
]

for pattern in directories_to_scan:
    for f in glob.glob(pattern, recursive=True):
        if os.path.isfile(f):
            with open(f, 'r', encoding='utf-8') as file:
                content = file.read()
            
            original_content = content
            for old, new in replacements:
                content = re.sub(old, new, content)
                
            if content != original_content:
                with open(f, 'w', encoding='utf-8') as file:
                    file.write(content)
                print(f"Updated {f}")
