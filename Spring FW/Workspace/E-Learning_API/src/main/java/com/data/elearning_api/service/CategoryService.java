package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.CategoryUpdateDTO;
import com.data.elearning_api.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> gettAll();
    Category getById(Integer id);
    void create(Category category);
    Category update(int id, CategoryUpdateDTO categoryUpdateDTO);
    boolean delete(Integer id);
}
