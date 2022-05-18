/*Write a program to calculate the sum of the numbers occurring in the multiplication table of 8.*/

import java.util.Scanner;

public class MathTableSumResult {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the value of n");
		int i = sc.nextInt();
		sc.close();
		int result = 0;
		for (int j = 1; j <= 10; j++)
			result = result + (i * j);
		System.out.println("Result of multiplication table of given number is " + result);
	}

}
