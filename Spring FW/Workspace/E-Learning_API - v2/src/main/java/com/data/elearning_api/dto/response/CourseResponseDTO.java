package com.data.elearning_api.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseResponseDTO {
    int id;
    String name;
    int sessions;
    int hours;
    Integer categoryId;
    Integer certificateId;
}
