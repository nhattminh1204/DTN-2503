package com.data.day2_exercise.dto;

import lombok.Data;

@Data
public class DepartmentUpdateDTO {
    private int id;

    private String departmentName;

    private String description;

    private String phone;
}
