package com.lowes.caluculatorapp;

import java.util.Scanner;

public class Caluculator {
	Scanner sc = new Scanner(System.in);
	int a;
	int b;

	public void getTwoNumbers() {
		System.out.println("Please Enter the first Number :");
		a = sc.nextInt();
		System.out.println("Please Enter the second Number :");
		b = sc.nextInt();

	}

	public void caluculateTwoNumber() {
		getTwoNumbers();
		int c = a + b;
		System.out.println("Sum of two numbers   " + c);

	}

	public void subtractTwoNumbers() {
		getTwoNumbers();
		int c = a - b;
		System.out.println("Subtract of two numbers is" + c);

	}

	public void multTwoNumbers() {
		getTwoNumbers();
		int c = a * b;
		System.out.println("Multiple of two numbers is" + c);
	}

	public void divideTwoNumbers() {
		getTwoNumbers();
		int c = a / b;
		System.out.println("Division of two numbers is" + c);

	}

}