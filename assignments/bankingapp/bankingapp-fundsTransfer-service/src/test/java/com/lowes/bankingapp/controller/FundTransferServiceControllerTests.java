package com.lowes.bankingapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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

import com.lowes.bankingapp.entity.FundsTransfer;
import com.lowes.bankingapp.service.FundsTransferService;

// API Test / Integration test
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FundTransferServiceControllerTests {

	@Autowired
	TestRestTemplate restTemp;

	@MockBean
	@Autowired
	FundsTransferService ftService;

	private static List<FundsTransfer> fts = new ArrayList<>();

	HttpHeaders headers = new HttpHeaders();

	@BeforeEach
	public void setup() {
		// Initialize Test data
		FundsTransfer ft1 = new FundsTransfer();

		ft1.setId(1);
		ft1.setAmount(5000.00);
		ft1.setDescription("fundtransfer1");
		ft1.setSourceAccountId(1);
		ft1.setTargetAccoundId(2);
		ft1.setStatus("CREATED");
		ft1.setType("DEBIT");
		fts.add(ft1);
		ftService.create(ft1);

		FundsTransfer ft2 = new FundsTransfer();
		ft2.setId(2);
		ft2.setAmount(3000.00);
		ft2.setDescription("fundtransfer2");
		ft2.setSourceAccountId(2);
		ft2.setTargetAccoundId(3);
		ft2.setStatus("CREATED");
		ft2.setType("DEBIT");
		fts.add(ft2);
		ftService.create(ft2);
	}

	@AfterEach
	public void cleanup() {
		// ftService.clear();
		fts.clear();
	}

	@Test
	public void shouldCreateTransaction() throws URISyntaxException {
		// POST /products
		Mockito.when(ftService.create(new FundsTransfer())).thenReturn(1);

		String reqBody = "{\"id\":\"1\",\"amount\":\"3000.00\",\"type\":\"DEBIT\",\"status\":\"CREATED\",\"sourceaccountid\":\"2\",\"destinationaccountid\":\"3\"}";

		// Step 1: Create Request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/fundtransfers"));

		// Step 2: Send Request to Endpoint
		// Step 3: Receive the Response

		ResponseEntity<String> response = restTemp.exchange(request, String.class);

		System.out.println("Response: " + response.getBody());

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getBody()).contains("Fund Transfer Created");
	}

	@Test
	public void shouldReturnAllTransactions() {

		Mockito.when(ftService.list()).thenReturn(fts);

		ResponseEntity<Object> response = restTemp.getForEntity("/fundtransfers", Object.class);

		List<FundsTransfer> transactions = (List) response.getBody();

		System.out.println("Response: " + transactions);

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(transactions.size()).isEqualTo(2);

	}

	@Test
	public void shouldReturnTransactionBasedonGivenId() throws URISyntaxException {

		String reqBody = "{\"id\":\"1\",\"amount\":\"3000.00\",\"type\":\"DEBIT\",\"status\":\"CREATED\",\"sourceaccountid\":\"2\",\"destinationaccountid\":\"3\"}";

		ResponseEntity<Object> response = restTemp.getForEntity("/fundtransfers/1", Object.class);
		System.out.println("Response: " + response.getBody());

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
	}

	@Test
	public void shouldUpdateTransaction() throws URISyntaxException {
		// POST /products
		// Mockito.when(acctService.updateTransaction(1, new
		// FundTransfer())).thenReturn("FundTransfer is updated successfully");
		String reqBody = "{\"id\":\"1\",\"amount\":\"3000.00\",\"type\":\"DEBIT\",\"status\":\"CREATED\",\"sourceaccountid\":\"2\",\"destinationaccountid\":\"3\"}";

		// Step 1: Create Request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.PUT, new URI("/fundtransfers/1"));

		// Step 2: Send Request to Endpoint
		// Step 3: Receive the Response

		ResponseEntity<String> response = restTemp.exchange(request, String.class);

		System.out.println("Response: " + response.getBody());

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getBody()).contains("Fund Transfer Updated");
	}

	@Test
	public void shouldDeleteTransaction() throws URISyntaxException {
		// POST /products
		String reqBody = "{\"id\":\"1\",\"amount\":\"3000.00\",\"type\":\"DEBIT\",\"status\":\"CREATED\",\"sourceaccountid\":\"2\",\"destinationaccountid\":\"3\"}";

		// Step 1: Create Request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.DELETE, new URI("/fundtransfers/1"));

		// Step 2: Send Request to Endpoint
		// Step 3: Receive the Response

		ResponseEntity<String> response = restTemp.exchange(request, String.class);

		System.out.println("Response: " + response.getBody());

		// Step 4: Validate the Response
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getBody()).contains("Fund Transfer Deleted");
	}

}
