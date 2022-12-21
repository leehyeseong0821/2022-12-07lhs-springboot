package com.study.springboot202212lhs.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public class CustomTestException extends  RuntimeException{
    @Getter
    private Map<String,String> errorMap;


    public CustomTestException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }
}
