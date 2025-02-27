package edu.mu.middleearth;

public class Human extends MiddleEarthCharacter{

	public Human(String name, double health, double power) {
		super(name, health, power);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Removes health from target, if against a valid type. Attack fails if against same type or Orc, extra damage against a Wizard
	 * @param target Character to attack
	 * @return boolean detailing weather the attack failed or not 
	 * */
	boolean attack(MiddleEarthCharacter target) {
		if (target.getRace().equals(this.getRace()) || target.getRace().equals("Orc")) {
			// Ineffective against same type as self and orc
			return false;
		}
		
		double damageTaken = target.getRace().equals("Wizard") ? this.getPower() * 1.5 : this.getPower();
		target.setHealth(target.getHealth() - damageTaken);
		return true;
	}

	@Override
	String getRace() {
		return "Human";
	}

}
