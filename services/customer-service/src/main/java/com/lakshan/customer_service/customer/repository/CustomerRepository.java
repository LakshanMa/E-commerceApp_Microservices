package com.lakshan.customer_service.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lakshan.customer_service.customer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}