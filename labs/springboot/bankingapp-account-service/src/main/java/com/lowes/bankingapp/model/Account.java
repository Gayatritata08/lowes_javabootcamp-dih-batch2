package com.lowes.bankingapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Account {
	@Id
	@GeneratedValue
	int id;
	@NotEmpty
	String name;
	@NotEmpty
	String type;
	
	String status;
	double balance;

	public Account() {

	}

	public Account(int id, String name, String type, String status, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
		this.balance = balance;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
