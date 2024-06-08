package com.solid.code.ocp.service.follow;

import com.solid.code.ocp.model.Payment;

public non-sealed class BitcoinPaymentService implements PaymentService {
    @Override
    public boolean supports(String paymentMethod) {
        return "bitcoin".equalsIgnoreCase(paymentMethod);
    }

    @Override
    public void processPayment(Payment payment) {
        System.out.print("Bitcoin payment process");
    }
}
