package com.lakshan.customer_service.handler;

import java.util.HashMap;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lakshan.customer_service.exception.CustomerNotFoundException;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler (CustomerNotFoundException.class)
    public ResponseEntity<String> handle(CustomerNotFoundException e) {
        return ResponseEntity
            .status(HttpStatus.SC_NOT_FOUND)
            .body(e.getMsg());

    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException e) {

        var errors = new HashMap<String, String>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            var filedName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(filedName, errorMessage);
        });

        return ResponseEntity
            .status(HttpStatus.SC_BAD_REQUEST)
            .body(new ErrorResponse(errors));

    }
}
