package com.labs.exception;

public class customExcetion extends Exception {

	public customExcetion(String string) {
		super();
	}

	public void customException(String message) {
		System.out.println("Insufficient Balance");
	}

}
