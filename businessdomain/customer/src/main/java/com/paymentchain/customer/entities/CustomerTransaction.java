package com.paymentchain.customer.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class CustomerTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Transient
	private String transactionName;
	
	@JsonIgnore//it is necesary for avoid infinite recursion
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Customer.class)
    @JoinColumn(name = "TransactionsId", nullable = true)   
    private Customer customer;

}
