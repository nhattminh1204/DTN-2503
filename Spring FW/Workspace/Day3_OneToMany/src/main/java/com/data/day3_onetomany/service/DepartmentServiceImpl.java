package com.data.day3_onetomany.service;

import com.data.day3_onetomany.entity.Department;
import com.data.day3_onetomany.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepo;

    public DepartmentServiceImpl(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    @Override
    public List<Department> getByDepartmentName(String departmentName) {
        return departmentRepo.findByDepartmentName(departmentName);
    }
}
