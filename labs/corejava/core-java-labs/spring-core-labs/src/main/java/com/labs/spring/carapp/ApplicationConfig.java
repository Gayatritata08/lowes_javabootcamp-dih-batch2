package com.labs.spring.carapp;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

	@Bean(autowire=Autowire.BY_TYPE, initMethod="init",destroyMethod="destroy")
	@Lazy(value=true)
	@Scope("singleton")
	public Car bmw() {
		// Construcor injection
		//return new Car("xt", "BMW", "White", petrol());

		Car bmw = new Car();
		//bmw.setEnginee(petrol());
		bmw.setColor("Red");
		bmw.setMode("xt");
		bmw.setManufacturer("BMW");
		return bmw;
	}

	@Bean
	public Car nexon() {
		Car nexon = new Car();
		nexon.setEnginee(petrol());
		return nexon;
	}

	@Bean
	public Engine petrol() {
		return new Engine("petrol", 20000);
	}

	@Bean
	@Primary
	public Engine diesel() {
		return new Engine("diesel", 2000);
	}

	@Bean

	public Engine electric() {
		return new Engine("electric", 6000);
	}

}
