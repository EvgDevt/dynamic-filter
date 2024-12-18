package com.example.dynamicquery.dto;

import java.math.BigDecimal;

public record ConvertedDto(
        String baseCurrency,
        String targetCurrency,
        BigDecimal rate,
        BigDecimal convertedAmount
) {
}
