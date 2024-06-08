package com.solid.code.ocp;

import com.solid.code.ocp.model.Payment;
import com.solid.code.ocp.service.follow.PaymentProcessor;
import com.solid.code.ocp.service.follow.PaymentService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Payment payment = new Payment();
        payment.setPaymentMethod("creditcard");
        paymentProcessor.processPaymentByType(payment);

    }
}
