package com.data.elearning_api.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class AccountCreateDTO {
    private String username;
    private String password;
    private String email;
    private Date dateOfBirth;
    private String address;
}
