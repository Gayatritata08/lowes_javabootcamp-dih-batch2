package com.labs.oops;

public class PersonMain {

	public static void main(String[] args) {
		System.out.println("Creatig Employee object");

		// Created one object for emplyee of type employee
		/*
		 * Employee1 employee = new Employee1(34917, "Mark", 35, "Male", "Consulatant",
		 * "ITdept", 85000); employee.appraise(); System.out.println("Employee object" +
		 * employee.toString());
		 * 
		 * // create one Object for Contractor type of contractor
		 * System.out.println("Contractor object created"); Contractor1 contractor1 =
		 * new Contractor1(1243, "Paul", 36, "Male", 24, 500000);
		 * System.out.println("Contractor details : " + contractor1.toString());
		 */

		// create object for Employee of type person
		Person1 person1 = new Employee1(43523, "Peter", 26, "Male", "SE", "ITDept", 89000);
		System.out.println("Person Details" + person1.toString());
		person1.printDetails(); //calling Employee details
		person1.sayHello();//calling employee sayhello method
		
		System.out.println(" ");

		Person1 person2 = new Contractor1(4567, "Peter", 32, "Male", 43, 543683);
		person2.printDetails(); //calling Contractor details
		person2.sayHello();//calling contractor sayHello Method

	}

}
