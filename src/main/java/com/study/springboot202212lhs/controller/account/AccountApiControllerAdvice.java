package com.study.springboot202212lhs.controller.account;

import com.study.springboot202212lhs.dto.CMRespDto;
import com.study.springboot202212lhs.exception.CustomDuplicateUsernameException;
import com.study.springboot202212lhs.exception.CustomValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AccountApiControllerAdvice {

    @ExceptionHandler(CustomDuplicateUsernameException.class)
    public ResponseEntity<?> duplicateError(CustomDuplicateUsernameException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validationError(ConstraintViolationException e) {
        Map<String, String> errorMap = new HashMap<>();
        System.out.println(e.getConstraintViolations());

        e.getConstraintViolations().forEach(error -> {
            String errorProperty = error.getPropertyPath().toString();
            errorProperty = errorProperty.substring(errorProperty.lastIndexOf(".") + 1);
            errorMap.put(errorProperty, error.getMessage());
        });

        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), errorMap));
    }

    @ExceptionHandler(CustomValidException.class)
    public ResponseEntity<?> validationError(CustomValidException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

}