package com.ramirez.fruitstore.models;

public class Item {
	//MEMBER VARIABLES / ATTRIBUTES
	private String name;
	private double price;
	
	//CONSTRUCTORS
	//FULL
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	//EMPTY
	public Item() {
		
	}
	// GETTERS / SETTERS / OTHER METHODS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
