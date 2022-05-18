package com.labs.oops;

public class Employee1 extends Person1 implements appraisable {

	private int empId;
	private String designation;
	private String department;
	private double salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee1 [empId=" + empId + ", designation=" + designation + ", department=" + department + ", salary="
				+ salary + "]";
	}

	// overloaded custom constructor
	public Employee1(int empId, String name, int age, String gender, String designation, String department,
			double salary) {
		super(age, gender, name);
		this.empId = empId;
		this.designation = designation;
		this.department = department;
		this.salary = salary;
	}

	protected void printDetails() {
		System.out.println("Printing Employee desatils....");
		System.out.println("name" + this.getName());
		System.out.println("gender" + this.getGender());
		System.out.println("age" + this.getAge());
		System.out.println("empId" + this.empId);
		System.out.println("designation" + this.designation);
		System.out.println("department" + this.department);
		System.out.println("salary" + this.salary);

	}

	public void sayHello() {
		System.out.println("Hello Employee class");

	}

	@Override
	public void appraise() {
		System.out.println("Employee apprisable should be called");

	}

}
