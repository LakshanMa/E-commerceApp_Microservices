package com.lakshan.customer_service.customer;


public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email,
    Address address
) {

}
