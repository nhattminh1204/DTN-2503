package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.CourseCreateDTO;
import com.data.elearning_api.dto.request.CourseUpdateDTO;
import com.data.elearning_api.dto.response.CourseResponseDTO;
import com.data.elearning_api.entity.Course;
import com.data.elearning_api.service.CourseService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CourseController {

    CourseService courseService;
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        log.info("Get all courses");
        List<Course> courses = courseService.getAll();
        Type listType = new TypeToken<List<CourseResponseDTO>>() {}.getType();
        return ResponseEntity.ok(modelMapper.map(courses, listType));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        log.info("Get course by ID: {}", id);
        Course course = courseService.getById(id);
        return ResponseEntity.ok(modelMapper.map(course, CourseResponseDTO.class));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CourseCreateDTO dto) {
        log.info("Create course with payload: {}", dto);
        Course created = courseService.create(dto);
        return new ResponseEntity<>(modelMapper.map(created, CourseResponseDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @Valid @RequestBody CourseUpdateDTO dto) {
        log.info("Update course ID: {}, payload: {}", id, dto);
        Course updated = courseService.update(id, dto);
        return ResponseEntity.ok(modelMapper.map(updated, CourseResponseDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        log.info("Delete course ID: {}", id);
        courseService.delete(id);
        return ResponseEntity.ok("Xoá thành công");
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String q) {
        log.info("Search course by keyword: '{}'", q);
        List<Course> courses = courseService.search(q);
        Type listType = new TypeToken<List<CourseResponseDTO>>() {}.getType();
        return ResponseEntity.ok(modelMapper.map(courses, listType));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getByCategoryId(@PathVariable int id) {
        log.info("Get courses by category ID: {}", id);
        List<Course> courses = courseService.getByCategoryId(id);
        Type listType = new TypeToken<List<CourseResponseDTO>>() {}.getType();
        return ResponseEntity.ok(modelMapper.map(courses, listType));
    }

}
