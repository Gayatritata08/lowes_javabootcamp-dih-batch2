package com.spring.labs.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	// http://localhost:8080/spring-rest-labs/greetings
	// @RequestMapping(path = "/greetings", method = RequestMethod.GET , consumes=
	// {"application/json"})
	// instead of requestMapping we can use belwo getmapping annotation below format
	// @GetMapping("/greetings")
	
	//we can using below type also

	@RequestMapping(path = "/greetings", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public String greeting() {
		return "Hello Spring Rest";
	}
	
	@RequestMapping(value = "/greetings", method = RequestMethod.GET, params = { "msg" })
	public String getGreeting(@RequestParam(required = false, defaultValue = "Hello") String msg) {
		return "Welcome to RESTful services training :) - " + msg;
	}
	
	@RequestMapping(value = "/greetings", method = RequestMethod.GET, headers = { "message" })
	public String getGreetingsText1(@RequestHeader String message) {
		return "Welcome to RESTful services training :) - " + message;
	}
	

	@RequestMapping(value = "/greetings", method = RequestMethod.GET, headers = { "message" })
	public String getGreetingsWithHeader(@RequestHeader String message) {
		return "Welcome to RESTful services training :) - " + message;
	}

}
