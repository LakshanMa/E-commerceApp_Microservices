package com.lakshan.product_service.product;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
@Builder 
@Entity 
public class category {

    @Id 
    @GeneratedValue 
    private Integer id;
    private String name;
    private String description;
    @OneToMany (mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<product> products;

}
