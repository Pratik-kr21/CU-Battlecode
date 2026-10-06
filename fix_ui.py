import os, glob
import re

replacements = [
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

for f in glob.glob('d:/CsquareClub/battlecode/cu-battlecode-game/client/src/components/**/*.tsx', recursive=True):
    if os.path.isfile(f):
        with open(f, 'r', encoding='utf-8') as file:
            content = file.read()
        
        for old, new in replacements:
            content = re.sub(old, new, content)
            
        with open(f, 'w', encoding='utf-8') as file:
            file.write(content)
