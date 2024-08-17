package com.refactor.code.smells.dataClumps.service;

import java.math.BigDecimal;

public class FreeDiscountService implements DiscountService {
    @Override
    public double calculateDiscount(BigDecimal productPrice) {
        return productPrice.subtract(productPrice).doubleValue();
    }
}
