package com.refactor.code.smells.dataClumps.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountCalculator {

    public double calculateDiscount(String role, BigDecimal productPrice) {
        return switch (role) {
            case "premium" -> new PremiumDiscountService().calculateDiscount(productPrice);
            case "free" -> new FreeDiscountService().calculateDiscount(productPrice);
            case "enterprise" -> new EnterpriseDiscountService().calculateDiscount(productPrice);
            default -> throw new IllegalArgumentException("Not valid payment method");
        };
    }


    // role [free , enterprise  , premium] calculate discount based on user role
}
