package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.CategoryCreateDTO;
import com.data.elearning_api.dto.response.CategoryResponseDTO;
import com.data.elearning_api.dto.request.CategoryUpdateDTO;
import com.data.elearning_api.entity.Category;
import com.data.elearning_api.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/categories")
public class CategoryController {
    CategoryService categoryService;
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        log.info("Get All Categories");
        List<Category> categories = categoryService.getAll();
        Type listType = new TypeToken<List<CategoryResponseDTO>>() {}.getType();
        List<CategoryResponseDTO> categoryResponseDTOS = modelMapper.map(categories, listType);
        return new ResponseEntity<>(categoryResponseDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        log.info("Get Category By Id: {}", id);
        Category category = categoryService.getById(id);
        CategoryResponseDTO categoryResponseDTO = modelMapper.map(category, CategoryResponseDTO.class);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CategoryCreateDTO dto) {
        log.info("Create Category: {}", dto);
        Category created = categoryService.create(dto);
        CategoryResponseDTO categoryResponseDTO = modelMapper.map(created, CategoryResponseDTO.class);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id
            , @Valid @RequestBody CategoryUpdateDTO dto) {
        log.info("Update Category id: {}, payload: {}", id, dto);
        Category category = categoryService.update(id, dto);
        CategoryResponseDTO responseDTO = modelMapper.map(category, CategoryResponseDTO.class);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        log.info("Delete Category id: {}", id);
        categoryService.delete(id);
        return new ResponseEntity<>("Xóa thể loại thành công", HttpStatus.OK);
    }


}