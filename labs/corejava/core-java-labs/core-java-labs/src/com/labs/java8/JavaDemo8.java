//Functional programming
/*
 * 1.Immutable data
 * pure functionhigh order functions
 * recursion
 * malipulation of list
 * lazy evaluation
 * first class implementaion
 * No side sffects
 * declarative
 * parallaer processing
 * Abstraction over data and behaviour
 */

package com.labs.java8;

class Caluculator {
     int a;
     int b;
	public int add() {
		return (a=10  + ( b =20));

	}

	public int delete(int a, int b) {
		return a - b;
	}

	public int multiple(int a, int b) {
		return a * b;

	}

	public int division(int a, int b) {
		return a / b;
	}
}

public class JavaDemo8 {

	public static void main(String[] args) {
		Caluculator cal = new Caluculator();
		int a = cal.add();
		int a1 = cal.delete(80, 50);
		int a2 = cal.multiple(30, 50);
		int a3 = cal.division(100, 50);
		System.out.println(a );
	}
}
