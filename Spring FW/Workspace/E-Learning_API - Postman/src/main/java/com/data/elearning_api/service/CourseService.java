package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.CourseCreateDTO;
import com.data.elearning_api.dto.request.CourseUpdateDTO;
import com.data.elearning_api.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course getById(int id);
    Course create(CourseCreateDTO dto);
    Course update(int id, CourseUpdateDTO dto);
    boolean delete(int id);
    List<Course> search(String keyword);
    List<Course> getByCategoryId(int categoryId);
}
