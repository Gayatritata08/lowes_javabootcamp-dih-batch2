package com.labs.oops;

class StaticBlock {
	
	static {
		System.out.println("We are in static method");
	}
}
public class staticDemo5 {

	public static void main(String[] args) {
		StaticBlock sb =new StaticBlock();
		System.out.println("We are in main method");

	}

}
