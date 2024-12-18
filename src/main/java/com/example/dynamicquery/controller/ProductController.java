package com.example.dynamicquery.controller;

import com.example.dynamicquery.dto.filter.SearchFilter;
import com.example.dynamicquery.entity.Product;
import com.example.dynamicquery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public Page<Product> getProducts(SearchFilter filter, Pageable pageable) {
        return productService.findAll(filter, pageable);
    }
}
