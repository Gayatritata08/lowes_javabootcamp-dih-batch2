package com.lowes.bankingapp.service;

import java.util.Collection;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.model.Account;
import com.lowes.bankingapp.repositry.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accRepo;
	@Autowired

	KafkaTemplate<String, String> kafkaTemplate;

	public Collection<Account> getAccounts() {

		return accRepo.findAll();
	}

	public String createAccount(Account account) {
		accRepo.save(account);
		return "Account created";
	}

	public void updateAccount(int id, Account account) {

		account.setId(id);
		accRepo.save(account);
	}

	public void deleteAccount(int id) {

		System.out.println("Account: " + accRepo.findById(id).get().getId());
		accRepo.delete(accRepo.findById(id).get());
	}

	public Account getAccount(int id) {

		Optional<Account> account = accRepo.findById(id);
		return account.isPresent() ? account.get() : null;
	}

	public void clear() {

		accRepo.deleteAll();
	}

	@KafkaListener(topics = "FUNDTRANSFER_PROCESSING", groupId = "account-service")
	public void listenAccountApproval(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Processing: " + cr.value());

		String msg = (String) cr.value();
		String[] tokens = msg.split(",");
		String ftId = tokens[0];
		String fromacctId = tokens[1];
		String amount = tokens[3];
		String transType = tokens[4];
		String toaccountId = tokens[2];
		String desc = tokens[5];
		String transId = tokens[6];	
		
		System.out.println("************"+msg);

		double dAmount = Double.valueOf(amount);

		// Logic to check credit limit
		Account srcacct = accRepo.findById(Integer.valueOf(fromacctId)).get();

		Account dstacct = accRepo.findById(Integer.valueOf(toaccountId)).get();

		if (srcacct != null && dstacct != null) {
			if (transType.equals("DEBIT")) {
				double availableBalance = srcacct.getBalance();
				if (availableBalance >= dAmount) {
					if (dstacct.getStatus().equals("BLOCKED")) {
						System.out.println("FUNDTRANSFER REJECTED :: " + transId);
						kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
					} else {
						srcacct.setBalance(availableBalance - dAmount);
						dstacct.setBalance(dstacct.getBalance() + dAmount);
						System.out.println("FUNDTRANSFER APPROVED :: " + transId);
						accRepo.save(srcacct);
						accRepo.save(dstacct);
						kafkaTemplate.send("FUNDTRANSFER_APPROVED", transId);
					}
				} else {
					System.out.println("FUNDTRANSFER REJECTED :: " + transId);
					kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
				}
			} else if (transType.equals("CREDIT")) {
				double availableBalance = dstacct.getBalance();

				if (availableBalance >= dAmount) {
					if (srcacct.getStatus().equals("BLOCKED")) {
						System.out.println("FUNDTRANSFER REJECTED :: " + transId);
						kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
					} else {

						srcacct.setBalance(availableBalance + dAmount);
						dstacct.setBalance(dstacct.getBalance() - dAmount);
						System.out.println("FUNDTRANSFER APPROVED :: " + transId);
						accRepo.save(srcacct);
						accRepo.save(dstacct);
						kafkaTemplate.send("FUNDTRANSFER_APPROVED", transId);
					}
				} else {
					System.out.println("FUNDTRANSFER REJECTED :: " + transId);
					kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
				}
			}
		} else {
			System.out.println("FUNDTRANSFER REJECTED :: " + transId);
			kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
		}

	}
}
