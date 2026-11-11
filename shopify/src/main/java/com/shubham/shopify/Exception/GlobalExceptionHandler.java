package com.shubham.shopify.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
        
    @ExceptionHandler
    public ResponseEntity<String> handelRuntimeException(RuntimeException ex){
        return null;         
    }
}
