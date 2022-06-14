package com.labs.spring.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbootRestEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootRestEmployeeApplication.class, args);
		// LoggerFactory logger =
		// LoggerFactory.info(SbootRestEmployeeApplication.class);

		System.out.println("I am on controllerl");
	}

}
