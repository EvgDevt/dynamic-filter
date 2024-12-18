package com.example.dynamicquery.entity;

import com.example.dynamicquery.converter.DbColorConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldNameConstants
public class Product {

    @Id
    @UuidGenerator
    private String id;

    private String name;
    private Double price;

    @Convert(converter = DbColorConverter.class)
    private Color color;
    private String manufacturer;
    private LocalDate productionDate;
    private String country;
    private Boolean inStock;
}
