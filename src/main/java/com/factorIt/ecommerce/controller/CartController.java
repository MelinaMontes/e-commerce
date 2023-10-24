package com.factorIt.ecommerce.controller;

import com.factorIt.ecommerce.dtos.NewCartDTO;
import com.factorIt.ecommerce.entities.User;
import com.factorIt.ecommerce.enums.CartType;
import com.factorIt.ecommerce.services.CartService;
import com.factorIt.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @PostMapping("ecommerce/newCart")
    public ResponseEntity<String> createNewCart(@RequestParam CartType cartType, @RequestBody NewCartDTO newCartDTO) {

        User user = userService.findById(newCartDTO.getId());
        if (user == null) {
            return new ResponseEntity<>("User not found :(", HttpStatus.NOT_FOUND);
        }

        cartService.addToNewCart(newCartDTO, user, cartType);

        return new ResponseEntity<>("Cart created succesfully! ", HttpStatus.CREATED);

    }







}
