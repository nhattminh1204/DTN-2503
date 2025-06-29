package com.data.day3_onetomany.dto;

import com.data.day3_onetomany.entity.Department;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDTO {
    int id;
    String departmentName;
}
