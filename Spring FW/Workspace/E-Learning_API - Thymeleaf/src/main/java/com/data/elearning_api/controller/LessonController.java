package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.LessonCreateDTO;
import com.data.elearning_api.dto.request.LessonUpdateDTO;
import com.data.elearning_api.entity.Course;
import com.data.elearning_api.entity.Lesson;
import com.data.elearning_api.service.CourseService;
import com.data.elearning_api.service.LessonService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LessonController {

    LessonService lessonService;
    CourseService courseService; // 👈 Thêm dòng này
    ModelMapper modelMapper;

    @GetMapping
    public String listAllLessons(Model model) {
        List<Lesson> lessons = lessonService.getAll();
        model.addAttribute("lessons", lessons);
        return "lesson/lesson-list";
    }

    @GetMapping("/course/{courseId}")
    public String getLessonsByCourse(@PathVariable int courseId, Model model) {
        List<Lesson> lessons = lessonService.getByCourseId(courseId);
        model.addAttribute("lessons", modelMapper.map(lessons, new TypeToken<List<Lesson>>() {}.getType()));
        model.addAttribute("courseId", courseId);
        return "lesson/lesson-list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("lessonCreateDTO", new LessonCreateDTO());
        model.addAttribute("courses", courseService.getAll()); // 👈 Lấy danh sách khoá học
        return "lesson/lesson-create";
    }

    @PostMapping("/create")
    public String processCreate(@ModelAttribute("lessonCreateDTO") @Valid LessonCreateDTO dto,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", courseService.getAll());
            return "lesson/lesson-create";
        }
        lessonService.create(dto.getCourseId(), dto);
        return "redirect:/lessons/course/" + dto.getCourseId();
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Lesson lesson = lessonService.getById(id);
        model.addAttribute("lessonUpdateDTO", modelMapper.map(lesson, LessonUpdateDTO.class));
        model.addAttribute("id", id);
        return "lesson/lesson-edit";
    }

    @PostMapping("/edit/{id}")
    public String processEdit(@PathVariable int id,
                              @ModelAttribute("lessonUpdateDTO") @Valid LessonUpdateDTO dto,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "lesson/lesson-edit";
        }
        lessonService.update(id, dto);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        lessonService.delete(id);
        return "redirect:/courses";
    }
}
