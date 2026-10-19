package com.lakshan.product_service.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
@Entity 
@Builder 
public class product {
    
    @Id
    @GeneratedValue 
    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    @ManyToOne 
    @JoinColumn (name = "category_id")
    private category category;

}
