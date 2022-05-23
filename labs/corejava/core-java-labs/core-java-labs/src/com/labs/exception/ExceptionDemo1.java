package com.labs.exception;

public class ExceptionDemo1 {
	public static void main(String args[]) {
		int a = 40;
		int b = 0;
		int c=0;
		try {
            c = a / b;
        } catch (ArithmeticException ex) {
            System.out.println("invalid number");
        }
        catch (Exception ex) {
            System.out.println("exception occur");
        }
        System.out.println(c);
	}
}
