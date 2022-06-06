package com.labs.spring.carapp;

public class Engine {
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	int capacity;

	public int getCapacity() {
		return capacity;
	}

	public Engine(String type, int capacity) {
		super();
		this.type = type;
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Engine [type=" + type + ", capacity=" + capacity + "]";
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
