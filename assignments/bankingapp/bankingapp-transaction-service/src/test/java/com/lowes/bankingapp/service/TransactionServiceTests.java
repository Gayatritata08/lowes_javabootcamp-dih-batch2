package com.lowes.bankingapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;

import com.lowes.bankingapp.entity.Transaction;
import com.lowes.bankingapp.repositry.TransactionRepositry;

@SpringBootTest
public class TransactionServiceTests {

	@Autowired
	TransactionServcie transService;

	@MockBean
	TransactionRepositry transRepo;

	@BeforeAll
	public static void init() {
		// Logic to initialize test data goes here
		System.out.println("Test data initialization at class level..");
	}

	@AfterAll
	public static void tearDown() {
		// Logic to clean up test data goes here
		System.out.println("Test data clean up at class level..");
	}

	private static List<Transaction> transactions = new ArrayList<>();

	HttpHeaders headers = new HttpHeaders();

	@BeforeEach
	public void setup() {
		// Initialize Test data
		Transaction trans1 = new Transaction();

		trans1.setId(1);
		trans1.setAmount(5000);
		trans1.setDescription("testing1");
		trans1.setAccountId(1);
		trans1.setFundsTransferId(2);
		trans1.setStatus("CREATED");
		trans1.setType("DEBIT");
		transactions.add(trans1);
		transService.create(trans1);

		Transaction trans2 = new Transaction();
		trans2.setId(2);
		trans2.setAmount(3000);
		trans2.setDescription("testing 2");
		trans2.setAccountId(1);
		trans2.setFundsTransferId(2);
		trans2.setStatus("CREATED");
		trans2.setType("CREDIT");
		transactions.add(trans2);
		transService.create(trans2);
	}

	@AfterEach
	public void cleanup() {
		transactions.clear();
	}

	@Test
	public void shouldCreateTransactionWhenPassingMandatoryDetails() {

		Mockito.when(transRepo.save(transactions.get(0))).thenReturn(transactions.get(0));

		assertEquals(1, transService.create(transactions.get(0)));
	}

	@Test
	public void shouldShowErrorWhenNotPassingMandatoryDetails() {
		Transaction trans = new Transaction();
		try {
			transService.create(trans);
		} catch (Exception e) {
			assertEquals("Transaction Id mandatory", e.getMessage());
		}
	}

	@Test
	public void shouldReturnTransactionForGivenAccountId() throws AccountException {
		Mockito.when(transRepo.findById(2)).thenReturn(Optional.of(transactions.get(1)));

		assertNotNull(transService.get(2));
		assertEquals(2, transService.get(2).getId());
	}

	@Test
	public void shouldReturnAlltransactionsWhenDontSpecifyAccountId() {
		Mockito.when(transRepo.findAll()).thenReturn(transactions);

		assertEquals(2, transService.list().size());
	}

//			@Test
//			public void shouldDeleteAccountWhenPassingValidAccountId() throws AccountException {
//				
//				transService.deleteAccount(transactions.get(0).getId());
//				
//				assertNull(transService.getAccount(1));
//				assertEquals(2, transService.gettransactions().size());
//			}
	//

	@Test
	public void shouldUpdateTransactionForGivenTransactionId() {

		Transaction trans1 = new Transaction();

		trans1.setId(5);
		trans1.setAmount(3000);
		trans1.setDescription("testingUpdate");
		trans1.setAccountId(1);
		trans1.setFundsTransferId(2);
		trans1.setStatus("CREATED");
		trans1.setType("DEBIT");

		transService.update(trans1);

		verify(transRepo, times(1)).save(trans1);

	}
}
