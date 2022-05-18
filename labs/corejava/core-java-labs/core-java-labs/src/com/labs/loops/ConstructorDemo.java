package com.labs.loops;


class Employee{
	
	public Employee(){
		System.out.println("Default Constructor");
	}
	
	public Employee(String name, int id){
		System.out.println("Parametrised Constructor");
	}
	
	public Employee(int id,String Employee ) {
		System.out.println("Reverse Argument Consructor");
		
	}
}
public class ConstructorDemo {

	public static void main(String[] args) {
	    Employee eobj = new Employee();

	}

}
