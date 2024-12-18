package com.example.dynamicquery.service.specifications;

import com.example.dynamicquery.dto.filter.Range;
import com.example.dynamicquery.entity.Product;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

@UtilityClass
public class ProductSpecification {

    public Specification<Product> withPriceGreaterThan(double price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get(Product.Fields.price), price);
    }

    public Specification<Product> withPriceLessThan(double price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get(Product.Fields.price), price);
    }

    public Specification<Product> withPriceBetween(Range<Double> priceRange) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get(Product.Fields.price), priceRange.from(), priceRange.to());
    }

    public Specification<Product> withPrice(double price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Product.Fields.price), price);
    }

    public Specification<Product> withProductionDateAfter(LocalDate date) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get(Product.Fields.productionDate), date);
    }

    public Specification<Product> withProductionDateBefore(LocalDate date) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get(Product.Fields.productionDate), date);
    }

    public Specification<Product> withCountry(String country) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(criteriaBuilder.lower(root.get(Product.Fields.country)), country.toLowerCase());
    }

    public Specification<Product> inStock(Boolean inStock) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Product.Fields.inStock), inStock);
    }
}
