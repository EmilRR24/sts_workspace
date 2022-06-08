package com.ramirez.zookeeper;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla gorillaTest = new Gorilla();
		gorillaTest.throwSomething();
		gorillaTest.throwSomething();
		gorillaTest.throwSomething();
		
		gorillaTest.eatBananas();
		gorillaTest.eatBananas();
		
		gorillaTest.climb();
		
		Bat morbius = new Bat();
		morbius.attackTown();
		morbius.attackTown();
		morbius.attackTown();
		
		morbius.eatHumans();
		morbius.eatHumans();
		
		morbius.fly();
		morbius.fly();
	}

}
