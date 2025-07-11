package com.data.elearning_api.repository;

import com.data.elearning_api.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    boolean existsByName(String name);
    List<Course> findByCategoryId(int categoryId);
    List<Course> findByNameContainingIgnoreCase(String keyword);
}