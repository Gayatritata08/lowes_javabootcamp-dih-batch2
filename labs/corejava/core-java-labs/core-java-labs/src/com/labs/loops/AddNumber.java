package com.labs.loops;

class Demo {
	static int x = 10; // static variable

	int y = 10; // instance variable

	public int addNumber() {

		int a = 10; // local variable
		int b = 15;
		int c = a + b;

		System.out.println("Staic variable" + c);
		return c;
	}

}


public class AddNumber {

	public static void main(String[] args) {

		Demo obj = new Demo();
		//Demo2 obj1 = new Demo2();

		System.out.println("2 Numbers addition" + obj.addNumber());
		System.out.println("Instance variable" + Demo.x);
		System.out.println("static variable" + obj.y);

	}

}
