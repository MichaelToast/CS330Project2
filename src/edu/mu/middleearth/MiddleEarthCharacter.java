package edu.mu.middleearth;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	abstract boolean attack(MiddleEarthCharacter target);
	abstract String getRace();
	
	public MiddleEarthCharacter(String name, double health, double power) {
		super();
		this.name = name;
		this.health = health;
		this.power = power;
	}
	

}
