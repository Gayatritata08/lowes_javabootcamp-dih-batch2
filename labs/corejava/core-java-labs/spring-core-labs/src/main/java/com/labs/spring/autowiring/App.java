package com.labs.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config_anno.xml");

		Employee employee = (Employee) context.getBean("emp");
		System.out.println(employee.hashCode());
		System.out.println(employee.getId());
		System.out.println(employee.getName());

		Employee employee2 = (Employee) context.getBean("emp");
		System.out.println(employee2.hashCode());
		System.out.println(employee2.getId());
		System.out.println(employee2.getName());
	}
}
