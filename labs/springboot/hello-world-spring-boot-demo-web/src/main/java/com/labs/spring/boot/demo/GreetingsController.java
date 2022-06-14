package com.labs.spring.boot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	
	@GetMapping("/greetings")
	public String greetings() {
		return "Welcom Spring Boot is Taking rest";
	}

}
