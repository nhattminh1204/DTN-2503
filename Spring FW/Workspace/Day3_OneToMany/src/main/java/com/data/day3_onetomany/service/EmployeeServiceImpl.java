package com.data.day3_onetomany.service;

import com.data.day3_onetomany.entity.Employee;
import com.data.day3_onetomany.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepo;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public boolean create(Employee employee) {
        employeeRepo.save(employee);
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }
}
