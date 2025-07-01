package com.data.day6_security.service;

import com.data.day6_security.entity.Product;
import com.data.day6_security.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    ProductRepository productRepo;

    public List<Product> getAll() {
        return productRepo.findAll();
    }

}
