package com.lowes.bankingapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.lowes.bankingapp.model.Account;
import com.lowes.bankingapp.service.AccountService;

// API Test / Integration test
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountServiceControllerTest {

	@Autowired
	TestRestTemplate restTemp;

	@MockBean
	@Autowired
	AccountService acctService;

	private static List<Account> accounts = new ArrayList<>();

	HttpHeaders headers = new HttpHeaders();

	@BeforeEach
	public void setup() throws AccountException {
		// Initialize Test data
		Account acct1 = new Account();

		acct1.setId(1);
		acct1.setName("Gayatri");
		acct1.setBalance(100000);
		acct1.setStatus("ACTIVE");
		acct1.setType("Savings");
		accounts.add(acct1);
		acctService.createAccount(acct1);

		Account acct2 = new Account();
		acct2.setId(2);
		acct2.setName("Moksha");
		acct2.setBalance(45000);
		acct2.setStatus("ACTIVE");
		acct2.setType("Savings");		
		accounts.add(acct2);
		acctService.createAccount(acct2);
	}

	@AfterEach
	public void cleanup() {
        acctService.clear();      
	}

	@Test
	public void shouldCreateAccount() throws URISyntaxException, AccountException {
		// POST /Accounts
		Mockito.when(acctService.createAccount(new Account())).thenReturn("Account is created successfully");

		String reqBody = "{\"id\":\"1\",\"name\":\"Gayatri\",\"type\":\"Savings\",\"status\":\"ACTIVE\",\"balance\":\"5000\"}";

		// Step 1: Create Request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/accounts"));

		// Step 2: Send Request to Endpoint
		// Step 3: Receive the Response

		ResponseEntity<String> response = restTemp.exchange(request, String.class);

		System.out.println("Response: " + response.getBody());

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getBody()).contains("Account is created successfully");
	}

	@Test
	public void shouldCreateAnotherAccount() throws URISyntaxException, AccountException {
		// POST /products
		Mockito.when(acctService.createAccount(new Account())).thenReturn("Account is created successfully");

		String reqBody = "{\"id\":\"2\",\"name\":\"Moksha\",\"type\":\"Savings\",\"status\":\"ACTIVE\",\"balance\":\"1000\"}";

		// Step 1: Create Request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/accounts"));

		// Step 2: Send Request to Endpoint
		// Step 3: Receive the Response

		ResponseEntity<String> response = restTemp.exchange(request, String.class);

		System.out.println("Response: " + response.getBody());

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getBody()).contains("Account is created successfully");
	}

	@Test
	public void shouldReturnAllAccounts() {

		Mockito.when(acctService.getAccounts()).thenReturn(accounts);

		// REST Template
		// Step 1: Create Request
		// Step 2: Send Request to Endpoint
		// Step 3: Receive the Response
		ResponseEntity<Object> response = restTemp.getForEntity("/accounts", Object.class);

		List<Account> accounts = (List) response.getBody();

		System.out.println("Response: " + accounts);

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(accounts.size()).isEqualTo(2);

	}

	@Test
	public void shouldReturnAccountBasedonGivenId() throws AccountException, URISyntaxException {

		String reqBody = "{\"id\":\"1\",\"name\":\"preethika\",\"type\":\"Savings\",\"status\":\"ACTIVE\",\"balance\":\"6000\"}";

		ResponseEntity<Object> response = restTemp.getForEntity("/accounts/1", Object.class);
		System.out.println("Response: " + response.getBody());

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
	}

	@Test
	public void shouldUpdateAccount() throws URISyntaxException, AccountException {
		// POST /products
		// Mockito.when(acctService.updateAccount(1, new Account())).thenReturn("Account
		// is updated successfully");

		String reqBody = "{\"id\":\"1\",\"name\":\"preethika\",\"type\":\"Savings\",\"status\":\"ACTIVE\",\"balance\":\"6000\"}";

		// Step 1: Create Request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.PUT, new URI("/accounts/1"));

		// Step 2: Send Request to Endpoint
		// Step 3: Receive the Response

		ResponseEntity<String> response = restTemp.exchange(request, String.class);

		System.out.println("Response: " + response.getBody());

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getBody()).contains("Account is updated successfully");
	}

	@Test
	public void shouldDeleteAccount() throws URISyntaxException, AccountException {
		// POST /products
		String reqBody = "{\"id\":\"1\",\"name\":\"preethika\",\"type\":\"Savings\",\"status\":\"ACTIVE\",\"balance\":\"6000\"}";

		// Step 1: Create Request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.DELETE, new URI("/accounts/1"));

		// Step 2: Send Request to Endpoint
		// Step 3: Receive the Response

		ResponseEntity<String> response = restTemp.exchange(request, String.class);

		System.out.println("Response: " + response.getBody());

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getBody()).contains("Account is deleted successfully");
	}

}