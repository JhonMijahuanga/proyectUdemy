package com.paymentchain.transactions.entities;

public enum Channel {
    WEB("WEB"),
    CAJERO("CAJERO"),
    OFICINA("OFICINA");

    private String value;

    Channel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
