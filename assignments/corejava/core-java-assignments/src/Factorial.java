/*
 * Write a program to find the factorial of a given number using for loops.
 */

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the value of n");
		int i = sc.nextInt();
		sc.close();
		int fact = i;
		for (int j = 1; j < i; j++) {
			fact = fact * (i - j);
		}
		System.out.println("Factorial of given number" + fact);
	}

}
