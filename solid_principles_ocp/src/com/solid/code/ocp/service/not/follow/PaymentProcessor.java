package com.solid.code.ocp.service.not.follow;

import com.solid.code.ocp.model.Payment;

public class PaymentProcessor {

    public void processPayment(Payment payment) {
        String paymentMethod = payment.getPaymentMethod();
        if ("creditcard".equalsIgnoreCase(paymentMethod)) {
            CreditCardPaymentService creditCardPaymentService = new CreditCardPaymentService();
            creditCardPaymentService.processCreditCardPayment();
        } else if ("paypal".equalsIgnoreCase(paymentMethod)) {
            PayPalPaymentService paypalPaymentService = new PayPalPaymentService();
            paypalPaymentService.processPayPalPayment();
        } else if ("bitcoin".equalsIgnoreCase(paymentMethod)) {
            BitcointPaymentService bitcointPaymentService = new BitcointPaymentService();
            bitcointPaymentService.processPayPalPayment();
        } else {
            throw new IllegalArgumentException("Invalid payment method");
        }
    }
}
