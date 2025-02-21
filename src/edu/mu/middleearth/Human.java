package edu.mu.middleearth;

public class Human extends MiddleEarthCharacter{

	public Human(String name, double health, double power) {
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
		return "Human";
	}

}
