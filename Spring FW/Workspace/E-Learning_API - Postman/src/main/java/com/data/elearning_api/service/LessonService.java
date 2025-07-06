package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.LessonCreateDTO;
import com.data.elearning_api.dto.request.LessonUpdateDTO;
import com.data.elearning_api.entity.Lesson;

public interface LessonService {
    Lesson create(int courseId, LessonCreateDTO dto);
    Lesson getById(int id);
    Lesson update(int id, LessonUpdateDTO dto);
    void delete(int id);
}
