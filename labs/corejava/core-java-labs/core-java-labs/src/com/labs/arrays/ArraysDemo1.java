package com.labs.arrays;

public class ArraysDemo1 {

	static int[] get() {
		return new int[] { 1, 2, 3, 4, 5, 6, 7 };
	}

	public static void main(String[] args) {

		int a[] = get();
		
		for(int k=0;k<a.length;k++) {
			System.out.println(a[k]);
		}

		int b[][] = { { 1, 2, 3 }, { 10, 11, 12 }, { 90, 89, 87 } };

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}

}
