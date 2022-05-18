package com.labs.strings;

public class StrinBufferDemo {

	public static void main(String args[]) {

		StringBuffer sb = new StringBuffer("Hello");

		sb.append("World");
		System.out.println("String buffer .." + sb);

		// index 
		System.out.println(sb.indexOf("H"));

		// replace
		System.out.println(sb.replace(3, 6, "Gayatri"));

		// insert System.out.println(sb.insert(0, "World")); // delete
		System.out.println(sb.delete(3, 6));

		// capacity

		System.out.println("Capacity" + sb.capacity());
	}

}
