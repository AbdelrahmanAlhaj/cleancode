package com.solid.code.ocp.service.follow;

import com.solid.code.ocp.model.Payment;

public non-sealed class PayPalPaymentService implements PaymentService {
    @Override
    public boolean supports(String paymentMethod) {
        return "paypal".equalsIgnoreCase(paymentMethod);
    }

    @Override
    public void processPayment(Payment payment) {
        System.out.print("PayPal payment process");
    }
}
