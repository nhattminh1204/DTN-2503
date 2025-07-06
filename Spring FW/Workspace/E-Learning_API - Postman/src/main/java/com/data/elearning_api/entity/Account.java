package com.data.elearning_api.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, length = 50)
    String username;

    @Column(nullable = false, length = 100)
    String password;

    @Column(nullable = false, unique = true)
    String email;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    ROLE role;

    String address;

    @Column(name = "date_of_birth")
    LocalDate dateOfBirth;

    @Column(name = "create_at", nullable = false, updatable = false)
    LocalDateTime createAt;

    @Column(name = "update_at", nullable = false)
    LocalDateTime updateAt;

    @PrePersist
    private void onCreate() {
        this.createAt = this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        this.updateAt = LocalDateTime.now();
    }
}
