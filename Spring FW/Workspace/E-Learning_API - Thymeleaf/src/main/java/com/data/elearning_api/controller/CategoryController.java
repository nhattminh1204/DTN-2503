package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.CategoryCreateDTO;
import com.data.elearning_api.dto.request.CategoryUpdateDTO;
import com.data.elearning_api.entity.Category;
import com.data.elearning_api.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {

    CategoryService categoryService;
    ModelMapper modelMapper;

    @GetMapping("/list")
    public String list(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "category/category-list"; // đã cập nhật
    }

    @GetMapping("/create-form")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new CategoryCreateDTO());
        model.addAttribute("title", "Thêm Thể Loại");
        model.addAttribute("action", "/categories/create");
        return "category/category-form"; // đã cập nhật
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") @Valid CategoryCreateDTO dto,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Thêm Thể Loại");
            model.addAttribute("action", "/categories/create");
            return "category/category-form";
        }

        categoryService.create(dto);
        return "redirect:/categories/list";
    }

    @GetMapping("/update-form/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Category category = categoryService.getById(id);
        CategoryUpdateDTO dto = modelMapper.map(category, CategoryUpdateDTO.class);
        model.addAttribute("category", dto);
        model.addAttribute("title", "Cập Nhật Thể Loại");
        model.addAttribute("action", "/categories/update/" + id);
        return "category/category-form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id,
                         @ModelAttribute("category") @Valid CategoryUpdateDTO dto,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Cập Nhật Thể Loại");
            model.addAttribute("action", "/categories/update/" + id);
            return "category/category-form";
        }

        categoryService.update(id, dto);
        return "redirect:/categories/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        categoryService.delete(id);
        return "redirect:/categories/list";
    }
}
