package com.labs.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//indicates it is going to be spring boot application
//combination of
//@componentscan @configuration @EnableAutoConfiguration
@SpringBootApplication
public class HelloWorldSpringBootApplication implements CommandLineRunner {

	/**
	 * Autowired we can not do for static variable...so context we can not access in
	 * main method. so need to give commandLineruuner there we have run method we
	 * will override and get the usage of context.
	 */
	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(HelloWorldSpringBootApplication.class);

		System.out.println("Befor launch of application");
		// Launch spring boot ( when we give this run method only it is going to be
		// launch
		SpringApplication.run(HelloWorldSpringBootApplication.class, args);
		System.out.println("after launch the application");
	}

	public void run(String... args) throws Exception {

		System.out.println("Hello servlet after the launch");
		System.out.println("context" + context);
		System.out.println("No of beans" + context.getBeanDefinitionCount());

		Greetings greetings = context.getBean("greetings", Greetings.class);
		greetings.getMessage();
		System.out.println(greetings.getMessage());
	}

}
