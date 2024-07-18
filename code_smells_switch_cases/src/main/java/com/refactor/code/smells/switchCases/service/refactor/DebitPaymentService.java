package com.refactor.code.smells.switchCases.service.refactor;

import com.refactor.code.smells.switchCases.model.PaymentRequest;
import org.springframework.http.ResponseEntity;

public class DebitPaymentService implements PaymentService {
    @Override
    public ResponseEntity<?> processPayment(PaymentRequest paymentRequest) {
        return ResponseEntity.badRequest().body("Debit Payment .");
    }
}
