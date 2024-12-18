package com.example.dynamicquery.service.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SpecificationBuilder<T, F> {

    private final SpecificationRegistry<T, F> registrar;


    public Specification<T> build(F filter) {
        return registrar.getSpecifications().stream()
                .map(fSpec -> fSpec.toSpecification(filter))
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElseThrow(() -> new UnsupportedOperationException("No specification found"));
    }
}
