package com.factorIt.ecommerce.services;

import java.util.List;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;
import com.factorIt.ecommerce.dtos.NewCartDTO;
import com.factorIt.ecommerce.entities.Product;
import com.factorIt.ecommerce.entities.User;

public interface CartService {


    public void deleteFromCart(User user, Product product);

    List<ItemsCartDTO> getItemsFromUser(User user);

    public void addToNewCart(NewCartDTO newCartDTO, User user);


    void finishCarrt(User user);




}
