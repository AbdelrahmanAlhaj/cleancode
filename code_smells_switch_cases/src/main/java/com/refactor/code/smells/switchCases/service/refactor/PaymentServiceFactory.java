package com.refactor.code.smells.switchCases.service.refactor;

import com.refactor.code.smells.switchCases.model.PaymentMethod;
import com.refactor.code.smells.switchCases.service.BitcoinPaymentService;
import com.refactor.code.smells.switchCases.service.CreditCardPaymentService;
import com.refactor.code.smells.switchCases.service.PayPalPaymentService;

public class PaymentServiceFactory {

    public static PaymentService createPaymentService(String paymentMethod) {
        PaymentMethod method = PaymentMethod.valueOf(paymentMethod);
        switch (method) {
            case CREDIT:
                return new CreditCardPaymentService();
            case PAYPAL:
                return new PayPalPaymentService();
            case BITCOIN:
                return new BitcoinPaymentService();
            case DEBIT:
                return new DebitPaymentService();
            case STRIP:
                return new StripPaymentService();
            case CACHE:
                return new CachePaymentService();
            default:
                throw new IllegalArgumentException("Invalid payment method.");
        }
    }
}

