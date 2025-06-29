package com.data.elearning_api.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class AccountResponseDTO {
    private String username;
    private String email;
    private Date dateOfBirth;
    private String address;
}
