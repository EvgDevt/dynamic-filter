package com.example.dynamicquery.dto.filter;

public record Range<T extends Comparable<? super T>>(T from, T to) {
}
