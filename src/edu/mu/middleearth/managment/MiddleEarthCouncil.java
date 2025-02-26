package edu.mu.middleearth.managment;

import edu.mu.middleearth.managment.CharacterManager;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	CharacterManager charManager;
	
	private MiddleEarthCouncil() {
		// prevented from being invoked from the outside
	}
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance; 
	}
	
	CharacterManager getCharacterManager() {
		return this.charManager;
	}
}
