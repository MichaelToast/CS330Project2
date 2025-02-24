package edu.mu.middleearth;

public class Wizard extends MiddleEarthCharacter{

	public Wizard(String name, double health, double power) {
		super(name, health, power);
	}

	@Override
	/**
	 * Remove health from target if against valid type
	 * @param target Character to attack
	 * @return boolean detailing weather the attack failed or not 
	 * */
	boolean attack(MiddleEarthCharacter target) {
		if (target.getRace().equals(this.getRace())) {
			// Ineffective against same type as self 
			return false;
		}
		else if (target.getRace().equals("Human")) {
			// Ineffective against Human 
			return false;
		}
		else if (target.getRace().equals("Dwarf")) {
			target.takeDamage(this.getPower() * 1.5);
			return true;
		}
		
		target.takeDamage(this.getPower());
		return true;
	}

	@Override
	String getRace() {
		return "Wizard";
	}

}
