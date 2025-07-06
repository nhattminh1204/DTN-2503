package com.data.elearning_api.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonResponseDTO {
    int id;
    String title;
    String description;
    int duration;
    int courseId;
}
