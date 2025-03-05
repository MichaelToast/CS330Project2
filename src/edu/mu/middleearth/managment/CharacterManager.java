package edu.mu.middleearth.managment;

import edu.mu.middleearth.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters; 
	private int size;
	private int arrayCap;
	
	/**
     * Constructs a new CharacterManager with an initial capacity of 20 characters.
     */
	public CharacterManager() {
		this.characters = new MiddleEarthCharacter[arrayCap];
		this.size = 0;
		this.arrayCap = 20;
	}
	/**
     * Adds a new MiddleEarthCharacter to the array. If the array is full, it automatically resizes
     * the array to accommodate more characters.
     *
     * @param c The MiddleEarthCharacter to add.
     * @return true if the character was added successfully, false if the character is null.
     */
	public boolean addCharacter(MiddleEarthCharacter c) {
		if (c == null) {
			return false;
		}
		if(size >= arrayCap) {
			resizeArray();
		}
		characters[size++] = c;
		return true;
	}
	/**
     * Retrieves a MiddleEarthCharacter from the array by its name.
     *
     * @param name The name of the character to retrieve.
     * @return The MiddleEarthCharacter with the specified name, or null if not found.
     */
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < size; i++) {
			if(characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		return null;
	}
	/**
     * Updates the attributes (name, health, and power) of a MiddleEarthCharacter.
     *
     * @param character The character to update.
     * @param name      The new name for the character.
     * @param health    The new health value for the character.
     * @param power     The new power value for the character.
     * @return true if any attribute was updated, false if the character is null or no changes were made.
     */
	public boolean updateCharacter (MiddleEarthCharacter character, String name, double health, double power) {
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
	/**
     * Deletes a MiddleEarthCharacter from the array.
     *
     * @param character The character to delete.
     * @return true if the character was deleted successfully, false if the character is null or not found.
     */
	boolean deleteCharacter(MiddleEarthCharacter character) {
		if (character == null) {
			return false;
		}
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (characters[i].equals(character)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return false;
		}
		
		for (int i = index; i < size - 1; i++) {
			characters[i] = characters[i + 1];
		}
		characters[size - 1] = null;
		size--;
		
		return true;
	}
	/**
     * Displays information for all characters in the array.
     */
	public void displayAllCharacters() {
		if(size == 0) {
			return;
		}
		for(int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
	/**
     * Resizes the internal array to double its current capacity.
     * Called automatically when the array is full.
     */
	private void resizeArray() {
		arrayCap *= 2;
		MiddleEarthCharacter[] moreCharacters = new MiddleEarthCharacter[arrayCap];
		System.arraycopy(characters, 0, moreCharacters, 0, size);
		characters = moreCharacters;
	}
}
