package com.example.dynamicquery.dto;

import java.math.BigDecimal;

public record ExchangeDto(
        String baseCurrency,
        String targetCurrency,
        BigDecimal amount
) {
}
