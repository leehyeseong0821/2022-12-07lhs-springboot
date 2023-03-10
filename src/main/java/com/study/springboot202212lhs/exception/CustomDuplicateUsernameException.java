package com.study.springboot202212lhs.exception;

import lombok.Getter;

import java.util.Map;

public class CustomDuplicateUsernameException extends RuntimeException {

    @Getter
    private Map<String, String> errorMap;

    public CustomDuplicateUsernameException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }
}
