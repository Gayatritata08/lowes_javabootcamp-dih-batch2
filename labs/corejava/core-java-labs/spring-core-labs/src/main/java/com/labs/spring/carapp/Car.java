package com.labs.spring.carapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {

	String mode;
	String manufacturer;
	String color;
	
	@Autowired
	@Qualifier("petrol")
	Engine enginee;
	
	public Car() {
		
	}

	public Car(String mode, String manufacturer, String color, Engine enginee) {
		super();
		this.mode = mode;
		this.manufacturer = manufacturer;
		this.color = color;
		this.enginee = enginee;
	}

	public Car(String mode, String manufacturer, String color) {
		this.mode = mode;
		this.manufacturer = manufacturer;
		this.color = color;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Engine getEnginee() {
		return enginee;
	}

	public void setEnginee(Engine enginee) {
		this.enginee = enginee;
	}
	public void init() {
		System.out.println("Car been initialised");
	}
	public void destroy() {
		System.out.println("Car been destroyed");
	}

}
