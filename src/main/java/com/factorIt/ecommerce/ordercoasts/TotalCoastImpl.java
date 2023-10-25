package com.factorIt.ecommerce.ordercoasts;

import java.math.BigDecimal;
import java.util.List;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;

public class TotalCoastImpl implements TotalCoast{
  private TotalCoast totalCoast;
  public TotalCoastImpl(TotalCoast totalCoast){
    this.totalCoast=totalCoast;
  }

  @Override
  public BigDecimal calculateOrderCoast(List<ItemsCartDTO> totalItemsCart) {
   return  totalCoast.calculateOrderCoast(totalItemsCart);
  
  }
  
}
