package com.ramirez.zookeeper;

public class Mammal {
	// MEMBER VARIABLES
	protected int energyLevel;
	// CONSTRUCTOR
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	// GETTERS / SETTERS / OTHER METHODS
	public int displayEnergy() {
		System.out.println("Energy Level: " + energyLevel);
		return energyLevel;
	}
	
}
