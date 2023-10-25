package com.factorIt.ecommerce.ordercoasts;

import java.math.BigDecimal;
import java.util.List;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;

public class DiscountSpecial extends TotalCoastImpl{

  public DiscountSpecial(TotalCoast totalCoast){
    super(totalCoast);}


  @Override
  public BigDecimal calculateOrderCoast(List<ItemsCartDTO> allItems){
    return super.calculateOrderCoast(allItems).subtract(BigDecimal.valueOf(300));
  }
}

