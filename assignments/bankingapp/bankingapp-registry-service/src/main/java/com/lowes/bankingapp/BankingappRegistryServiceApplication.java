package com.lowes.bankingapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
public class BankingappRegistryServiceApplication {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(BankingappRegistryServiceApplication.class);
		logger.info("starting main class");
		SpringApplication.run(BankingappRegistryServiceApplication.class, args);
	}

}
