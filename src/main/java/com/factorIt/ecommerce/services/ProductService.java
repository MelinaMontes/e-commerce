package com.factorIt.ecommerce.services;

import java.util.List;

import com.factorIt.ecommerce.entities.Product;

public interface ProductService {

  Product findProductById(int productId);

  List<Product> listProducts();

}
