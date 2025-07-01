package com.data.day6_security.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;


    @Column(name = "username", unique = true, nullable = false
            , columnDefinition = "VARCHAR(100)")
    String username;

    @Column(name = "password", nullable = false
            , columnDefinition = "VARCHAR(100)")
    String password;

    @Column(name = "fullName", nullable = false
            , columnDefinition = "VARCHAR(100)")
    String fullName;

    @Column(name = "email", unique = true, nullable = false
            , columnDefinition = "VARCHAR(100)")
    String email;
}
