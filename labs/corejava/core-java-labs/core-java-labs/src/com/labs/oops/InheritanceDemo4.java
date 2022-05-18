package com.labs.oops;

class Caluculator {
	
	//non static method
	
	public void addNumber(int a,int b) {
		System.out.println(a+b);
	}
	
	//static method
	
	public static void subNumber(int a,int b){
		System.out.println(a-b);
	}
}

public class InheritanceDemo4 {

	public static void main(String[] args) {
		Caluculator c =new Caluculator();
		c.addNumber(100, 50);
		Caluculator.subNumber(100, 50);

	}

}
