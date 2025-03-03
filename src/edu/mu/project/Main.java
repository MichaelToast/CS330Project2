package edu.mu.project;

public class Main {

	public static void main(String[] args) {
		boolean running = true;
        
        System.out.println("Welcome to Middle Earth Character Manager!");
        
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addCharacter();
                    break;
                case 2:
                    viewAllCharacters();
                    break;
                case 3:
                    updateCharacter();
                    break;
                case 4:
                    deleteCharacter();
                    break;
                case 5:
                    executeAttacks();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the program. Farewell!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
	
	private static void displayMenu() {
        System.out.println("\n=== Middle Earth Character Manager ===");
        System.out.println("1. Add a new character");
        System.out.println("2. View all characters");
        System.out.println("3. Update a character");
        System.out.println("4. Delete a character");
        System.out.println("5. Execute all characters' attack actions");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
	
	private static int getChoice() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	
	private static void addCharacter() {
		System.out.println("\n--- Add a New Character ---");
		
		System.out.print("Enter Character name: ");
		String name = scanner.nextLine();
		
		System.out.print("Enter character health points: ");
		double health = Double.parseDouble(scanner.nextLine());
		
		System.out.print("Enter character power: ");
		double power = Double.parseDouble(scanner.nextLine());
		
		MiddleEarthCharacter newCharacter = new MiddleEarthCharacter(name, helth, power);
		boolean added = CharacterManager.addCharacter(newCharacter);
		
		if (added) {
			System.out.println("Character added successfully!");
		} else {
			System.out.println("Failed to add character.");
		}
	}
	
	private static void updateCharacter() {
		System.out.println("\n--- Update a Character ---");
		
		System.out.print("Enter the name of the character to update: ");
		string name = scanner.nextLine();
		
		MiddleEarthCharacter character = CharacterManager.getCharacter(name);
		
		if (character == null) {
			System.out.println("Character not found.");
			return;
		}
		
		System.out.println("Updating Character: " + character.getName());
		System.out.println("Leave field blank to keep current value")
		
		System.out.print("Enter new name (" + Character.getName() + "): ");
		String newName = scanner.nextLine();
		if (newName.isEmpty()) {
			newName = character.getName();
		}
		
		System.out.print("Enter new health points (" + character.getHealth() + "): ");
		string healthStr = scanner.nextLine();
		int newHealth = character.getHealth();
		if (!healthStr.isEmpty()) {
			newHealth = Integer.parseInt(healthStr);
		}
		
		System.out.print("Enter new power (" + character.getPower() + "): ");
		string powerhStr = scanner.nextLine();
		int newPower = character.getHealth();
		if (!powerStr.isEmpty()) {
			newPower = Integer.parseInt(powerStr);
		}
		
		boolean updated = CharacterManager.updateCharacter(character, newName, newHealth, newPower);
		
		if (updated) {
			System.out.println("Character updated successfully!");
		} else {
			System.out.println("No changes were made.")
		}
	}
	
	private static void deleteCharacter() {
		System.out.println("\n--- Delete a Character ---");
		
		System.out.print("Enter the name of the character to delete: ");
		string name = scanner.nextLine();
		
		MiddleEarthCharacter character = CharacterManager.getCharacter(name);
		
		if (character == null) {
			System.out.println("Character not found.");
			return;
		}
		
		boolean deleted = CharacterManager.deleteCharacter(character);
		
		if (deleted) {
			System.out.println("Character " + character.getName() + " has been deleted.");
		} else {
			System.out.println("Failed to delete character.");
		}
		
		private static void executeAttacks() {
			System.out.println("\n--- Character Attacks ---");
			for (int i = 0; i < CharacterManager.size; i++) {
				CharacterManager.characters[i].attack();
			}
		}
	}
}
