package com.labs.spring.studentapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConfig {

	public static void main(String[] args) {

		/*
		 * # There are two type of IOC containers 1. BeanFactory 2. ApplicationContext
		 * Main diffrence between beanfactory and application context is :
		 * 
		 * 1.Bean instantiation - yes -yes 2.Integrated Lifecyale no yes
		 * 3.Automaticregistration : no yes 4.Automatic beanfactorypostprocessor - no
		 * yes 5.convenientaccess for internelisation no yes 6.Built (application
		 * event)in publication mechanism - no yes
		 */

//      System.out.println( "Hello World!" );
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		Student student = (Student) context.getBean("student1");
		Student student1 = (Student) context.getBean("student2");
		Student student2 = (Student) context.getBean("student3");
		System.out.println(student);
		System.out.println(student1);
		System.out.println(student2);

		Employee employee = context.getBean("employee1", Employee.class);
		System.out.println(employee);

		Customer customer = (Customer) context.getBean("customer1");
		System.out.println(customer);

		User user = context.getBean("user1", User.class);
		System.out.println(user);

		Product product = (Product) context.getBean("product1");
		System.out.println(product);

		Calculator cal1 = context.getBean("calculator1", Calculator.class);
		cal1.sum();

	}

}
