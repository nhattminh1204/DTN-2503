package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.LessonCreateDTO;
import com.data.elearning_api.dto.request.LessonUpdateDTO;
import com.data.elearning_api.dto.response.LessonResponseDTO;
import com.data.elearning_api.entity.Lesson;
import com.data.elearning_api.service.LessonService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LessonController {

    LessonService lessonService;
    ModelMapper modelMapper;

    @PostMapping("/{courseId}")
    public ResponseEntity<?> createLesson(@PathVariable int courseId,
                                          @RequestBody @Valid LessonCreateDTO dto) {
        log.info("Create lesson for course ID: {}, payload: {}", courseId, dto);
        Lesson lesson = lessonService.create(courseId, dto);
        return new ResponseEntity<>(modelMapper.map(lesson, LessonResponseDTO.class), HttpStatus.CREATED);
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<?> getLesson(@PathVariable int lessonId) {
        log.info("Get lesson by ID: {}", lessonId);
        Lesson lesson = lessonService.getById(lessonId);
        return ResponseEntity.ok(modelMapper.map(lesson, LessonResponseDTO.class));
    }

    @PutMapping("/{lessonId}")
    public ResponseEntity<?> updateLesson(@PathVariable int lessonId,
                                          @RequestBody @Valid LessonUpdateDTO dto) {
        log.info("Update lesson ID: {}, payload: {}", lessonId, dto);
        Lesson lesson = lessonService.update(lessonId, dto);
        return ResponseEntity.ok(modelMapper.map(lesson, LessonResponseDTO.class));
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<?> deleteLesson(@PathVariable int lessonId) {
        log.info("Delete lesson ID: {}", lessonId);
        lessonService.delete(lessonId);
        return ResponseEntity.ok("Xóa bài học thành công");
    }
}
