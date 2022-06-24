package com.lowes.bankingapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table
public class Transaction {
	@Id
	@GeneratedValue
	int id;
    @NotEmpty
	String type;
	String description;
	double amount;
	private int accountId;
	private int fundsTransferId;
	private String status;

	public Transaction() {

	}

	public Transaction(int id, String type, String description, double amount, int accountId, int fundsTransferId, String status) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.accountId = accountId;
		this.fundsTransferId = fundsTransferId;
		this.status=status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getFundsTransferId() {
		return fundsTransferId;
	}

	public void setFundsTransferId(int fundsTransferId) {
		this.fundsTransferId = fundsTransferId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
