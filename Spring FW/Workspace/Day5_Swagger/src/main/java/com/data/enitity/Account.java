package com.data.enitity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Entity
@Table(name = "Account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "username", unique = true, nullable = false
    , columnDefinition = "VARCHAR(50)")
    String username;

    @Column(name = "email", nullable = true
    , columnDefinition = "VARCHAR(100)")
    String email;

    @Column(name = "quantity", nullable = false)
    int quantity;

    @Column(name = "birthday")
    Date birthday;
}
