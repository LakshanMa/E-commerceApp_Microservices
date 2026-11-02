package com.lakshan.product_service.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lakshan.product_service.product.dto.ProductPurchaseRequest;
import com.lakshan.product_service.product.dto.ProductPurchaseResponse;
import com.lakshan.product_service.product.dto.ProductRequest;
import com.lakshan.product_service.product.dto.ProductResponse;
import com.lakshan.product_service.product.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/v1/products")
@RequiredArgsConstructor 
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(
        @RequestBody @Valid ProductRequest productRequest
    ) {

        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(
        @RequestBody List<ProductPurchaseRequest> productPurchaseRequestList
    ) {
        return ResponseEntity.ok(productService.purchaseProduct(productPurchaseRequestList));
    }

    @GetMapping ("/{product-id}")
    public ResponseEntity<ProductResponse> findById(
        @PathVariable("product-id") Integer productId
    ){
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping 
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
}
