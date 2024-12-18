package com.example.dynamicquery.converter;

import com.example.dynamicquery.entity.Color;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToColorMethodArgumentConverter implements Converter<String, Color> {
    @Override
    public Color convert(String source) {
        return Color.fromString(source)
                .orElseThrow(() -> new IllegalArgumentException("Invalid color: " + source));
    }
}
