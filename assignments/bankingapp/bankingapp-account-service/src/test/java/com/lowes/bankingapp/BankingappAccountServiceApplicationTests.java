package com.lowes.bankingapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class BankingappAccountServiceApplicationTests {

	@Autowired
	ApplicationContext ctx;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testApplicationContext() {
		System.out.println("Context: " + ctx);
		System.out.println("No. of Beans: " + ctx.getBeanDefinitionCount());
		Assertions.assertThat(ctx).isNotNull();
	}

}
