package com.refactor.code.smells.dataClumps.service;

import java.math.BigDecimal;

public interface DiscountService {

    double calculateDiscount(BigDecimal productPrice);
}
