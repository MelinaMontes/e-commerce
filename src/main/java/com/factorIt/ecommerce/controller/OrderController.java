package com.factorIt.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.factorIt.ecommerce.entities.Order;
import com.factorIt.ecommerce.entities.User;
import com.factorIt.ecommerce.models.GenericResponse;
import com.factorIt.ecommerce.services.OrderService;
import com.factorIt.ecommerce.services.UserService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
   @Autowired
    private UserService userService;


    @PostMapping("/make-order")
    public ResponseEntity<GenericResponse> placeOrder(@RequestParam("userId")int userId) {
      User user = userService.findById(userId);
      orderService.makeAnOrder(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponse(true,"is ready!"));

    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(
            @RequestParam("userId") int userId) {
      User user = userService.findById(userId);
      List<Order> orders = orderService.getOrders(user);
            return ResponseEntity.ok(orders);
    }
  }
