package com.ramirez.zookeeper;

public class Bat extends Mammal {
	// MEMBER VARIABLES
	// CONSTRUCTOR
	// EMPTY
	public Bat() {
		super(300);
	}
	// FULL
	public Bat(int energyLevel) {
		super(energyLevel);
	}
	
	// GETTERS / SETTERS / OTHER METHODS
	public void fly(){
		System.out.println("Bat Taking Off - *WHOOSH*");
		energyLevel -= 50;
		System.out.println("Energy Level: "+energyLevel);
	}
	public void eatHumans() {
		System.out.println("so-well, never mind...");
		energyLevel += 25;
		System.out.println("Energy Level: "+energyLevel);
		
	}
	public void attackTown() {
		System.out.println("*EMERGENCY HORN ALARM RINGING*");
		energyLevel -= 100;
		System.out.println("Energy Level: "+energyLevel);
	}
}
