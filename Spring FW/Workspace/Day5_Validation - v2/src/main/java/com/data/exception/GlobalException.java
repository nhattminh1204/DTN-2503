package com.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity argException(MethodArgumentNotValidException e) {
        Map<String, String> rs = new HashMap<>();

        for (Object object : e.getBindingResult().getAllErrors()) {
            FieldError err = (FieldError) object;
            String property = err.getField();
            String message = err.getDefaultMessage();

            rs.put(property, message);
        }


        return new ResponseEntity(rs, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity argException(MethodArgumentNotValidException e) {
//        String message = e.getMessage();
//        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//    }

}
