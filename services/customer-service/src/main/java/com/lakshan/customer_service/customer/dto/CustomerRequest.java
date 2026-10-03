package com.lakshan.customer_service.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
    String id,
    @NotNull(message = "firstName cannot be null")
    String firstName,
    @NotNull(message = "lastName cannot be null")
    String lastName,
    @NotNull(message = "email cannot be null")
    @Email(message = "email should be valid")
    String email,
    AddressDto address
) {
}