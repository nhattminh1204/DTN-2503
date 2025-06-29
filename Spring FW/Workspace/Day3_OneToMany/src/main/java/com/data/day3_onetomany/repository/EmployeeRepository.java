package com.data.day3_onetomany.repository;

import com.data.day3_onetomany.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByPassword(String password);

    List<Employee> findByUsernameAndPassword(String username,
                                             String password);

    List<Employee> findByUsernameOrPassword(String username,
                                            String password);
}
