package com.data.elearning_api.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true, nullable = false)
    String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY
            , cascade = CascadeType.ALL)
    List<Course> courses;
}
