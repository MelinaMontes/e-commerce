package com.factorIt.ecommerce.repositories;

import com.factorIt.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByProductId(Integer productId);

}
