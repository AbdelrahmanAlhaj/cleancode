package com.refactor.code.smells.switchCases.service.refactor;

import com.refactor.code.smells.switchCases.model.PaymentRequest;
import org.springframework.http.ResponseEntity;

public class StripPaymentService implements PaymentService {
    @Override
    public ResponseEntity<?> processPayment(PaymentRequest paymentRequest) {
        return ResponseEntity.badRequest().body("Strip Payment .");
    }
}
