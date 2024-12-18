package com.example.dynamicquery.entity;

import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum Color {

    SILVER("Silver"),
    BLACK("Black"),
    NAVY_BLUE("Navy Blue"),
    GRAPHITE("Graphite"),
    SPACE_GRAY("Space Gray"),
    WHITE("White"),
    CHARCOAL("Charcoal");

    private final String value;

    private static final Map<String, Color> stringToEnum = Stream.of(values())
            .collect(Collectors.toMap(Color::getValue, e -> e));

    Color(String value) {
        this.value = value;
    }

    public static Optional<Color> fromString(String source) {
        return Optional.ofNullable(stringToEnum.get(source));
    }
}
