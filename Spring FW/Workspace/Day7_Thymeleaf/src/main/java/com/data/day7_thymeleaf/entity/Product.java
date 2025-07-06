package com.data.day7_thymeleaf.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "product_name", unique = true, nullable = false,
            columnDefinition = "VARCHAR(100)")
    String productName;

    @Column(name = "price", nullable = false)
    long price;

    @Column(name = "description",
            columnDefinition = "TEXT")
    String description;
}
