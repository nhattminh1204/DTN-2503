package com.data.elearning_api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateUpdateDTO {
    @NotNull(message = "CERTIFICATE_TYPE_REQUIRED")
    String type;

    @Size(max = 255)
    String description;
}
