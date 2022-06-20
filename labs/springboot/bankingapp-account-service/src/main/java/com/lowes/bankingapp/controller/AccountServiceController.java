package com.lowes.bankingapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lowes.bankingapp.exception.AccountException;
import com.lowes.bankingapp.model.Account;
import com.lowes.bankingapp.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountServiceController {

	Logger logger = LoggerFactory.getLogger(AccountServiceController.class);

	@Autowired
	AccountService accService;

	// Create Employee
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Transactional
	public ResponseEntity<ResponseMessage> create(@Valid @RequestBody Account account)
			throws URISyntaxException, AccountException {

		String accCreated = accService.createAccount(account);
		if (accCreated != null) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(account.getId()).toUri();
			ResponseMessage response = new ResponseMessage("Success", "Account Created Successfully");
			return ResponseEntity.created(location).body(response);
		} else
			logger.error("Error in creating account data");
		throw new AccountException("Error in creating account data");

	}

	// List Employees
	@GetMapping
	public Collection<Account> getAll() throws AccountException {

		return accService.getAccounts();
	}

	// Get Employee
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Account get(@PathVariable int id) throws AccountException {

		return accService.getAccount(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessage> update(@PathVariable("id") int id, @RequestBody Account account)
			throws AccountException {

		accService.updateAccount(id, account);
		ResponseMessage response = new ResponseMessage("Success", "Account Updated Successfully");

		return ResponseEntity.created(null).body(response);
	}

	// Delete Employee
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> delete(@PathVariable int id) throws AccountException {

		if (accService.getAccount(id) != null) {
			accService.deleteAccount(id);
			ResponseMessage response = new ResponseMessage("Success", "Account Deleted Successfully");
			return ResponseEntity.created(null).body(response);
		} else {
			logger.error("Account not found for id :: " + id + " Delete has not happened");
			return ResponseEntity.notFound().build();

		}

	}
}
