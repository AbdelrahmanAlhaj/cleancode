package com.refactor.code.smells.dataClumps.service;

import java.math.BigDecimal;

public class EnterpriseDiscountService implements DiscountService {
    @Override
    public double calculateDiscount(BigDecimal productPrice) {
        return productPrice.subtract(new BigDecimal(20)).doubleValue();
    }
}
