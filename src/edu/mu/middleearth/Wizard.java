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
	public boolean attack(MiddleEarthCharacter target) {
		if (target.getRace().equals(this.getRace()) || target.getRace().equals("Human")) {
			// Ineffective against same type as self and human
			return false;
		}
			
		double damageTaken = target.getRace().equals("Dwarf") ? this.getPower() * 1.5 : this.getPower();
		target.setHealth(target.getHealth() - damageTaken);
		return true;
	}

	@Override
	String getRace() {
		return "Wizard";
	}

}
