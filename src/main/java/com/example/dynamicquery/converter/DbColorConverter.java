package com.example.dynamicquery.converter;

import com.example.dynamicquery.entity.Color;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DbColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color attribute) {
        return attribute.getValue();
    }

    @Override
    public Color convertToEntityAttribute(String dbData) {
        return Color.fromString(dbData).orElseThrow(() -> new IllegalArgumentException("Invalid Color"));
    }
}
