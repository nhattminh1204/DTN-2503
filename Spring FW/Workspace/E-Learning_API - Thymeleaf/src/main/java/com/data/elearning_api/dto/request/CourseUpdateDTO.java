package com.data.elearning_api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseUpdateDTO {
    @NotBlank(message = "INVALID_COURSE_NAME")
    @Size(min = 2, max = 100, message = "INVALID_COURSE_NAME")
    String name;

    @Size(max = 1000, message = "DESCRIPTION_TOO_LONG")
    String description;

    @Min(value = 0, message = "INVALID_SESSION_COUNT")
    int sessions = 0;

    @Min(value = 0, message = "INVALID_HOUR_COUNT")
    int hours = 0;

    Integer categoryId;

    Integer certificateId;
}
