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
//		System.out.println(model + " is flying around at " + speed + " mph ");
		double travel = getRange() / getSpeed();
		System.out.printf("The " +model+ " will land in "+"%.2f",travel);
		System.out.println();
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}
	
	
	
}
