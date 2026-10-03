package com.lakshan.customer_service.customer.dto;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email,
    AddressDto address
) {
}