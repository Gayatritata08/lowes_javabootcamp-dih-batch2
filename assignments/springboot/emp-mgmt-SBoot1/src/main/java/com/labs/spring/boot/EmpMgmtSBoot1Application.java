package com.labs.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpMgmtSBoot1Application {
	private static final Logger logger = LoggerFactory.getLogger(EmpMgmtSBoot1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(EmpMgmtSBoot1Application.class, args);

	}

}
