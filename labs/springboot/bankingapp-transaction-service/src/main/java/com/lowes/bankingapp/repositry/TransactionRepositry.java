package com.lowes.bankingapp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lowes.bankingapp.entity.Transaction;

public interface TransactionRepositry extends JpaRepository<Transaction, Integer> {

}
