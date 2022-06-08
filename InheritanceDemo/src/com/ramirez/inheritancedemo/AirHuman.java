package com.ramirez.inheritancedemo;

public class AirHuman extends Human{
	// MEMBER VARIABLES
	protected int airResistance;
	
	// CONSTRUCTORS
	public AirHuman(String name, int strength, int health, int intelligence, int airResistance) {
		super(name, strength, health, intelligence);
		this.airResistance = airResistance;
	}
	
	public AirHuman() {
		super();
		this.airResistance = 10;
	}

	// GETTERS / SETTERS / OTHER METHODS
	public int getAirResistance() {
		return airResistance;
	}
	
	public void setAirResistance(int airResistance) {
		this.airResistance = airResistance;
	}
	
}
