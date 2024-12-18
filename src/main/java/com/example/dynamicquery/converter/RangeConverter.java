package com.example.dynamicquery.converter;

import com.example.dynamicquery.dto.filter.Range;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Function;


@RequiredArgsConstructor
public class RangeConverter<T extends Comparable<? super T>> implements Converter<String, Range<T>> {

    private final Function<String, T> parser;


    @Override
    public Range<T> convert(String source) {
        String[] split = source.split(":");
        if (split.length != 2) {
            throw new IllegalArgumentException("Wrong range format");
        }
        T from = parser.apply(split[0]);
        T to = parser.apply(split[1]);
        return new Range<>(from, to);
    }
}
