package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.CourseCreateDTO;
import com.data.elearning_api.dto.request.CourseUpdateDTO;
import com.data.elearning_api.entity.Category;
import com.data.elearning_api.entity.Course;
import com.data.elearning_api.exception.AppException;
import com.data.elearning_api.exception.ErrorCode;
import com.data.elearning_api.repository.CategoryRepository;
import com.data.elearning_api.repository.CourseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepo;
    CategoryRepository categoryRepo;
    ModelMapper modelMapper;

    @Override
    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course getById(int id) {
        return courseRepo.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.COURSE_NOT_FOUND));
    }

    @Override
    public Course create(CourseCreateDTO dto) {
        if (courseRepo.existsByName(dto.getName())) {
            throw new AppException(ErrorCode.COURSE_NAME_EXISTS);
        }

        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));

        Course course = new Course();
        course.setName(dto.getName());
        course.setSessions(dto.getSessions());
        course.setHours(dto.getHours());
        course.setCategory(category);
        course.setLessons(new ArrayList<>());

        return courseRepo.save(course);
    }

    @Override
    public Course update(int id, CourseUpdateDTO dto) {
        Course existing = getById(id);

        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));

        existing.setName(dto.getName());
        existing.setHours(dto.getHours());
        existing.setSessions(dto.getSessions());

        existing.setCategory(category);

        return courseRepo.save(existing);
    }

    @Override
    public boolean delete(int id) {
        Course course = getById(id);

        if (!course.getLessons().isEmpty())
            throw new AppException(ErrorCode.COURSE_HAS_LESSONS);

        if (!course.getCertificates().isEmpty())
            throw new AppException(ErrorCode.COURSE_HAS_CERTIFICATES);

        courseRepo.delete(course);
        return true;
    }

    @Override
    public List<Course> search(String keyword) {
        return courseRepo.findByNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Course> getByCategoryId(int categoryId) {
        return courseRepo.findByCategoryId(categoryId);
    }
}
