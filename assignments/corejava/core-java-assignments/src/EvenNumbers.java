/*
 * Write a program to sum first n even numbers using a while loop.
 */

public class EvenNumbers {

	public static void main(String[] args) {
		int n = 8;
		int sum = 0;
		int i = 1;
		while (i < (n * 2)) {
			if ((i % 2) == 0) {
				sum = sum + i; 

			}
			i++;
		}
		System.out.println("sum of first n even numbers " + sum);

	}

}
