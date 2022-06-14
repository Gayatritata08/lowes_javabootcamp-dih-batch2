package com.labs.spring.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class HelloWorldSpringBootDemoWebApplication implements ApplicationRunner {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	WebApplicationContext context1;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringBootDemoWebApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		int count = context.getBeanDefinitionCount();
		System.out.println("Bean count "+count);
		
		int webcontextCount = context1.getBeanDefinitionCount();
		System.out.println("webcontextCount" + webcontextCount);

	}

}
