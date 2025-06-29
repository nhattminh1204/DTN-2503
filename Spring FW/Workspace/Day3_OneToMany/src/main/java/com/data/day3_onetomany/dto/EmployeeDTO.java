package com.data.day3_onetomany.dto;

import com.data.day3_onetomany.entity.Department;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {
    int id;
    String username;
    String fullname;
    String departmentName;
}
