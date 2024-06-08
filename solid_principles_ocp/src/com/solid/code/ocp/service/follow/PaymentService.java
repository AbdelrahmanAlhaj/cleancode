package com.solid.code.ocp.service.follow;

import com.solid.code.ocp.model.Payment;

public sealed interface PaymentService permits BitcoinPaymentService, CreditCardPaymentService, PayPalPaymentService {

    boolean supports(String paymentMethod);

    void processPayment(Payment payment);
}
