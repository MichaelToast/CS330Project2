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
		
	public void displayInfo() {
		System.out.println("NAME: " + name + ", HEALTH: " + health + ", POWER: " + power);
	}
	
	// Ask if we are allowed these
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
		if (this.health < 0) {
			this.health = 0;
		}
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	

}
