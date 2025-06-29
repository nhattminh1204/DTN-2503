package com.data.elearning_api.dto.request;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateCreateDTO {
    @Min(value = 1, message = "INVALID_ACCOUNT_ID")
    int accountId;

    @DecimalMin(value = "0.0", inclusive = true, message = "INVALID_SCORE")
    @DecimalMax(value = "100.0", inclusive = true, message = "INVALID_SCORE")
    double score;
}