package com.refactor.code.smells.dataClumps.service;

import java.math.BigDecimal;

public class PremiumDiscountService implements DiscountService {
    @Override
    public double calculateDiscount(BigDecimal productPrice) {
        return productPrice.subtract(BigDecimal.TEN).doubleValue();
    }
}
