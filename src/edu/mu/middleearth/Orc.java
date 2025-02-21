package edu.mu.middleearth;

public class Orc extends MiddleEarthCharacter{

	public Orc(String name, double health, double power) {
		super(name, health, power);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	String getRace() {
		return "Orc";
	}

}
