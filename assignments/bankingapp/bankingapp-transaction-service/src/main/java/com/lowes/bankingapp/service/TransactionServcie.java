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
		//transaction.setStatus("PEDNING");
		transRepo.save(transaction);

		String msg = transaction.getId() + "," + transaction.getFundsTransferId() + ","
				+ String.valueOf(transaction.getAmount());

		//kafkaTemplate.send("TRANSACTION_SUCESS", msg);

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

	@KafkaListener(topics = "FUNDTRANSFER_APPROVED", groupId = "transaction-service")
	public void listenTransApproval(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Approved Received: " + cr.value());
		// Logic to update order with APPROVED status
		Integer approvedOrderId = new Integer(cr.value().toString());
		Transaction order = transRepo.findById(approvedOrderId).get();
		order.setStatus("APPROVED");

		// Save Order
		transRepo.save(order);
	}

	@KafkaListener(topics = "FUNDTRANSFER_REJECTED", groupId = "transaction-service")
	public void listenTransactionRejection(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Rejected Received: " + cr.value());
		// Logic to update order with REJECTED status
		Integer rejectedOrderId = new Integer(cr.value().toString());
		Transaction transaction = transRepo.findById(rejectedOrderId).get();
		
		Transaction transNew = transaction;
		transNew.setStatus("REJECTED");
		transNew.setDescription("Refund: from transaction id reference " + rejectedOrderId);

		transRepo.save(transNew);

	}

	@KafkaListener(topics = "FUNDTRANSFER_CREATED", groupId = "transaction-service")
	public void listenTransactionCreation(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Created: " + cr.value());

		String msg = (String) cr.value();
		
		System.out.println("*******************listenTransactionCreation" + msg);
		String[] tokens = msg.split(",");
		String transactionId = tokens[0];
		String fromacctId = tokens[1];
		String toaccountId = tokens[2];
		String amount = tokens[3];
		String transType = tokens[4];
		String desc = tokens[5];
		String transId = tokens[6];

		double dAmount = Double.valueOf(amount);

		Transaction transNew = new Transaction();
		transNew.setAmount(dAmount);
		transNew.setDescription(desc);
		transNew.setAccountId(Integer.parseInt(fromacctId));
		transNew.setStatus("CREATED");
		transNew.setFundsTransferId(Integer.parseInt(toaccountId));
		transNew.setType(transType);
		transNew.setDescription(desc);

		int id = create(transNew);

		String actmsg = transNew.getId() + "," + transNew.getAccountId() + "," + transNew.getFundsTransferId() + ","
				+ String.valueOf(transNew.getAmount()) + "," + transNew.getType() + "," + transNew.getDescription()
				+ "," + transNew.getId();
		
		
		System.out.println("FUNDTRANSFER_CREATED***************************"+actmsg);

		kafkaTemplate.send("FUNDTRANSFER_PROCESSING", actmsg);

	}




}
