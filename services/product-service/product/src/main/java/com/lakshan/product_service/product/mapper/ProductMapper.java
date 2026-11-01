package com.lakshan.product_service.product.mapper;

import org.springframework.stereotype.Component;

import com.lakshan.product_service.product.dto.ProductPurchaseResponse;
import com.lakshan.product_service.product.dto.ProductRequest;
import com.lakshan.product_service.product.dto.ProductResponse;
import com.lakshan.product_service.product.model.Category;
import com.lakshan.product_service.product.model.Product;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
            .id(productRequest.id())
            .name(productRequest.name())
            .description(productRequest.description())
            .availableQuantity(productRequest.availableQuantity())
            .price(productRequest.price())
            .category(
                Category.builder()
                    .id(productRequest.categoryId())
                    .build()
            )
            .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getAvailableQuantity(),
            product.getPrice(),
            product.getCategory().getId(),
            product.getCategory().getName(),
            product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, Integer quantity) {
        return new ProductPurchaseResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            quantity
        );
    }
}
