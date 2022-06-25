package com.lowes.bankingapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;

import com.lowes.bankingapp.exception.AccountException;
import com.lowes.bankingapp.model.Account;
import com.lowes.bankingapp.repositry.AccountRepository;

public class AccountServiceTests {
	@Autowired
	AccountService accountService;

	@MockBean
	AccountRepository acctRepo;

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

	private static List<Account> accounts = new ArrayList<Account>();

	@BeforeEach
	public void setup() throws AccountException {
		// Initialize Test data
		Account acct1 = new Account();

		acct1.setId(1);
		acct1.setName("Gayatri");
		acct1.setBalance(50000);
		acct1.setStatus("ACTIVE");
		acct1.setType("Savings");
		accounts.add(acct1);
		accountService.createAccount(acct1);

		Account acct2 = new Account();
		acct2.setId(2);
		acct2.setName("Preethika");
		acct2.setBalance(45000);
		acct2.setStatus("ACTIVE");
		acct2.setType("Savings");
		// acct2.setOpenDate(LocalDate.now());
		accounts.add(acct2);

		Account acct3 = new Account();
		acct2.setId(3);
		acct2.setName("Sam");
		acct2.setBalance(5000);
		acct2.setStatus("ACTIVE");
		acct2.setType("Savings");
		// acct2.setOpenDate(LocalDate.now());
		accounts.add(acct3);
	}

	@AfterEach
	public void cleanup() {
		accountService.clear();
		accounts.clear();
	}

	/*
	 * @Test
	 * 
	 * @Order(3) public void shouldCreateAccountWhenPassingMandatoryDetails() throws
	 * AccountException {
	 * 
	 * Mockito.when(acctRepo.save(accounts.get(0))).thenReturn(accounts.get(0));
	 * 
	 * assertEquals("Account created",
	 * accountService.createAccount(accounts.get(0))); }
	 * 
	 * @Test
	 * 
	 * @Order(4) public void shouldShowErrorWhenNotPassingMandatoryDetails() {
	 * Account product = new Account(); try { accountService.createAccount(product);
	 * } catch (Exception e) { assertEquals("Account Id mandatory", e.getMessage());
	 * } }
	 * 
	 * @Test
	 * 
	 * @Order(2) public void shouldReturnAccountForGivenAccountId() throws
	 * AccountException {
	 * Mockito.when(acctRepo.findById(3)).thenReturn(Optional.of(accounts.get(1)));
	 * 
	 * assertNotNull(accountService.getAccount(3)); assertEquals(3,
	 * accountService.getAccount(3).getId()); }
	 */
	@Test
	@Order(1)
	public void shouldReturnAllAccountsWhenDontSpecifyAccountId() {
		Mockito.when(acctRepo.findAll()).thenReturn(accounts);

		assertEquals(3, accountService.getAccounts().size());
	}
	/*
	 * @Test
	 * 
	 * @Order(5) public void shouldUpdateAccountForGivenAccountId() throws
	 * AccountException { Account act = new Account(); act.setName("Sam");
	 * act.setType("Savings"); act.setStatus("ACTIVE");
	 * accountService.updateAccount(1, act);
	 * 
	 * verify(acctRepo, times(1)).save(act);
	 * 
	 * }
	 */
}
