package com.lowes.empapp;

public class Employee {

	private int empId;
	private String name;
	private int age;
	private String designation;
	private String department;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public Employee(int empId, String name, int age, String designation, String department) {
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.department = department;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", designation=" + designation
				+ ", department=" + department + "]";
	}

}
