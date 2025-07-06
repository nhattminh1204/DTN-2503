package com.data.elearning_api.repository;

import com.data.elearning_api.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    boolean existsByTitle(String title);
    List<Lesson> findAllByCourseId(int courseId);
}