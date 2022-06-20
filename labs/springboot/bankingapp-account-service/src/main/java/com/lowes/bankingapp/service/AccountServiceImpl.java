package com.lowes.bankingapp.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.model.Account;
import com.lowes.bankingapp.repositry.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accRepo;

	public Collection<Account> getAccounts() {

		return accRepo.findAll();
	}

	public String createAccount(Account account) {
		accRepo.save(account);
		return "Account created";
	}

	public void updateAccount(int id, Account account) {

		account.setId(id);
		accRepo.save(account);
	}

	public void deleteAccount(int id) {

		System.out.println("Account: " + accRepo.findById(id).get().getId());
		accRepo.delete(accRepo.findById(id).get());
	}

	public Account getAccount(int id) {

		Optional<Account> account = accRepo.findById(id);
		return account.isPresent() ? account.get() : null;
	}

	public void clear() {

		accRepo.deleteAll();
	}

}
