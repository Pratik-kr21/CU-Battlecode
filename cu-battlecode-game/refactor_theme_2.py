import os
import re

DIR = r"D:\CsquareClub\battlecode\cu-battlecode-game"
EXTENSIONS = {'.java', '.fbs', '.ts', '.tsx', '.js', '.md', '.json', '.py', '.pyi'}

REPLACEMENTS_CONTENT = [
    # PascalCase Classes
    (r'\bCatFeed\b', 'BugFeed'),
    (r'\bCatPounce\b', 'BugPounce'),
    (r'\bCatScratch\b', 'BugScratch'),
    (r'\bCheesePickup\b', 'CoffeePickup'),
    (r'\bCheeseSpawn\b', 'CoffeeSpawn'),
    (r'\bCheeseTransfer\b', 'CoffeeTransfer'),
    (r'\bCreateLeadProgrammer\b', 'CreateLeadProgrammer'),
    (r'\bRatAttack\b', 'ProgrammerAttack'),
    (r'\bRatCollision\b', 'ProgrammerCollision'),
    (r'\bRatNap\b', 'ProgrammerNap'),
    (r'\bRatSqueak\b', 'ProgrammerPing'),
    (r'\bThrowRat\b', 'ThrowProgrammer'),
    (r'\bUpgradeToLeadProgrammer\b', 'UpgradeToLeadProgrammer'),
    (r'\bCatStateType\b', 'BugStateType'),
    (r'\bCheeseMine\b', 'CoffeeMine'),
    (r'\bBugTrap\b', 'BugTrap'),
    (r'\bProgrammerTrap\b', 'ProgrammerTrap'),
    (r'\bPlaceBugTrap\b', 'PlaceBugTrap'),
    (r'\bPlaceProgrammerTrap\b', 'PlaceProgrammerTrap'),
    (r'\bTriggerBugTrap\b', 'TriggerBugTrap'),
    (r'\bTriggerProgrammerTrap\b', 'TriggerProgrammerTrap'),
    
    # camelCase Methods / Variables
    (r'\bcatFeed\b', 'bugFeed'),
    (r'\bcatPounce\b', 'bugPounce'),
    (r'\bcatScratch\b', 'bugScratch'),
    (r'\bcheesePickup\b', 'coffeePickup'),
    (r'\bcheeseSpawn\b', 'coffeeSpawn'),
    (r'\bcheeseTransfer\b', 'coffeeTransfer'),
    (r'\bcreateLeadProgrammer\b', 'createLeadProgrammer'),
    (r'\bratAttack\b', 'programmerAttack'),
    (r'\bratCollision\b', 'programmerCollision'),
    (r'\bratNap\b', 'programmerNap'),
    (r'\bratSqueak\b', 'programmerPing'),
    (r'\bthrowRat\b', 'throwProgrammer'),
    (r'\bupgradeToLeadProgrammer\b', 'upgradeToLeadProgrammer'),
    (r'\bcatStateType\b', 'bugStateType'),
    (r'\bcheeseMine\b', 'coffeeMine'),
    (r'\bbugTrap\b', 'bugTrap'),
    (r'\bprogrammerTrap\b', 'programmerTrap'),
    
    (r'\bcanPickUpCheese\b', 'canPickUpCoffee'),
    (r'\bpickUpCheese\b', 'pickUpCoffee'),
    (r'\bcanTransferCheese\b', 'canTransferCoffee'),
    (r'\btransferCheese\b', 'transferCoffee'),
    (r'\bgetCheese\b', 'getCoffee'),
    (r'\bisCatType\b', 'isBugType'),
    (r'\bisLeadProgrammerType\b', 'isLeadProgrammerType'),
    (r'\bisProgrammerType\b', 'isProgrammerType'),
    (r'\bcanThrowRat\b', 'canThrowProgrammer'),
    (r'\bdropRat\b', 'dropProgrammer'),
    (r'\bcanDropRat\b', 'canDropProgrammer'),
    (r'\bcanCarryRat\b', 'canCarryProgrammer'),
    (r'\bcarryRat\b', 'carryProgrammer'),
    
    (r'\bhasCheese\b', 'hasCoffee'),
    (r'\bhasBugTrap\b', 'hasBugTrap'),
    (r'\bhasProgrammerTrap\b', 'hasProgrammerTrap'),
    (r'\baddCheese\b', 'addCoffee'),
    (r'\bremoveCheese\b', 'removeCoffee'),
    
    # Generic replacements that might be parts of other identifiers but we missed earlier
    (r'LeadProgrammer', 'LeadProgrammer'),
    (r'leadProgrammer', 'leadProgrammer'),
    (r'Programmer', 'Programmer'),
    (r'programmer', 'programmer'),
    (r'BugTrap', 'BugTrap'),
    (r'bugTrap', 'bugTrap'),
    (r'ProgrammerTrap', 'ProgrammerTrap'),
    (r'programmerTrap', 'programmerTrap'),
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

for root, dirs, files in os.walk(DIR):
    dirs[:] = [d for d in dirs if d not in ('.git', 'node_modules', 'build', 'out', 'javadoc', 'dist', 'schema_generated')]
    for file in files:
        if any(file.endswith(ext) for ext in EXTENSIONS):
            filepath = os.path.join(root, file)
            process_file_content(filepath)
