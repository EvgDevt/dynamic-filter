package com.example.dynamicquery.dto.filter;

import com.example.dynamicquery.entity.Color;

import java.time.LocalDate;
import java.util.Set;

public record SearchFilter(
        String name,
        Double price,
        Range<Double> priceRange,
        Set<Color> color,
        String manufacturer,
        LocalDate productionDate,
        Range<LocalDate> dateRange,
        String country,
        Boolean inStock
) {
}