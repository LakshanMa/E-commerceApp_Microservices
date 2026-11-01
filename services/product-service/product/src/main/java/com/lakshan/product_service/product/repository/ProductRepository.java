package com.lakshan.product_service.product.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lakshan.product_service.product.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

   List<Product> findAllByIdInOrderById(List<Integer> productIds);

}
