package com.example.dynamicquery.service;

import com.example.dynamicquery.dto.filter.SearchFilter;
import com.example.dynamicquery.entity.Product;
import com.example.dynamicquery.repository.ProductRepository;
import com.example.dynamicquery.service.specifications.SpecificationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SpecificationBuilder<Product, SearchFilter> specificationBuilder;

    public Page<Product> findAll(SearchFilter filter, Pageable pageable) {
        Specification<Product> spec = buildProductSpecification(filter);

        return productRepository.findAll(spec, pageable);
    }

    private Specification<Product> buildProductSpecification(SearchFilter filter) {
        return specificationBuilder.build(filter);
    }
}
