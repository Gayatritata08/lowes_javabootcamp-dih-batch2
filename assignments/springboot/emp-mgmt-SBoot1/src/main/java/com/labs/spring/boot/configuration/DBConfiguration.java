package com.labs.spring.boot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {
	

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println("DB Connection for Dev ");
		System.out.println(driverClassName);
		System.out.println(url);
		System.out.println(username);
		return "DB Connection For Dev";

	}

	@Profile("test")
	@Bean
	public String testDatabaseConnection() {
		System.out.println("DB Connection for test ");
		System.out.println(driverClassName);
		System.out.println(url);
		System.out.println(username);
		return "DB Connection For test";

	}

	@Profile("prod")
	@Bean
	public String prodDatabaseConnection() {
		System.out.println("DB Connection for prod ");
		System.out.println(driverClassName);
		System.out.println(url);
		System.out.println(username);
		return "DB Connection For prod";

	}

}
