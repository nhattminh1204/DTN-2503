package com.data.elearning_api.dto.response;

import com.data.elearning_api.entity.CertificateType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateResponseDTO {
    int id;
    CertificateType type;
}
