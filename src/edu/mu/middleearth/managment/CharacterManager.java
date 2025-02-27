package edu.mu.middleearth.managment;

import edu.mu.middleearth.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters; 
	private int size;
	private int arrayCap;
	
	public CharacterManager() {
		this.characters = new MiddleEarthCharacter[arrayCap];
		this.size = 0;
		this.arrayCap = 20;
	}
	
	boolean addCharacter(MiddleEarthCharacter c) {
		if (c == null) {
			return false;
		}
		if(size >= arrayCap) {
			resizeArray();
		}
		characters[size++] = c;
		return true;
	}
	
	MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < size; i++) {
			if(characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		return null;
	}
	
	boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		if (character == null) {
			return false;
		}
		boolean updateStatus = false;
		
		if(!character.getName().equals(name)) {
			character.setName(name);
			updateStatus = true;
		}
		
		if(character.getHealth() != health) {
			character.setHealth(health);
			updateStatus = true;
		}
		
		if(character.getPower() != power) {
			character.setPower(power);
			updateStatus = true;
		}
		return updateStatus;
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
		if(size == 0) {
			return;
		}
		for(int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
	
	private void resizeArray() {
		arrayCap *= 2;
		MiddleEarthCharacter[] moreCharacters = new MiddleEarthCharacter[arrayCap];
		System.arraycopy(characters, 0, moreCharacters, 0, size);
		characters = moreCharacters;
	}
}
