package com.factorIt.ecommerce.services;

import com.factorIt.ecommerce.dtos.NewCartDTO;
import com.factorIt.ecommerce.entities.Product;
import com.factorIt.ecommerce.entities.User;
import com.factorIt.ecommerce.enums.CartType;

public interface CartService {

    public void addToNewCart(NewCartDTO newCartDTO, User user, CartType cartType);

    public void deleteFromCart(User user, Product product);


}
