package com.data.elearning_api.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseRes {
    Integer id;
    String name;
    int numberOfSessions;
    int durationHours;
    String description;
    int categoryId;
}
