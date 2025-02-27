package edu.mu.middleearth.managment;

import edu.mu.middleearth.managment.CharacterManager;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	CharacterManager charManager;
	
	private MiddleEarthCouncil() {
		charManager = new CharacterManager();
	}
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance; 
	}
	
	public CharacterManager getCharacterManager() {
		return this.charManager;
	}
}
