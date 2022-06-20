package com.lowes.bankingapp.service;

import java.util.Collection;

import com.lowes.bankingapp.model.Account;

public interface AccountService {

	/*
	 * // POST /accounts public Account create(Account account);
	 * 
	 * // GET /accounts public List<Account> getAccounts();
	 * 
	 * // GET /accounts/{id} public Account get(int id);
	 * 
	 * // PUT /accounts/{id} public Account update(int id, Account account);
	 * 
	 * //DELETE /accounts/{id} public void delete(int id);
	 */

	public Collection<Account> getAccounts();

	public String createAccount(Account account);

	public void updateAccount(int id, Account account);

	public void deleteAccount(int id);

	public Account getAccount(int id);

	public void clear();

	
}

