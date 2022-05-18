package com.labs.oops;

class Employee {

	public String firstName;
	public String lastName;
	public String employeeId;

	public void getFullName() {
		System.out.println(firstName + " " + lastName);
	}
}

class FullTimeEmployee extends Employee{

	public int annualSalary;

}

class PartTimeEmployee extends Employee {
	public int hourleySalary;

}

public class InheritanceDemo {

	public static void main(String[] args) {
		FullTimeEmployee fte= new FullTimeEmployee();
		fte.firstName="Mark";
		fte.lastName="Smith";
		fte.getFullName();
		
		PartTimeEmployee pte = new PartTimeEmployee();
		pte.firstName = "Paul";
		pte.lastName="Watson";
		pte.getFullName();

	}

}
