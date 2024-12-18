package com.example.dynamicquery.service.specifications.impl;

import com.example.dynamicquery.dto.filter.SearchFilter;
import com.example.dynamicquery.entity.Product;
import com.example.dynamicquery.service.specifications.FilterSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProductColorSpecification implements FilterSpecification<Product, SearchFilter> {

    @Override
    public Specification<Product> toSpecification(SearchFilter filter) {
        return (root, query, criteriaBuilder) -> {
            if (filter.color() == null || filter.color().isEmpty()) {
                return criteriaBuilder.conjunction();
            }

            return root.get(Product.Fields.color).in(filter.color());
        };
    }
}