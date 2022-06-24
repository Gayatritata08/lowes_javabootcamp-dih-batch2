package com.lowes.bankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class BankingappFundsTransferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingappFundsTransferServiceApplication.class, args);
	}

}
