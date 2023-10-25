package com.factorIt.ecommerce.ordercoasts;

import java.math.BigDecimal;
import java.util.List;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;

public interface TotalCoast { 
  BigDecimal calculateOrderCoast(List<ItemsCartDTO>totalItemsCart);
}
