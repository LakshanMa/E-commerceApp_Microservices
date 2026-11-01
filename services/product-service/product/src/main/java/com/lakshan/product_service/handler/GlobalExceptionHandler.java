package com.lakshan.product_service.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lakshan.product_service.exception.ProductPurchaseException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler (ProductPurchaseException.class)
    public ResponseEntity<String> handle(ProductPurchaseException e) {
        return ResponseEntity
            .status(BAD_REQUEST)
            .body(e.getMessage());

    }

    @ExceptionHandler (EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException e) {
        return ResponseEntity
            .status(BAD_REQUEST)
            .body(e.getMessage());

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
            .status(BAD_REQUEST)
            .body(new ErrorResponse(errors));

    }
}
