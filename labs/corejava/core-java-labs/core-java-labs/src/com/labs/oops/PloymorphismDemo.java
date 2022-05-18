package com.labs.oops;

class Parent1 {

	public void getDetails(String str) {
		System.out.println("We are in parent class" + str);
	}
}

class Child1 extends Parent1 {
	
	
	public void getDetails(String str) {
		System.out.println("We are in child class" + str);
	}
	
	
	public void getMessage(String str1) {
		System.out.println("Welcome  " + str1 );
	}
}

public class PloymorphismDemo {

	public static void main(String[] args) {
		Child1 c1 = new Child1();
		Parent1 p2 = new Child1();
		p2.getDetails("Paul");
		c1.getMessage("Henry");
		c1.getDetails("Mark");

	}

}
