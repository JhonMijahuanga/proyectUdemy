package com.paymentchain.transactions.entities;

public enum Status {
    PENDIENTE("01"),
    LIQUIDADA("02"),
    RECHAZADA("03"),
    CANCELADA("04");

    private String codigo;

    Status(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
