package edu.mu.middleearth.managment;

import edu.mu.middleearth.managment.CharacterManager;

/**
 * Singleton class that provides access to the CharacterManager
 */
public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	CharacterManager charManager;
	/**
     * Private constructor to enforce the singleton pattern
     * Initializes the CharacterManager instance
     */
	private MiddleEarthCouncil() {
		charManager = new CharacterManager();
	}
	/**
     * Returns the single instance of MiddleEarthCouncil. If the instance does not exist,
     * it creates a new one. This ensures that only one instance of MiddleEarthCouncil exists
     * throughout the application.
     *
     * @return The singleton instance of MiddleEarthCouncil.
     */
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance; 
	}
	/**
     * Returns the CharacterManager instance associated with this MiddleEarthCouncil.
     * The CharacterManager is responsible for managing characters in Middle Earth.
     *
     * @return The CharacterManager instance.
     */
	public CharacterManager getCharacterManager() {
		return this.charManager;
	}
}
