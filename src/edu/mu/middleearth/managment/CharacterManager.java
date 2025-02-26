package edu.mu.middleearth.managment;

import edu.mu.middleearth.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters; 
	private int size;
	
	boolean addCharacter(MiddleEarthCharacter c) {
		// Add character
		return false; 
	}
	
	MiddleEarthCharacter getCharacter(String name) {
		// Return character
		return null;
	}
	
	boolean updateCharacter (MiddleEarthCharacter character, String
			name, int health, int power) {
		// Find character, update info
		return false; 
	}
	
	boolean deleteCharacter(MiddleEarthCharacter character) {
		if (character == null) {
			return false;
		}
		// Finds character in the array
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (characters[i].equals(character)) {
				index = i;
				break;
			}
		}
		// Character not found, no action taken
		if (index == -1) {
			return false;
		}
		
		// Shifts elements after the character to the left
		for (int i = index; i < size - 1; i++) {
			characters[i] = characters[i + 1];
		}
		
		// Ensures no duplicates after an element is deleted
		characters[size - 1] = null;
		size--;
		
		return true;
	}
	
	void displayAllCharacters() {
		// Display all characters
	}
	
}
