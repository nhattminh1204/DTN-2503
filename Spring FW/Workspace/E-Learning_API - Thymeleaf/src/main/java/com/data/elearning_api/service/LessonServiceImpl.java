package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.LessonCreateDTO;
import com.data.elearning_api.dto.request.LessonUpdateDTO;
import com.data.elearning_api.entity.Course;
import com.data.elearning_api.entity.Lesson;
import com.data.elearning_api.exception.AppException;
import com.data.elearning_api.exception.ErrorCode;
import com.data.elearning_api.repository.CourseRepository;
import com.data.elearning_api.repository.LessonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LessonServiceImpl implements LessonService {

    LessonRepository lessonRepo;
    CourseRepository courseRepo;
    ModelMapper modelMapper;

    @Override
    public Lesson create(int courseId, LessonCreateDTO dto) {
        if (lessonRepo.existsByTitle(dto.getTitle()))
            throw new AppException(ErrorCode.LESSON_TITLE_EXISTS);

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new AppException(ErrorCode.COURSE_NOT_FOUND));

        Lesson lesson = modelMapper.map(dto, Lesson.class);
        lesson.setCourse(course);

        return lessonRepo.save(lesson);
    }

    @Override
    public Lesson getById(int id) {
        return lessonRepo.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.LESSON_NOT_FOUND));
    }

    @Override
    public Lesson update(int id, LessonUpdateDTO dto) {
        Lesson lesson = getById(id);

        if (!lesson.getTitle().equals(dto.getTitle()) && lessonRepo.existsByTitle(dto.getTitle())) {
            throw new AppException(ErrorCode.LESSON_TITLE_EXISTS);
        }

        modelMapper.map(dto, lesson);
        return lessonRepo.save(lesson);
    }

    @Override
    public void delete(int id) {
        Lesson lesson = getById(id);
        lessonRepo.delete(lesson);
    }
    @Override
    public List<Lesson> getByCourseId(int courseId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new AppException(ErrorCode.COURSE_NOT_FOUND));
        return lessonRepo.findAllByCourseId(courseId);
    }

    @Override
    public List<Lesson> getAll() {
        return lessonRepo.findAll();
    }

}
