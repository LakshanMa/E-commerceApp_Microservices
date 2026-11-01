package com.lakshan.product_service.product.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lakshan.product_service.exception.ProductPurchaseException;
import com.lakshan.product_service.product.dto.ProductPurchaseRequest;
import com.lakshan.product_service.product.dto.ProductPurchaseResponse;
import com.lakshan.product_service.product.dto.ProductRequest;
import com.lakshan.product_service.product.dto.ProductResponse;
import com.lakshan.product_service.product.mapper.ProductMapper;
import com.lakshan.product_service.product.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Integer createProduct(ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        return productRepository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> productPurchaseRequests) {
    var productIds = productPurchaseRequests
        .stream()
        .map(ProductPurchaseRequest::productId)
        .toList();

        var storedProducts = productRepository.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exits");
        }

        var storedRequest = productPurchaseRequests
            .stream()
            .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
            .toList();
        
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for(int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var prodcutRequest = storedRequest.get(i);
            if (product.getAvailableQuantity() < prodcutRequest.quantity()) {
                throw new ProductPurchaseException("Product with id ::" + product.getId() + " does not have enough quantity");
            }
            var newAvailableQuanity = product.getAvailableQuantity() - prodcutRequest.quantity();
            product.setAvailableQuantity(newAvailableQuanity);
            productRepository.save(product);
            purchasedProducts.add(productMapper.toProductPurchaseResponse(product, prodcutRequest.quantity()));
        }
        return purchasedProducts;
    }

    public ProductResponse findById(Integer productId) {
       return productRepository.findById(productId)
        .map(productMapper::toProductResponse)
        .orElseThrow(() -> new EntityNotFoundException("Product not found with this product Id ::" + productId));
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
        .stream()
        .map(productMapper::toProductResponse)
        .collect(Collectors.toList());
    }

}
