package com.labs.spring.boot;

import org.springframework.stereotype.Component;

@Component
public class Greetings {
	
	String message = "Hello Spring Bean";
	
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
