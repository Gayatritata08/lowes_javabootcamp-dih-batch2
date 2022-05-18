package com.labs.oops;

public class Contractor1 extends Person1 {
	private int contractorId;
	private int duration; // in months
	private double cost; // in rupees

	public int getContractorId() {
		return contractorId;
	}

	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Contractor1(int contractorId, String name, int age, String gender, int duration, double cost) {
		super(age, gender, name);
		this.contractorId = contractorId;
		this.duration = duration;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Contractor1 [contractorId=" + contractorId + ", duration=" + duration + ", cost=" + cost + "]";
	}

	protected void printDetails() {
		System.out.println("Printing Contractor Details...");
		System.out.println("name" + this.getName());
		System.out.println("gender" + this.getGender());
		System.out.println("age" + this.getAge());
		System.out.println("contractorId" + this.contractorId);
		System.out.println("duration" + this.duration);
		System.out.println("cost" + this.cost);

	}

	public  void sayHello() {
		System.out.println("Hello Contractor class");

	}

}
