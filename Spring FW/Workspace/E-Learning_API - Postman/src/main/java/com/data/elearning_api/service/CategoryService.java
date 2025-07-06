package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.CategoryCreateDTO;
import com.data.elearning_api.dto.request.CategoryUpdateDTO;
import com.data.elearning_api.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
    Category create(CategoryCreateDTO dto);
    Category update(int id, CategoryUpdateDTO categoryUpdateDTO);
    void delete(Integer id);
}
