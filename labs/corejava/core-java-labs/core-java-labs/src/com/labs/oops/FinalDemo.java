package com.labs.oops;

class Car {

	public int speedLimit = 50;

	public void drive() {
		System.out.println("driving ....");
	}
}

class Bike extends Car {
	@Override
	public void drive() {

	}
}

public class FinalDemo {

	public static void main(String[] args) {
		Car c = new Car();
		c.speedLimit = 60;

	}

}
