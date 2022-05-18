/*Write a program to print the multiplication table of a given number n. */

import java.util.Scanner;

public class MathTable {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the value of n");
		int i = sc.nextInt();
		sc.close();

		for (int j = 1; j <= 10; j++)
			System.out.println(i + "*" + j + "=" + i * j);

	}

}
