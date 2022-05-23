package com.labs.strings;

/*Strings are immutable because we are using the concept of string literal
 * *string literal mainly for memory management.
 * if string exist in string pool if we create with the same it will go check the pool it will refer the same content
 *  
 * 
 * 
 * */

public class StringDemo2 {

	public static void main(String[] args) {

		String str1 = "Happy";
		String str2 = " Birthday";
		String str3 = new String("Welcome");
		char[] ch = { 'W', 'O', 'R', 'l', 'D' };
		String str5 = new String("Welcome");
		// str2 = str5;

		System.out.println(str1 == str2); // false
		System.out.println(str3.equals(str5));// true
		System.out.println(str3 == str5);// false
		System.out.println(str2 == str5);// true
		System.out.println(str2.equals(str5));// true

		// String Concatination

		System.out.println("Concatinated String ..." + str1.concat(str2));

		// String substring

		String str7 = "Welcome to lowes";

		System.out.println(str7.substring(5));
		String str8 = str7.substring(5, 15);
		System.out.println(str8);
		CharSequence chsequence = str7.subSequence(5, 15);
		System.out.println("chsequence..." + chsequence);

		// string split

		String str9 = "gayatri.tata@gmail.com";
		String[] splitValues = str9.split("\\@");

		for (int i = 0; i < splitValues.length; i++)
			System.out.println("" + splitValues[i]);

	}

}
