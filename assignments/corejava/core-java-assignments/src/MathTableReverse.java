/*Write a program to print a multiplication table of 10 in reverse order */

import java.util.Scanner;

public class MathTableReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the value of n");
		int i = sc.nextInt();
		sc.close();

		for (int j = 10; j > 0; j--)
			System.out.println(i + "*" + j + "=" + i * j);

	}

}
