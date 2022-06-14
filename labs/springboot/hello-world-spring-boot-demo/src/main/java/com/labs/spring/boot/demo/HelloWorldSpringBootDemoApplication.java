package com.labs.spring.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldSpringBootDemoApplication {

	public static void main(String[] args) {
	
		System.out.println("Launchng before apring boot Testing");
		SpringApplication.run(HelloWorldSpringBootDemoApplication.class, args);
	}

}
