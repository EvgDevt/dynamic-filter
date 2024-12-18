package com.example.dynamicquery.service;

import com.example.dynamicquery.dto.ConvertedDto;
import com.example.dynamicquery.entity.ExchangeRate;
import com.example.dynamicquery.exception.ExchangeNotFoundException;
import com.example.dynamicquery.repository.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private static final String CROSS_CURRENCY = "USD";
    private static final int SCALE = 6;

    private final ExchangeRepository exchangeRepository;


    public ConvertedDto get(String baseCurrency, String targetCurrency, BigDecimal amount) {
        if (baseCurrency.equalsIgnoreCase(targetCurrency)) {
            return buildConvertedDto(baseCurrency, targetCurrency, amount, amount);
        }

        BigDecimal exchangeRate = determineExchangeRate(baseCurrency, targetCurrency);
        BigDecimal total = calculateTotalAmount(amount, exchangeRate);

        return buildConvertedDto(baseCurrency, targetCurrency, amount, total);
    }

    private BigDecimal determineExchangeRate(String baseCurrency, String targetCurrency) {
        return getDirectRate(baseCurrency, targetCurrency)
                .or(() -> getReversedRate(baseCurrency, targetCurrency))
                .or(() -> getCrossCurrencyRate(baseCurrency, targetCurrency))
                .orElseThrow(() -> new ExchangeNotFoundException("No exchange rate found"));
    }

    private Optional<BigDecimal> getDirectRate(String baseCurrency, String targetCurrency) {
        return fetchExchangeRate(baseCurrency, targetCurrency).map(ExchangeRate::getRate);
    }

    private Optional<BigDecimal> getReversedRate(String baseCurrency, String targetCurrency) {
        return fetchExchangeRate(targetCurrency, baseCurrency).map(this::calculateReversedRate);
    }

    private Optional<BigDecimal> getCrossCurrencyRate(String baseCurrency, String targetCurrency) {
        return fetchExchangeRate(CROSS_CURRENCY, baseCurrency)
                .flatMap(baseToCross -> fetchExchangeRate(CROSS_CURRENCY, targetCurrency)
                        .map(targetToCross -> {
                            BigDecimal baseRate = baseToCross.getRate();
                            return targetToCross.getRate()
                                    .divide(baseRate, SCALE, RoundingMode.HALF_UP);
                        })
                );
    }

    private Optional<ExchangeRate> fetchExchangeRate(String baseCurrency, String targetCurrency) {
        return exchangeRepository.findByCodes(baseCurrency, targetCurrency);
    }

    private BigDecimal calculateReversedRate(ExchangeRate rate) {
        return BigDecimal.ONE.divide(rate.getRate(), SCALE, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalAmount(BigDecimal amount, BigDecimal exchangeRate) {
        return amount.multiply(exchangeRate);
    }

    private ConvertedDto buildConvertedDto(String baseCurrency, String targetCurrency, BigDecimal amount, BigDecimal converted) {
        return new ConvertedDto(baseCurrency, targetCurrency, amount, converted);
    }
}