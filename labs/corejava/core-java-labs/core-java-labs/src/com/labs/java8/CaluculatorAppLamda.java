/* 
 * 
 */
package com.labs.java8;



public class CaluculatorAppLamda  {

	public static void main(String[] args) {
		
		ICaluculator add = (a,b) -> {System.out.println(a+b);return a+b;};
		ICaluculator subract = (a,b)-> {System.out.println(a-b);return a-b;};
		ICaluculator multiply =(a,b) -> {System.out.println(a*b);return a*b;};
		ICaluculator division =(a,b) ->{System.out.println(a%b); return a%b;};
		
		System.out.println(" 10 + 20 = " + doCaluculate(10,20, add));
		System.out.println(" 10 - 20 = " + doCaluculate(30,40, subract));
		System.out.println(" 10 * 20 = " + doCaluculate(50,60, multiply));
		System.out.println(" 10 % 20 = " + doCaluculate(100,20, division));

	}

	private static Object doCaluculate(int i, int j, ICaluculator operation) {
		return operation.Caluculate(i,j);
		
	}

	
	public interface ICaluculator {
		public Object Caluculate(int a,int b);
		
		
	}

}
