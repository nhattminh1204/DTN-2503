package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.LessonCreateDTO;
import com.data.elearning_api.dto.request.LessonUpdateDTO;
import com.data.elearning_api.entity.Lesson;

import java.util.List;

public interface LessonService {
    Lesson create(int courseId, LessonCreateDTO dto);
    Lesson getById(int id);
    Lesson update(int id, LessonUpdateDTO dto);
    void delete(int id);
    List<Lesson> getByCourseId(int courseId);
    List<Lesson> getAll();
}
