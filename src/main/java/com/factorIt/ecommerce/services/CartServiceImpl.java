package com.factorIt.ecommerce.services;

import com.factorIt.ecommerce.dtos.NewCartDTO;
import com.factorIt.ecommerce.entities.Cart;
import com.factorIt.ecommerce.entities.Product;
import com.factorIt.ecommerce.entities.User;
import com.factorIt.ecommerce.enums.CartType;
import com.factorIt.ecommerce.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    ProductService productService;
    @Autowired
    CartRepository cartRepository;

    @Override
    public void addToNewCart(NewCartDTO newCartDTO, User user, CartType cartType) {

        Product product= productService.findProductById(newCartDTO.getProductId());
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setCreatedDate(LocalDate.now());
        cart.setEnded(false);
        cart.setQuantity(newCartDTO.getQuantity());
        //cart.setCartType(cartType);
        cartRepository.save(cart);

    }

    @Override
    public void deleteFromCart(User user, Product product) {

    }
}
