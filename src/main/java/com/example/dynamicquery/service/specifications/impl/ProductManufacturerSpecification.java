package com.example.dynamicquery.service.specifications.impl;

import com.example.dynamicquery.dto.filter.SearchFilter;
import com.example.dynamicquery.entity.Product;
import com.example.dynamicquery.service.specifications.FilterSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProductManufacturerSpecification implements FilterSpecification<Product, SearchFilter> {

    @Override
    public Specification<Product> toSpecification(SearchFilter filter) {
        return (root, query, criteriaBuilder) -> {
            if (filter.manufacturer() == null || filter.manufacturer().isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(criteriaBuilder.lower(root.get(Product.Fields.manufacturer)), filter.manufacturer());
        };
    }
}