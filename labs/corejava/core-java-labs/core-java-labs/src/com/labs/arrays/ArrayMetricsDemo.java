package com.labs.arrays;

public class ArrayMetricsDemo {

	public static void main(String[] args) {
		// create two metrix

		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 6 } };
		int b[][] = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 60 } };

		int c[][] = new int[3][3];
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.println(c[i][j]+" ");
			}
			System.out.println();
			
		}
	}
		

}
