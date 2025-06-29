package com.data.elearning_api.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateUpdateDTO {
    @Min(value = 1, message = "ID tài khoản không hợp lệ")
    int accountId;

    @DecimalMin(value = "0.0", inclusive = true, message = "Điểm không được nhỏ hơn 0")
    @DecimalMax(value = "100.0", inclusive = true, message = "Điểm không được lớn hơn 100")
    double score;
}
