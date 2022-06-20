package com.lowes.bankingapp.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.entity.Transaction;
import com.lowes.bankingapp.repositry.TransactionRepositry;

@Service
public class TransactionServcie {
	@Autowired
	TransactionRepositry transRepo;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public Integer create(Transaction transaction) {
		transaction.setStatus("PEDNING");
		transRepo.save(transaction);

		String msg = transaction.getId() + "," + transaction.getFundsTransferId() + ","
				+ String.valueOf(transaction.getAmount());

		kafkaTemplate.send("TRANSACTION_SUCESS", msg);

		return transaction.getId();
	}

	public void update(Transaction transaction) {
		transRepo.save(transaction);
	}

	public Transaction get(Integer id) {
		Optional<Transaction> trans = transRepo.findById(id);
		return trans.isPresent() ? trans.get() : null;
	}

	public void delete(Integer trasId) {
		transRepo.deleteById(trasId);
	}

	public List<Transaction> list() {
		return transRepo.findAll();
	}

	public void deleteAll() {
		transRepo.deleteAll();
	}

	@KafkaListener(topics = "TRANSACTION_SUCCESS", groupId = "transaction-service")
	public void listenTransactionApproval(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Order Approved Received: " + cr.value());
		// Logic to update order with APPROVED status
		Integer approvedOrderId = new Integer(cr.value().toString());
		Transaction transaction = transRepo.findById(approvedOrderId).get();
		transaction.setStatus("SUCCESS");

		// Save Order
		transRepo.save(transaction);
	}

	@KafkaListener(topics = "TRANSACTION_REJECTED", groupId = "transaction-service")
	public void listenTransactionRejection(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Order Rejected Received: " + cr.value());
		// Logic to update order with REJECTED status
		Integer rejectedOrderId = new Integer(cr.value().toString());
		Transaction transaction = transRepo.findById(rejectedOrderId).get();
		transaction.setStatus("REJECTED");

		// Save Order
		transRepo.save(transaction);
	}
}
