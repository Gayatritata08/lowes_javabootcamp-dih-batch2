package com.labs.spring.carapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class CarAppMain {

	public static void main(String[] args) {
		
	//Cretaed IOC Container
		AbstractApplicationContext context =new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		System.out.println("No of beans" + context.getBeanDefinitionCount());
		
		for(String beanName :context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		
		Car bmw = context.getBean("bmw",Car.class);
		System.out.println(bmw.getColor() +" "+ bmw.getManufacturer() +" "+ bmw.getMode() );
		System.out.println(bmw.getEnginee().type );
		System.out.println(bmw.getEnginee().capacity );
		//Shutdown context
		context.registerShutdownHook();

	}

}
