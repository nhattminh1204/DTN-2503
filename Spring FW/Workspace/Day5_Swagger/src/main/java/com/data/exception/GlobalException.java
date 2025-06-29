package com.data.exception;

import com.data.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity argException(MethodArgumentNotValidException e) {
        List<ApiResponseDTO> rs = new ArrayList<>();

        for (Object object : e.getBindingResult().getAllErrors()) {
            FieldError err = (FieldError) object;
            String key = err.getDefaultMessage();

            ErrorCode errorCode = ErrorCode.valueOf(key);

            // Từ errorCode lấy ra bộ gồm code, message, status
            ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
            apiResponseDTO.setCode(errorCode.getCode());
            apiResponseDTO.setMessage(errorCode.getMessage());
            apiResponseDTO.setStatus(errorCode.getStatus());

            rs.add(apiResponseDTO);

        }


        return new ResponseEntity(rs, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity appException(AppException e) {
        ErrorCode errorCode = e.getErrorCode();

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setCode(errorCode.getCode());
        apiResponseDTO.setMessage(errorCode.getMessage());

        return new ResponseEntity<>(apiResponseDTO, errorCode.getStatus());
    }

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity argException(MethodArgumentNotValidException e) {
//        String message = e.getMessage();
//        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//    }

}
