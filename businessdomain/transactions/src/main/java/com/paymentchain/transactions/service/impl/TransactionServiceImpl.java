package com.paymentchain.transactions.service.impl;

import com.paymentchain.transactions.entities.Transactions;
import com.paymentchain.transactions.respository.TransactionsRepository;
import com.paymentchain.transactions.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	
	@Autowired
	TransactionsRepository transactionsRepository;

	@Override
	public Transactions savedTransactions(Transactions transactionInput) {
		
		Transactions saved = new Transactions();
		
		if((transactionInput.getFee() != null || transactionInput.getFee().isNaN()) && transactionInput.getFee() > 0.0) {
			
			transactionInput.setAmount(transactionInput.getAmount()-transactionInput.getFee());
			
			saved = transactionsRepository.save(transactionInput);
		}
		
		return saved;
	}

	@Override
	public Transactions findByAccount(String accountNumber) {
		Transactions transaction = verifyTransactions(accountNumber);
		if(transaction != null) {
			System.out.print("Número de cuenta encontrada");			
		}else {
			System.out.print("Número de cuenta no encontrada");
		}
		return transaction;
	}
	
	private Transactions verifyTransactions(String accountNumber) {
		return transactionsRepository.findByAccountlban(accountNumber);
	}
	

}
