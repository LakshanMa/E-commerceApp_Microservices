package com.lakshan.product_service.product.dto;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(

    @NotNull (message = "Product Id cannot be null")
    Integer productId,
    @NotNull (message = "Quantity cannot be null")
    Integer quantity
) {

}
