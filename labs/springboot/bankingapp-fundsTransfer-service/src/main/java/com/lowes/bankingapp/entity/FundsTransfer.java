package com.lowes.bankingapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FundsTransfer {

	@Id
	@GeneratedValue
	private Integer id;
	private int sourceAccountId;
	private int targetAccoundId;
	private double amount;
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(int sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public int getTargetAccoundId() {
		return targetAccoundId;
	}

	public void setTargetAccoundId(int targetAccoundId) {
		this.targetAccoundId = targetAccoundId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
