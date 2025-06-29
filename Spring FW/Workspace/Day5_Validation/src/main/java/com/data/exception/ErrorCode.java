package com.data.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    INVALID_USERNAME_LENGTH(1003, "Username length: 5 - 20", HttpStatus.BAD_REQUEST),
    INVALID_QUANTITY(1005, "Quantity value: 0 - 100", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1004, "Email is incorrect format", HttpStatus.BAD_REQUEST),
    USER_EXISTS(1006, "User already exists", HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus status;

    ErrorCode(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
