package com.data.elearning_api.dto.request;

import com.data.elearning_api.entity.CertificateType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateUpdateDTO {
    @NotNull(message = "CERTIFICATE_TYPE_REQUIRED")
    CertificateType type;

    @Size(max = 255)
    String description;
}
