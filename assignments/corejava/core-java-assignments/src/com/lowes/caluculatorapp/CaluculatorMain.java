package com.lowes.caluculatorapp;

import java.util.Scanner;

public class CaluculatorMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);		
		int choice;

		Caluculator cal = new Caluculator();
		System.out.println("***Welcome to Caluculator Management Application*****" + "\n 1. Add " + "\n 2. Subtract"
				+ "\n 3. Multiple" + "\n 4. Divide" + "\n 5. Exit");
		do {
			System.out.println("Please enter your choice:");
			choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Add :");
				cal.caluculateTwoNumber();
				break;
			case 2:
				System.out.println("Subtract:");
				cal.subtractTwoNumbers();
				break;
			case 3:
				System.out.println("Multiply :");
				cal.multTwoNumbers();
				break;
			case 4:
				System.out.println("Divide :");
				cal.divideTwoNumbers();
				break;
			case 5:
				System.out.println("Thank you for using the application");
				System.exit(0);
			default:
				System.out.println("Please Enter Valid Input");
				break;

			}
		} while (choice != 0);

	}

}
