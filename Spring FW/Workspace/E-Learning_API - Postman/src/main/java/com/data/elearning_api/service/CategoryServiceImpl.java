package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.CategoryCreateDTO;
import com.data.elearning_api.dto.request.CategoryUpdateDTO;
import com.data.elearning_api.entity.Category;
import com.data.elearning_api.exception.AppException;
import com.data.elearning_api.exception.ErrorCode;
import com.data.elearning_api.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepo;
    ModelMapper modelMapper;

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    public Category create(CategoryCreateDTO dto) {
        if (categoryRepo.existsByName(dto.getName())) {
            throw new AppException(ErrorCode.CATEGORY_NAME_EXISTS);
        }
        Category category = modelMapper.map(dto, Category.class);
        return categoryRepo.save(category);
    }

    @Override
    public Category update(int id, CategoryUpdateDTO dto) {
        Category category = getById(id);

        if (!category.getName().equals(dto.getName()) && categoryRepo.existsByName(dto.getName())) {
            throw new AppException(ErrorCode.CATEGORY_NAME_EXISTS);
        }

        modelMapper.map(dto, category);
        return categoryRepo.save(category);
    }

    @Override
    public void delete(Integer id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));

        if (!category.getCourses().isEmpty()) {
            throw new AppException(ErrorCode.CATEGORY_HAS_COURSES);
        }

        categoryRepo.delete(category);
    }
}
