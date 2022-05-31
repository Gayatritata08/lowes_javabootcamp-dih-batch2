package com.labs.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");

		System.out.println("Beans Count" + context.getBeanDefinitionCount());

		Greetings obj = (Greetings) context.getBean("greetings");
		
		Greetings obj1 = (Greetings) context.getBean("greetings1");
		
		Greetings obj2= (Greetings) context.getBean("greetings2");
		
		
		System.out.println(obj.getMessage());
		
		System.out.println(obj1.getMessage());
		
		System.out.println(obj2.getMessage());
	}

}
