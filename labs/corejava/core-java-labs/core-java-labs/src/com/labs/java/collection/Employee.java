package com.labs.java.collection;

public class Employee implements Comparable<Employee> {
	private String name;
	private int id;
	private String designation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "name=" + name + ", id=" + id + ", designation=" + designation ;
	}

	public Employee(String name, int i, String designation) {
		super();
		this.name = name;
		this.id = i;
		this.designation = designation;

	}

	@Override
	public int compareTo(Employee emp) {

		return this.getId() - emp.getId();
	}

}
