package com.data.elearning_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryUpdateDTO {
    @NotBlank
    @Size(min = 3, max = 100, message = "INVALID_CATEGORY_NAME")
    String name;
}