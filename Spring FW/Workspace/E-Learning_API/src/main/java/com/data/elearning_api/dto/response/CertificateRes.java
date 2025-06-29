package com.data.elearning_api.dto.response;

import com.data.elearning_api.entity.Account;
import com.data.elearning_api.entity.Course;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateRes {
    int id;
    String type;
    double score;
    LocalDate issueDate;
    int accountId;
    int courseId;
}
