package com.labs.loops;

class Test {
	public Test(){
		System.out.println("Default Constructor");
	}
	
	public Test(int i){
		System.out.println("Parameterised Constuctor");
	}
	
	public void display(){
		System.out.println("Method  display");
	}
}

public class Demo7 {

	public static void main(String[] args) {
		Test tobj =new Test(10);
		tobj.display();

	}

}
