package com.data.day7_thymeleaf.service;

import com.data.day7_thymeleaf.entity.Product;
import com.data.day7_thymeleaf.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepo;

    @Override
    public List<Product> getAll() {
        List<Product> products = productRepo.findAll();

        return products;
    }
}