package com.ramirez.inheritancedemo;

public class FireHuman extends Human {
	// MEMBER VARIABLES
	protected int fireResistance;
	
	// CONSTRUCTOR METHODS
	public FireHuman() {
		super();
		this.fireResistance = 10;
	}

	public FireHuman(String name, int strength, int health, int intelligence, int fireResistance) {
		super(name, strength, health, intelligence);
		this.fireResistance = fireResistance;
	}

	// GETTER / SETTERS / OTHER METHODS
	public int getFireResistance() {
		return fireResistance;
	}

	public void setFireResistance(int fireResistance) {
		this.fireResistance = fireResistance;
	}
	
}
