package com.labs.oops;

class Test {

	static int a;

	static {
		a = 20;
		System.out.println(a);
	}

	public void test() {
		a = 30;
		System.out.println(a);
	}

}

public class StaticDemo6 {

	public static void main(String[] args) {
		Test t1 = new Test();
		t1.test();
		System.out.println("t1.a ::" + t1.a);
		System.out.println("Test.a ::" + Test.a);
	}

}
