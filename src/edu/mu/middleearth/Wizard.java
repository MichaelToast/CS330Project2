package edu.mu.middleearth;

public class Wizard extends MiddleEarthCharacter{

	public Wizard(String name, double health, double power) {
		super(name, health, power);
	}

	@Override
	/**
	 * Removes health from target, if against a valid type. Attack fails if against same type or Human, extra damage against a Dwarf
	 * @param target Character to attack
	 * @return boolean detailing weather the attack failed or not 
	 * */
	boolean attack(MiddleEarthCharacter target) {
		double damageTaken = this.getPower();
		if (target.getRace().equals(this.getRace())) {
			// Ineffective against same type as self 
			return false;
		}
		else if (target.getRace().equals("Human")) {
			// Ineffective against Human 
			return false;
		}
		else if (target.getRace().equals("Dwarf")) {
			damageTaken = this.getPower() * 1.5;
		}
		target.setHealth(target.getHealth() - damageTaken);
		return true;
	}

	@Override
	String getRace() {
		return "Wizard";
	}

}
