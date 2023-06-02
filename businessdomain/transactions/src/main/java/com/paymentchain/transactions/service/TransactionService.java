package com.paymentchain.transactions.service;

import com.paymentchain.transactions.entities.Transactions;

public interface TransactionService {
	
	Transactions savedTransactions(Transactions transactionInput);
	
	Transactions findByAccount(String accountNumber);

}
