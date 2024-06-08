package com.solid.code.ocp.model;

public class Payment {
    private String paymentMethod;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Payment setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }
}
