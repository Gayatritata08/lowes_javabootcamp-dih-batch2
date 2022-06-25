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

import com.lowes.bankingapp.entity.FundsTransfer;
import com.lowes.bankingapp.repositry.FundsTransferRepositry;

@SpringBootTest
public class FundTransferServiceTests {

	@Autowired
	FundsTransferService ftService;

	@MockBean
	FundsTransferRepositry ftRepo;

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

	private static List<FundsTransfer> transactions = new ArrayList<>();

	HttpHeaders headers = new HttpHeaders();

	@BeforeEach
	public void setup() {
		// Initialize Test data
		FundsTransfer trans1 = new FundsTransfer();

		trans1.setId(1);
		trans1.setAmount(5000.00);
		trans1.setDescription("testing1");
		trans1.setSourceAccountId(1);
		trans1.setTargetAccoundId(2);
		trans1.setStatus("CREATED");
		trans1.setType("DEBIT");
		transactions.add(trans1);
		ftService.create(trans1);

		FundsTransfer trans2 = new FundsTransfer();
		trans2.setId(2);
		trans2.setAmount(3000.00);
		trans2.setDescription("testing 2");
		trans2.setSourceAccountId(1);
		trans2.setTargetAccoundId(2);
		trans2.setStatus("CREATED");
		trans2.setType("CREDIT");
		transactions.add(trans2);
		ftService.create(trans2);
	}

	@AfterEach
	public void cleanup() {
		transactions.clear();
	}

	@Test
	public void shouldCreateFundTransferWhenPassingMandatoryDetails() {

		Mockito.when(ftRepo.save(transactions.get(0))).thenReturn(transactions.get(0));

		assertEquals(1, ftService.create(transactions.get(0)));
	}

	@Test
	public void shouldShowErrorWhenNotPassingMandatoryDetails() {
		FundsTransfer trans = new FundsTransfer();
		try {
			ftService.create(trans);
		} catch (Exception e) {
			assertEquals("Transaction Id mandatory", e.getMessage());
		}
	}

	@Test
	public void shouldReturnFundTransferForGivenAccountId() throws AccountException {
		Mockito.when(ftRepo.findById(2)).thenReturn(Optional.of(transactions.get(1)));

		assertNotNull(ftService.get(2));
		assertEquals(2, ftService.get(2).getId());
	}

	@Test
	public void shouldReturnAllFundTransfersWhenDontSpecifyFundTransferId() {
		Mockito.when(ftRepo.findAll()).thenReturn(transactions);

		assertEquals(2, ftService.list().size());
	}

//		@Test
//		public void shouldDeleteAccountWhenPassingValidAccountId() throws AccountException {
//			
//			ftService.deleteAccount(transactions.get(0).getId());
//			
//			assertNull(ftService.getAccount(1));
//			assertEquals(2, ftService.gettransactions().size());
//		}
	//

	@Test
	public void shouldUpdateFundTransferForGivenFundTransferId() {

		FundsTransfer trans1 = new FundsTransfer();

		trans1.setId(5);
		trans1.setAmount(3000.00);
		trans1.setDescription("testingUpdate");
		trans1.setSourceAccountId(1);
		trans1.setTargetAccoundId(2);
		trans1.setStatus("CREATED");
		trans1.setType("DEBIT");

		ftService.update(trans1);

		verify(ftRepo, times(1)).save(trans1);

	}

}
