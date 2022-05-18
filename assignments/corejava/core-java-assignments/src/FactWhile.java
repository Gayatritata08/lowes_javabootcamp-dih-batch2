/*
 * Write a program to find the factorial of a given number using while loops.
 */

import java.util.Scanner;

public class FactWhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the value of n");
		int i = sc.nextInt();
		sc.close();
		int fact = i, j = 1;
		while (j < i) {
			fact = fact * (i - j);
			j++;
		}
		System.out.println("Factorial of given number" + fact);
	}

}
