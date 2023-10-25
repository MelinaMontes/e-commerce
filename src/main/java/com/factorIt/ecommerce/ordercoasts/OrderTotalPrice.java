package com.factorIt.ecommerce.ordercoasts;

import java.math.BigDecimal;
import java.util.List;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;

public class OrderTotalPrice implements TotalCoast{

  @Override
  public BigDecimal calculateOrderCoast(List<ItemsCartDTO> totalItemsCart) {
      return totalItemsCart.stream()
      .map(item -> item.getProduct().getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
      .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
  
  
}
