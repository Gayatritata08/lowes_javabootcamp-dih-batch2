package com.labs.exception;

class InSuffucientFunException extends Exception {
	public InSuffucientFunException() {
		System.out.println("Insufficient amount requested");
	}

	public InSuffucientFunException(String message) {
		System.out.println(message);
	}
}

class BankAccount {
	private int balance = 0;
	private int accountNumber;

	public BankAccount(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void deposit(int amount) {
		balance += amount;
		System.out.println("amount credited: " + amount);
	}

	public void withdraw(int amount) throws InSuffucientFunException {
		if (amount <= balance) {
			balance -= amount;
			System.out.println("amount debited: " + amount);
		} else {
			throw new InSuffucientFunException("sorry you dont have sufficient balance");
		}
	}

	public int getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
}

public class ExceptionDemo {
	public static void main(String[] args) {
		BankAccount account = new BankAccount(123456);
		System.out.println(account.getBalance());
		account.deposit(5000);
		try {
			account.withdraw(2000);
		} catch (InSuffucientFunException e) {
			e.printStackTrace();
		}
		account.deposit(1000);
		try {
			account.withdraw(10000);
		} catch (InSuffucientFunException e) {
			e.printStackTrace();
		}
	}
}
