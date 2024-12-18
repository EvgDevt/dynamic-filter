package com.example.dynamicquery.config;

import com.example.dynamicquery.converter.RangeConverter;
import com.example.dynamicquery.converter.StringToColorMethodArgumentConverter;
import com.example.dynamicquery.dto.filter.Range;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final StringToColorMethodArgumentConverter webColorConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(webColorConverter);
        registry.addConverter(doubleRangeConverter());
        registry.addConverter(localDateRangeConverter());
    }

    @Bean(autowireCandidate = false)
    public Converter<String, Range<Double>> doubleRangeConverter() {
        return new RangeConverter<>(Double::valueOf);
    }

    @Bean(autowireCandidate = false)
    public Converter<String, Range<LocalDate>> localDateRangeConverter() {
        return new RangeConverter<>(LocalDate::parse);
    }
}
