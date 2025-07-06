package com.data.elearning_api.controller.web;

import com.data.elearning_api.dto.request.CourseCreateDTO;
import com.data.elearning_api.dto.request.CourseUpdateDTO;
import com.data.elearning_api.entity.Course;
import com.data.elearning_api.service.CategoryService;
import com.data.elearning_api.service.CertificateService;
import com.data.elearning_api.service.CourseService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CourseController {

    CourseService courseService;
    CategoryService categoryService;
    CertificateService certificateService;
    ModelMapper modelMapper;

    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAll();
        model.addAttribute("courses", courses);
        return "course/course-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("courseCreateDTO", new CourseCreateDTO());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("certificates", certificateService.getAll());
        return "course/course-create";
    }

    @PostMapping("/create")
    public String processCreate(@ModelAttribute("courseCreateDTO") @Valid CourseCreateDTO dto,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("certificates", certificateService.getAll());
            return "course/course-create";
        }
        courseService.create(dto);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Course course = courseService.getById(id);
        model.addAttribute("courseUpdateDTO", modelMapper.map(course, CourseUpdateDTO.class));
        model.addAttribute("id", id);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("certificates", certificateService.getAll());
        return "course/course-edit";
    }

    @PostMapping("/edit/{id}")
    public String processEdit(@PathVariable int id,
                              @ModelAttribute("courseUpdateDTO") @Valid CourseUpdateDTO dto,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("certificates", certificateService.getAll());
            return "course/course-edit";
        }
        courseService.update(id, dto);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        courseService.delete(id);
        return "redirect:/courses";
    }
}
