package edu.mu.middleearth;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	public abstract boolean attack(MiddleEarthCharacter target);
	public abstract String getRace();
	
	
	/**
     * Constructs a new MiddleEarthCharacter with the specified name, health, and power.
     *
     * @param name   The name of the character.
     * @param health The health points of the character.
     * @param power  The power level of the character.
     */
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	/**
     * Displays the character's information, including name, health, and power.
     */
	public void displayInfo() {
		System.out.println("NAME: " + name + ", HEALTH: " + health + ", POWER: " + power);
	}
	
	// Ask if we are allowed these
	/**
     * Returns the name of the character.
     *
     * @return The name of the character.
     */
	public String getName() {
		return name;
	}
	/**
     * Sets the name of the character.
     *
     * @param name The new name of the character.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Returns the health points of the character.
     *
     * @return The health points of the character.
     */
	public double getHealth() {
		return health;
	}
	/**
     * Sets the health points of the character. If the provided health is negative,
     * it is automatically set to 0.
     *
     * @param health The new health points of the character.
     */
	public void setHealth(double health) {
		this.health = health;
		if (this.health < 0) {
			this.health = 0;
		}
	}
	/**
     * @return The power level of the character.
     */
	public double getPower() {
		return power;
	}
	/**
     * @param power The new power level of the character.
     */
	public void setPower(double power) {
		this.power = power;
	}
	

}
