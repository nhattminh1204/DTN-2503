package com.data.day3_onetomany.service;

import com.data.day3_onetomany.entity.Employee;

import java.util.List;

public interface EmployeeService {
    boolean create(Employee employee);
    List<Employee> getAll();
}
