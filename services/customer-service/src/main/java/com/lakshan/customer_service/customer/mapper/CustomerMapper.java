package com.lakshan.customer_service.customer.mapper;

import org.springframework.stereotype.Component;

import com.lakshan.customer_service.customer.dto.AddressDto;
import com.lakshan.customer_service.customer.dto.CustomerRequest;
import com.lakshan.customer_service.customer.dto.CustomerResponse;
import com.lakshan.customer_service.customer.model.Address;
import com.lakshan.customer_service.customer.model.Customer;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(toAddress(request.address()))
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerResponse(
            customer.getId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail(),
            fromAddress(customer.getAddress())
        );
    }

    public Address toAddress(AddressDto address) {
        if (address == null) {
            return null;
        }
        return Address.builder()
                .steeet(address.steeet())
                .houseNumber(address.houseNumber())
                .zipCode(address.zipCode())
                .build();
    }

    private AddressDto fromAddress(Address address) {
        if (address == null) {
            return null;
        }
        return new AddressDto(address.getSteeet(), address.getHouseNumber(), address.getZipCode());
    }
}