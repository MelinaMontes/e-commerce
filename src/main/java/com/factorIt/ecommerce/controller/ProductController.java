package com.factorIt.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factorIt.ecommerce.entities.Product;
import com.factorIt.ecommerce.services.ProductService;

@RestController
public class ProductController {
  @Autowired ProductService productService;


   @GetMapping("/product-list")
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = productService.listProducts();

        return ResponseEntity.ok().body(products);
    }
  
}
