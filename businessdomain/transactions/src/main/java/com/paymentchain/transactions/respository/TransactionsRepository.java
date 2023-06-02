/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.transactions.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentchain.transactions.entities.Transactions;

/**
 *
 * @author sotobotero
 */
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
	
	
	Transactions findByAccountlban(String id); 
    
}
