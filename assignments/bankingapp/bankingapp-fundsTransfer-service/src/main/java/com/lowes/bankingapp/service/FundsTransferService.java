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
//	private static final Logger logger = LoggerFactory.getLogger(FundsTransferService.class);
	@Autowired
	FundsTransferRepositry frepo;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	String transactionId;

	/**
	 * @param FundsTransfer
	 * @return
	 */
	/*
	 * public Integer add(FundsTransfer funTransObj) { frepo.save(funTransObj);
	 * return funTransObj.getTargetAccoundId(); }
	 */

	public Integer create(FundsTransfer ft) {

		ft.setStatus("PENDING");
		ft.toString();

		frepo.save(ft);
		int transId = 0;

		String msg = ft.getId() + "," + ft.getSourceAccountId() + "," + ft.getTargetAccoundId() + ","
				+ String.valueOf(ft.getAmount()) + "," + ft.getType() + "," + ft.getDescription() + "," + transId;

		kafkaTemplate.send("FUNDTRANSFER_CREATED", msg);

		return ft.getId();
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

	@KafkaListener(topics = "FUNDTRANSFER_APPROVED", groupId = "fundtransfer-service")
	public void listenOrderApproval(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Fund Transfer Approved Received: " + cr.value());
		// Logic to update order with APPROVED status
		Integer approvedOrderId = new Integer(cr.value().toString());
		FundsTransfer ftobj = frepo.findById(approvedOrderId).get();
		ftobj.setStatus("APPROVED");

		// Save Order
		frepo.save(ftobj);
	}

	@KafkaListener(topics = "FUNDTRANSFER_REJECTED", groupId = "fundtransfer-service")
	public void listenOrderRejection(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Fund Transfer Rejected Received: " + cr.value());
		// Logic to update order with REJECTED status
		Integer rejectedOrderId = new Integer(cr.value().toString());
		FundsTransfer ftobj = frepo.findById(rejectedOrderId).get();
		ftobj.setStatus("REJECTED");

		// Save Order
		frepo.save(ftobj);
	}

}
