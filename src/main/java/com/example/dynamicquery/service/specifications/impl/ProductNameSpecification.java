package com.example.dynamicquery.service.specifications.impl;

import com.example.dynamicquery.dto.filter.SearchFilter;
import com.example.dynamicquery.entity.Product;
import com.example.dynamicquery.service.specifications.FilterSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProductNameSpecification implements FilterSpecification<Product, SearchFilter> {

    @Override
    public Specification<Product> toSpecification(SearchFilter filter) {
        if (filter.name() == null || filter.name().isEmpty()) {
            return null;
        }
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(Product.Fields.name)), "%" + filter.name().toLowerCase() + "%");
    }
}