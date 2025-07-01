package com.data.day6_security.entity;


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
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "product", unique = true, nullable = false
            ,columnDefinition = "VARCHAR(50)")
    String productName;

    @Column(name = "price", nullable = true
            , columnDefinition = "INT UNSIGNED")
    int price;
}
