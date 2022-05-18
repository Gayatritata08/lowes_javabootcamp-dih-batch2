/*Array is collection of homogenious data type 
 * 
 * 
 * 
 * */

package com.labs.arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] a = new int[6];

		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		a[3] = 3;
		a[4] = 4;
		a[5] = 5;

		for (int i = 0; i < a.length; i++)
			System.out.println("Numbers are...." + a[i]);

		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		System.out.println("for loop b array");
		
		for (int j = 0; j < b.length; j++) {

			System.out.println(b[j]);

		}
		
		System.out.println("for each loop");
		
		for (int number : b) {

			System.out.println(number);
		}

	}

}
