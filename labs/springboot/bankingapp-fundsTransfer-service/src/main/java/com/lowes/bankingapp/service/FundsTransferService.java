package com.lowes.bankingapp.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.entity.FundsTransfer;
import com.lowes.bankingapp.repositry.FundsTransferRepositry;

@Service
public class FundsTransferService {
	@Autowired
	FundsTransferRepositry frepo;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	/**
	 * @param FundsTransfer
	 * @return
	 */
	public Integer add(FundsTransfer funTransObj) {
		frepo.save(funTransObj);
		return funTransObj.getTargetAccoundId();
	}

	public void update(FundsTransfer funTransObj) {
		frepo.save(funTransObj);
	}

	public FundsTransfer get(Integer id) {
		Optional<FundsTransfer> fundObj = frepo.findById(id);
		return fundObj.isPresent() ? fundObj.get() : null;
	}

	public void delete(Integer id) {
		frepo.deleteById(id);
	}

	public List<FundsTransfer> list() {
		return frepo.findAll();
	}

	public void deleteAll() {
		frepo.deleteAll();
	}

	@KafkaListener(topics = "FUNDTRANSFER_CREATED", groupId = "fundstransfer-service")
	public void listenOrderApproval(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Funds Transfer is done " + cr.value());

		String msg = (String) cr.value();
		String[] tokens = msg.split(",");
		String orderId = tokens[0];
		String customerId = tokens[1];
		String price = tokens[2];

		double dPrice = Double.valueOf(price);

		// Logic to check credit limit
		FundsTransfer fundTranObj = frepo.findById(Integer.valueOf(customerId)).get();
		double availableCreditLimit = fundTranObj.getAmount();
		if (availableCreditLimit >= dPrice) {
			fundTranObj.setAmount(availableCreditLimit - dPrice);
			System.out.println("FUNDSTRANSFER APPROVED :: " + orderId);
			frepo.save(fundTranObj);
			kafkaTemplate.send("FUNDSTRANSFER APPROVED", orderId);
		} else {
			System.out.println("FUNDSTRANSFER REJECTED :: " + orderId);
			kafkaTemplate.send("FUNDSTRANSFER_REJECTED", orderId);

		}

	}
}
