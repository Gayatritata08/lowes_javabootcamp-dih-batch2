package com.labs.strings;

public class StrinBufferDemo {

	public static void main(String args[]) {

		StringBuffer sb = new StringBuffer("Hello");

		sb.append("World");
		System.out.println("String buffer .." + sb);

		// index
		StringBuffer sb1 = new StringBuffer("Welcome");
		System.out.println(sb1.indexOf("c"));

		// replace
		StringBuffer sb2 = new StringBuffer("Happy Birthday");
		System.out.println(sb2.replace(3, 6, "Gayatri"));

		// insert
		StringBuffer sb3 = new StringBuffer("My Home");
		System.out.println(sb3.insert(0, "World"));

		// delete
		StringBuffer sb4 = new StringBuffer("Lowes Family");
		System.out.println(sb4.delete(3, 6));

		// capacity
		StringBuffer sb5 = new StringBuffer("Welcome to Lowes");
		System.out.println("Capacity" + sb5.capacity());

		// reverse
		StringBuffer sb6 = new StringBuffer("Welcome");
		System.out.println("Reverse of String buffer" + sb6.reverse());
	}

}
