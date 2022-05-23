package com.labs.arrays;

public class ArrayMin {

	public static void main(String[] args) {
		int a[] = { 1, 2, 43, 5, 65, 78, 98 };
		minimumNumber(a);
	}

	private static void minimumNumber(int[] a) {
		int min = a[0];
		for(int i=1;i<a.length;i++) {
			a[i] = min;
			min=a[i];
		}
		
	}

}
