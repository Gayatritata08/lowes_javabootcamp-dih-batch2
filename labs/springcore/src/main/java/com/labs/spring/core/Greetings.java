package com.labs.spring.core;

public class Greetings {
	
	String message = "Hello Spring";
	
	public Greetings() {
		
	}

	public Greetings(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
