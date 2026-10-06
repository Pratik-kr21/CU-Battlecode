import os
import re

DIR = r"D:\CsquareClub\battlecode\cu-battlecode-game"

EXTENSIONS = {'.java', '.fbs', '.ts', '.tsx', '.js', '.md', '.json', '.py', '.pyi'}

# The order is important: longer specific matches first
REPLACEMENTS_CONTENT = [
    (r'\bBABY_RAT\b', 'PROGRAMMER'),
    (r'\bbaby_rat\b', 'programmer'),
    (r'\bProgrammer\b', 'Programmer'),
    (r'\bprogrammer\b', 'programmer'),

    (r'\bRAT_KING\b', 'LEAD_PROGRAMMER'),
    (r'\brat_king\b', 'lead_programmer'),
    (r'\bLeadProgrammer\b', 'LeadProgrammer'),
    (r'\bleadProgrammer\b', 'leadProgrammer'),

    (r'\bRAT\b', 'PROGRAMMER'),
    (r'\bRat\b', 'Programmer'),
    (r'\brat\b', 'programmer'),

    (r'\bCAT\b', 'BUG'),
    (r'\bCat\b', 'Bug'),
    (r'\bcat\b', 'bug'),

    (r'\bCHEESE\b', 'COFFEE'),
    (r'\bCheese\b', 'Coffee'),
    (r'\bcheese\b', 'coffee'),

    (r'\bSQUEAK\b', 'PING'),
    (r'\bSqueak\b', 'Ping'),
    (r'\bsqueak\b', 'ping')
]

REPLACEMENTS_FILENAME = [
    ('programmer', 'programmer'),
    ('baby-programmer', 'programmer'),
    ('Programmer', 'Programmer'),
    
    ('lead_programmer', 'lead_programmer'),
    ('programmer-king', 'lead-programmer'),
    ('LeadProgrammer', 'LeadProgrammer'),
    
    ('rat_', 'programmer_'),
    ('programmer-', 'programmer-'),
    ('-programmer', '-programmer'),
    ('Programmer', 'Programmer'),
    
    ('cat_', 'bug_'),
    ('bug-', 'bug-'),
    ('-bug', '-bug'),
    ('Bug', 'Bug'),
    
    ('coffee', 'coffee'),
    ('Coffee', 'Coffee'),
    
    ('ping', 'ping'),
    ('Ping', 'Ping')
]

compiled_content = [(re.compile(pattern), repl) for pattern, repl in REPLACEMENTS_CONTENT]

def process_file_content(filepath):
    try:
        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()
    except UnicodeDecodeError:
        return
        
    new_content = content
    for regex, repl in compiled_content:
        new_content = regex.sub(repl, new_content)
        
    if new_content != content:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(new_content)
        print(f"Updated content: {filepath}")

# 1. Update contents
for root, dirs, files in os.walk(DIR):
    dirs[:] = [d for d in dirs if d not in ('.git', 'node_modules', 'build', 'out', 'javadoc', 'dist', 'schema_generated')]
    for file in files:
        if any(file.endswith(ext) for ext in EXTENSIONS):
            filepath = os.path.join(root, file)
            process_file_content(filepath)

# 2. Rename files
for root, dirs, files in os.walk(DIR, topdown=False):
    dirs[:] = [d for d in dirs if d not in ('.git', 'node_modules', 'build', 'out', 'javadoc', 'dist', 'schema_generated')]
    for file in files:
        new_file = file
        for old, new in REPLACEMENTS_FILENAME:
            new_file = new_file.replace(old, new)
            
        if new_file != file:
            old_path = os.path.join(root, file)
            new_path = os.path.join(root, new_file)
            os.rename(old_path, new_path)
            print(f"Renamed: {file} -> {new_file}")

# 3. Rename directories (if any, like 'programmer' -> 'programmer' which isn't likely but just in case)
for root, dirs, files in os.walk(DIR, topdown=False):
    dirs[:] = [d for d in dirs if d not in ('.git', 'node_modules', 'build', 'out', 'javadoc', 'dist', 'schema_generated')]
    for dirname in dirs:
        new_dirname = dirname
        for old, new in REPLACEMENTS_FILENAME:
            new_dirname = new_dirname.replace(old, new)
            
        if new_dirname != dirname:
            old_path = os.path.join(root, dirname)
            new_path = os.path.join(root, new_dirname)
            os.rename(old_path, new_path)
            print(f"Renamed dir: {dirname} -> {new_dirname}")
