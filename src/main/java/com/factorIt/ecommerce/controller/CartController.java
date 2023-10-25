package com.factorIt.ecommerce.controller;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;
import com.factorIt.ecommerce.dtos.NewCartDTO;
import com.factorIt.ecommerce.entities.*;
import com.factorIt.ecommerce.models.GenericResponse;
import com.factorIt.ecommerce.repositories.OrderDetailRepository;
import com.factorIt.ecommerce.repositories.OrderRepository;
import com.factorIt.ecommerce.services.CartService;
import com.factorIt.ecommerce.services.ProductService;
import com.factorIt.ecommerce.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @PostMapping("/new-cart")
    public ResponseEntity<GenericResponse> createNewCart(
            @RequestParam int userId,
         
            @RequestBody NewCartDTO newCartDTO) {

        User user = userService.findById(userId);
        cartService.addToNewCart(newCartDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponse(true, "Your cart is created!"));
    }

    // ver items del carrito
    @GetMapping("/cart-items")
    public ResponseEntity<List<ItemsCartDTO>> getItemsFromCart(@RequestParam("userId") int userId) {

        User user = userService.findById(userId);
        List<ItemsCartDTO> cartItems = cartService.getItemsFromUser(user);

        return ResponseEntity.ok(cartItems);

    }

    // eliminar del carrito
    @DeleteMapping("/{productId}/delete")
    public ResponseEntity<GenericResponse> deleteItemFromCart(@RequestParam("userId") int userId,
            @PathVariable("productId") Integer productId) {

        User user = userService.findById(userId);
        Product product = productService.findProductById(productId);
        cartService.deleteFromCart(user, product);

        return ResponseEntity.ok(new GenericResponse(true, "The product has been deleted from your cart! "));

    }
}
