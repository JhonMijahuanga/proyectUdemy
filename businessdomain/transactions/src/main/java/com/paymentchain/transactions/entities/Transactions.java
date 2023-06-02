/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.transactions.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 *
 * @author jmijahua
 */
@Entity
@Data
public class Transactions {
   @Id
   @JsonIgnore
   @GeneratedValue(strategy=GenerationType.AUTO)
   private long id;
   private String reference;
   private String accountlban;
   private Double amount;
   private Double fee;
   private String description;
   @Enumerated(EnumType.STRING)
   private Status status;
   @Enumerated(EnumType.STRING)
   private Channel channel;
   private Date date;
   
}
