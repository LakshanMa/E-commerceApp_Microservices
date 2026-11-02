package com.lakshan.product_service.product.dto;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
    Integer id,
    String name,
    String description,
    BigDecimal price,
    Integer quantity
) {


}
