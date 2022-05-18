package com.labs.strings;

public class PerformanceStrbuffStrbuild {

	public static void main(String[] args) {
		System.out.println("Performance Test");
		long startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer("Hello");

		for (int i = 0; i <= 100000; i++) {
			sb.append("World");
		}

		System.out.println("Time Takend by StringBuffer class" + (System.currentTimeMillis() - startTime) + "ms");

		System.out.println("************************");
		startTime = System.currentTimeMillis();
		StringBuilder sb1 = new StringBuilder("Hello");

		for (int i = 0; i <= 100000; i++) {
			sb1.append("World");
		}

		System.out.println("Time Takend by StringBuilder class" + (System.currentTimeMillis() - startTime) + "ms");
	}

}
