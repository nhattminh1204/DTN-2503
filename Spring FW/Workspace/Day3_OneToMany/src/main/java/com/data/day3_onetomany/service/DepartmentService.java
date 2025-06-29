package com.data.day3_onetomany.service;

import com.data.day3_onetomany.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();
    List<Department> getByDepartmentName(String departmentName);
}
