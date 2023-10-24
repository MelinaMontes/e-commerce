package com.factorIt.ecommerce.entities;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private BigDecimal unitPrice;
}
