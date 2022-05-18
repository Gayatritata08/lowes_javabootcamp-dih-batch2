/*Array is collection of homogeneous data type.
 * 
 * Adv:
 * Index base search
 * Type Safety.
 * 
 * Dis Adv:
 * 
 * Not Growable
 * 
 * 
 * 1.Single Dimension Array
 * 2.Multi Dimension Array.
 * 
 * 
 * */

package com.labs.arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] a = new int[6];//Declaration Instantiation

		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		a[3] = 3;
		a[4] = 4;
		a[5] = 5;

		for (int i = 0; i < a.length; i++)
			System.out.println("Numbers are...." + a[i]);

		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; //Initialization

		System.out.println("for loop b array");

		for (int j = 0; j < b.length; j++) {

			System.out.println(b[j]);

		}

		System.out.println("for each loop b array");

		for (int number : b) {

			System.out.println(number);
		}

	}

}
