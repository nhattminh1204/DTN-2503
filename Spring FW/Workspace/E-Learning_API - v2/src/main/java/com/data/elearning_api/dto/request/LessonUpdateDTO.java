package com.data.elearning_api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonUpdateDTO {

    @NotBlank
    @Size(min = 3, max = 200)
    String title;

    String description;

    @Min(0)
    int duration;
}
