/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.transactions.controller;

import com.paymentchain.transactions.entities.Transactions;
import com.paymentchain.transactions.respository.TransactionsRepository;
import com.paymentchain.transactions.service.TransactionService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

/**
 *
 * @author jmijahua
 */
@RestController
@RequestMapping("/transactions")
public class TransactionsRestController {
        
	@Autowired
	private TransactionService transactionService;
    
    @Autowired
    private TransactionsRepository transactionsRepository;
    
    @GetMapping()
    public List<Transactions> list() {
        return transactionsRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Transactions get(@PathVariable long id) {
        return transactionsRepository.findById(id).get();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Transactions input) {
      Transactions find = transactionsRepository.findById(id).get();   
        if(find != null){     
            //find.setCode(input.getCode());
            //find.setNameTransaction(input.getNameTransaction());
        }
        Transactions save = transactionsRepository.save(find);
        return ResponseEntity.ok(save);
    }
    
    @PostMapping
    public ResponseEntity<Transactions> post(@RequestBody Transactions input) {
    	
        return new ResponseEntity<>(transactionService.savedTransactions(input), HttpStatus.OK);
    
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {  
        Optional<Transactions> findById = transactionsRepository.findById(id);   
        if(findById.get() != null){               
                  transactionsRepository.delete(findById.get());  
        }
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/byNumber/{accountNumber}")
    public ResponseEntity<Transactions> getTransactionByNumber(@PathVariable String accountNumber) {
    	
        return new ResponseEntity<>(transactionService.findByAccount(accountNumber),HttpStatus.OK);
        
    }
    
}
