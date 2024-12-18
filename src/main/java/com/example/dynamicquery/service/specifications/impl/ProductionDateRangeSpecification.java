package com.example.dynamicquery.service.specifications.impl;

import com.example.dynamicquery.dto.filter.SearchFilter;
import com.example.dynamicquery.entity.Product;
import com.example.dynamicquery.service.specifications.FilterSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProductionDateRangeSpecification implements FilterSpecification<Product, SearchFilter> {

    @Override
    public Specification<Product> toSpecification(SearchFilter filter) {
        return (root, query, criteriaBuilder) -> {
            if (filter.dateRange() == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.between(root.get(Product.Fields.productionDate), filter.dateRange().from(), filter.dateRange().to());
        };
    }
}
