package edu.mu.middleearth;

public class Orc extends MiddleEarthCharacter{

	public Orc(String name, double health, double power) {
		super(name, health, power);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Removes health from target, if against a valid type. Attack fails if against same type or Elf, extra damage against a Human
	 * @param target Character to attack
	 * @return boolean detailing weather the attack failed or not 
	 * */
	public boolean attack(MiddleEarthCharacter target) {
		if (target.getRace().equals(this.getRace()) || target.getRace().equals("Elf")) {
			// Ineffective against same type as self and elf
			return false;
		}
			
		double damageTaken = target.getRace().equals("Human") ? this.getPower() * 1.5 : this.getPower();
		target.setHealth(target.getHealth() - damageTaken);
		return true;
	}

	@Override
	public String getRace() {
		return "Orc";
	}

}
