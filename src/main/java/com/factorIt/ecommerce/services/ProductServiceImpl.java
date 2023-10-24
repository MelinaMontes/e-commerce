package com.factorIt.ecommerce.services;

import com.factorIt.ecommerce.entities.Product;
import com.factorIt.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product findProductById(int productId) {
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findByProductId(productId));

        return productOptional.orElse(null);
    }
}
