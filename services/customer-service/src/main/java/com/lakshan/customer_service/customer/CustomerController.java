package com.lakshan.customer_service.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/v1/customers")
@RequiredArgsConstructor 
public class CustomerController {

    private final CustomerService customerService;
    
    public ResponseEntity<String> createCustomer (
        @RequestBody @Valid CustomerRequest request
    ){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
}
