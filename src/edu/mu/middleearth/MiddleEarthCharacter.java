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
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	
	// ASK IF THIS IS OK
	protected void takeDamage(double damageTaken) {
		health = health - damageTaken;
		if (health < 0) {
			health = 0;
		}
		
	}
	

}
