package com.data.day2_exercise.controller;

import com.data.day2_exercise.dto.DepartmentCreateDTO;
import com.data.day2_exercise.dto.DepartmentUpdateDTO;
import com.data.day2_exercise.entity.Department;
import com.data.day2_exercise.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public ResponseEntity<?> gettAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getDepartmentById(@RequestParam Integer id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if(department == null){
            return new ResponseEntity<>("Department(" + id + ") không tồn tại!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departmentRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentCreateDTO departmentCreateDTO){
        Department department = new Department();
        department.setDepartmentName(departmentCreateDTO.getDepartmentName());
        department.setDescription(departmentCreateDTO.getDescription());
        department.setPhone(departmentCreateDTO.getPhone());

        departmentRepository.save(department);
        return new ResponseEntity<>("Create success: " + department, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateDepartment(@RequestBody DepartmentUpdateDTO departmentUpdateDTO){
        Department department = new Department();
        department.setId(departmentUpdateDTO.getId());
        department.setDepartmentName(departmentUpdateDTO.getDepartmentName());
        department.setDescription(departmentUpdateDTO.getDescription());
        department.setPhone(departmentUpdateDTO.getPhone());

        departmentRepository.save(department);
        return new ResponseEntity<>("Update success: " + department, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteDepartment(@RequestParam Integer id){
        Department department = departmentRepository.findById(id).orElse(null);
        if(department == null){
            return new ResponseEntity<>("Phòng ban với Id: '" + id + "' không tồn tại!", HttpStatus.BAD_REQUEST);
        }

        departmentRepository.delete(department);
        return new ResponseEntity<>("Delete success: " + department, HttpStatus.OK);
    }
}
