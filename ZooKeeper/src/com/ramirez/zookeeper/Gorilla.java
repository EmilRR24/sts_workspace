package com.ramirez.zookeeper;

public class Gorilla extends Mammal {
	// MEMBER VARIABLES
	
	// CONSTRUCTORS
	public Gorilla() {
		super();
	}
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	// GETTERS / SETTERS / OTHER METHODS
	public int throwSomething() {
		System.out.println("*Gorilla has thrown a banana!*");
		energyLevel -= 5;
		System.out.println("Energy Level: "+energyLevel);
		return energyLevel;
	}
	public int eatBananas() {
		System.out.println("Gorilla is eating...");
		energyLevel += 10;
		System.out.println("Energy Level: "+energyLevel);
		return energyLevel;
	}
	public int climb() {
		System.out.println("*Gorilla climbed a tree!*");
		energyLevel -= 10;
		System.out.println("Energy Level: "+energyLevel);
		return energyLevel;
	}
}
