package com.factorIt.ecommerce.services;

import com.factorIt.ecommerce.entities.Product;
import com.factorIt.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product findProductById(int productId) {
      Optional<Product> product=productRepository.findById(productId);
      if(product.isEmpty()){
        throw new EntityNotFoundException();
      }
      return product.get();
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
}
