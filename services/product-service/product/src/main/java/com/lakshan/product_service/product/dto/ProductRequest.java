package com.lakshan.product_service.product.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record ProductRequest(
    @NotNull (message = "Product Id is required")
    Integer id,
    @NotNull (message = "Product Name is required")
    String name,
    @NotNull (message = "Product Description is required")
    String description,
    @Positive (message = "Available quantity should be positive")
    double availableQuantity,
    @Positive (message = "Available quantity should be positive")
    BigDecimal price,
    @NotNull (message = "Category Id is required")
    Integer categoryId
) {

}
