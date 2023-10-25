package com.factorIt.ecommerce.services;

import java.util.List;

import com.factorIt.ecommerce.entities.Order;
import com.factorIt.ecommerce.entities.User;

public interface OrderService {
  
  void makeAnOrder(User user);

  List<Order> getOrders(User user);


}
