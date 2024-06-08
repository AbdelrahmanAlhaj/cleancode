package com.solid.code.ocp.service.follow;

import com.solid.code.ocp.model.Payment;

import java.util.List;

public class PaymentProcessor {
    private List<PaymentService> paymentServices;

    public PaymentProcessor(List<PaymentService> services) {
        this.paymentServices = paymentServices;
    }

    public PaymentProcessor() {

    }

    public void processPayment(Payment payment) {
        for (PaymentService service : paymentServices) {
            if (service.supports(payment.getPaymentMethod())) {
                service.processPayment(payment);
            }
        }
    }

    public void processPaymentByType(Payment payment) {
        String paymentType = payment.getPaymentMethod();
        PaymentService paymentService;
        if ("bitcoin".equalsIgnoreCase(paymentType)) {
            paymentService = new BitcoinPaymentService();
        } else if ("paypal".equalsIgnoreCase(paymentType)) {
            paymentService = new PayPalPaymentService();
        } else if ("creditcard".equalsIgnoreCase(paymentType)) {
            paymentService = new CreditCardPaymentService();
        } else {
            throw new IllegalArgumentException("Not valid payment method");
        }
        paymentService.processPayment(payment);
    }

}
