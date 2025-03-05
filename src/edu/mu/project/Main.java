package edu.mu.project;

import edu.mu.middleearth.Dwarf;
import edu.mu.middleearth.Elf;
import edu.mu.middleearth.Human;
import edu.mu.middleearth.MiddleEarthCharacter;
import edu.mu.middleearth.Orc;
import edu.mu.middleearth.managment.CharacterManager;
import edu.mu.middleearth.managment.MiddleEarthCouncil;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static CharacterManager characterManager;
	
	public static void main(String[] args) {
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		characterManager = council.getCharacterManager();
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
                    viewAllCharacters(characterManager);
                    break;
                case 3:
                    //updateCharacter();
                    break;
                case 4:
                    deleteCharacter();
                    break;
                case 5:
                    executeAttacks(characterManager);
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
	/**
     * Displays the main menu of the application, listing all available options for the user.
     */
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
	/**
     * Prompts the user to enter a choice from the menu and returns the selected option.
     * If the input is not a valid integer, it returns -1 to indicate an invalid choice.
     *
     * @return The user's choice as an integer, or -1 if the input is invalid.
     */
	private static int getChoice() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	/**
	 * Displays a list of all characters currently managed by the CharacterManager.
	 * This method prints a header and then calls the displayAllCharacters method
	 * to display the details of each character.
	 */
	private static void viewAllCharacters(CharacterManager manager) {
        System.out.println("\n=== All Characters ===");
        manager.displayAllCharacters();
    }
	
	/**
     * Prompts the user to input details for a new character and adds the character
     * to the character manager if the input is valid.
     */
	private static void addCharacter() {
		System.out.println("\n--- Add a New Character ---");
		MiddleEarthCharacter newCharacter = null;
			
		
		System.out.print("Enter Character name: ");
		String name = scanner.nextLine();
		
		System.out.print("Enter character health points: ");
		double health = Double.parseDouble(scanner.nextLine());
		
		System.out.print("Enter character power: ");
		double power = Double.parseDouble(scanner.nextLine());
		
		System.out.print("Enter Character Type (Dwarf, Elf, Human, Orc, Wizard): ");
		String type = scanner.nextLine();
		if (type.equals("Dwarf")) {
			newCharacter = new Dwarf(name, health, power);
		}
		else if (type.equals("Elf")) {
			newCharacter = new Elf(name, health, power);
		}
		else if (type.equals("Human")) {
			newCharacter = new Human(name, health, power);
		}
		else if (type.equals("Orc")) {
			newCharacter = new Orc(name, health, power);
		}
		else {
			System.out.println("Invalid Type");
		}
		
		boolean added = characterManager.addCharacter(newCharacter);
		
		if (added) {
			System.out.println("Character added successfully!");
		} else {
			System.out.println("Failed to add character.");
		}
	}
	
	/**
     * Prompts the user to input the name of a character to update and allows the user
     * to modify the character's name, health points, and power. If no changes are made,
     * the character remains unchanged.
     */
	private static void updateCharacter() {
		System.out.println("\n--- Update a Character ---");
		
		System.out.print("Enter the name of the character to update: ");
		String name = scanner.nextLine();
		
		MiddleEarthCharacter character = characterManager.getCharacter(name);
		
		if (character == null) {
			System.out.println("Character not found.");
			return;
		}
		
		System.out.println("Updating Character: " + character.getName());
		System.out.println("Leave field blank to keep current value");
		
		System.out.print("Enter new name (" + character.getName() + "): ");
		String newName = scanner.nextLine();
		if (newName.isEmpty()) {
			newName = character.getName();
		}
		
		System.out.print("Enter new health points (" + character.getHealth() + "): ");
		String healthStr = scanner.nextLine();
		double newHealth = character.getHealth();
		if (!healthStr.isEmpty()) {
			newHealth = Double.parseDouble(healthStr);
		}
		
		System.out.print("Enter new power (" + character.getPower() + "): ");
		String powerStr = scanner.nextLine();
		double newPower = character.getPower();
		if (!powerStr.isEmpty()) {
			newPower = Double.parseDouble(powerStr);
		}
		
		boolean updated = characterManager.updateCharacter(character, newName, newHealth, newPower);
		
		if (updated) {
			System.out.println("Character updated successfully!");
		} else {
			System.out.println("No changes were made.");
		}
	}
	/**
     * Prompts the user to input the name of a character to delete and removes the character
     * from the character manager if found.
     */
	private static void deleteCharacter() {
		System.out.println("\n--- Delete a Character ---");
		
		System.out.print("Enter the name of the character to delete: ");
		String name = scanner.nextLine();
		
		MiddleEarthCharacter character = characterManager.getCharacter(name);
		
		if (character == null) {
			System.out.println("Character not found.");
			return;
		}
		
		boolean deleted = characterManager.deleteCharacter(character);
		
		if (deleted) {
			System.out.println("Character " + character.getName() + " has been deleted.");
		} else {
			System.out.println("Failed to delete character.");
		}
	}
		
		
	private static void executeAttacks(CharacterManager characterManager) {
		System.out.println("\n--- Character Attacks ---");
		for (int i = 0; i < characterManager.getSize(); i++) {
			characterManager.getCharacter(i).attack();
		}
	}
}
