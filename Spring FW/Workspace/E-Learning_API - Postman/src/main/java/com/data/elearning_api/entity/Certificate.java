package com.data.elearning_api.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Table(name = "certificate")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, length = 50)
    String type;

    @Column(length = 255)
    String description;

    @OneToMany(mappedBy = "certificate", fetch = FetchType.LAZY
            , cascade = CascadeType.ALL, orphanRemoval = true)
    List<Course> courses;

}
