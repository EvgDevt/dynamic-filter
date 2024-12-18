package com.example.dynamicquery.service.specifications;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class SpecificationRegistry<T, F> {

    private final Map<Class<?>, FilterSpecification<T, F>> specifications = new HashMap<>();

    public void register(Class<?> filterClass, FilterSpecification<T, F> specification) {
        specifications.put(filterClass, specification);
    }

    public FilterSpecification<T, F> getSpecification(Class<?> filterClass) {
        return specifications.get(filterClass);
    }

    public Collection<FilterSpecification<T, F>> getSpecifications() {
        return Collections.unmodifiableCollection(specifications.values());
    }
}
