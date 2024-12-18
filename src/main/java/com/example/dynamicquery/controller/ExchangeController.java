package com.example.dynamicquery.controller;

import com.example.dynamicquery.dto.ConvertedDto;
import com.example.dynamicquery.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchanges")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeRateService exchangeService;

    @GetMapping
    public ConvertedDto get(@RequestParam String baseCurrency, @RequestParam String targetCurrency, @RequestParam BigDecimal amount) {
        return exchangeService.get(baseCurrency, targetCurrency, amount);
    }
}
