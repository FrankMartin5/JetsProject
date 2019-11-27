package com.skilldistillery.jets;

public abstract class Jet {
// F i e l d s
	private String model;
	private double speed;
	private int range;
	private long price;
	
// C o n s t r u c t o r s
	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	
// M e t h o d s
	public void fly() {
		
	}
	
}
