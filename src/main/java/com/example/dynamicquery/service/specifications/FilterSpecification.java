package com.example.dynamicquery.service.specifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

public interface FilterSpecification<T, F> {

    Specification<T> toSpecification(F filter);

    @Autowired
    default void registerMyself(SpecificationRegistry<T, F> registrar) {
        registrar.register(getClass(), this);
    }
}
