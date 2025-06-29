package com.data.day3_onetomany.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeCreateDTO {
    String username;
    String password;
    String fullname;
    int departmentId;
}
