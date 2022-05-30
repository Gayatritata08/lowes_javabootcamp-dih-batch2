package com.labs.java8;

public interface DefaultDemo {

	// public ,static, final
	String message = "Hello java8";

	void print();

	// java8
	static void staticPrint() {
		System.out.println("We are in static print");
	}

	// java8
	default void defaultPrint() {
		System.out.println("We are in default print");
		privatePrint();
	}

	// java9
	private void privatePrint() {
		System.out.println("We are in private print");
	}

}
