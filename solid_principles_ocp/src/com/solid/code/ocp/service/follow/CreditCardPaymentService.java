package com.solid.code.ocp.service.follow;

import com.solid.code.ocp.model.Payment;

public non-sealed class CreditCardPaymentService implements PaymentService {
    @Override
    public boolean supports(String paymentMethod) {
        return "creditcard".equalsIgnoreCase(paymentMethod);
    }

    @Override
    public void processPayment(Payment payment) {
        System.out.print("Credit card payment process");
    }
}
