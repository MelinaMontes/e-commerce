package com.factorIt.ecommerce.ordercoasts;

import java.math.BigDecimal;
import java.util.List;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;

public class DiscountVip extends TotalCoastImpl{
  public DiscountVip(TotalCoast totalCoast){
    super(totalCoast);}


     @Override
  public BigDecimal calculateOrderCoast(List<ItemsCartDTO> allItems){
    BigDecimal vip = super.calculateOrderCoast(allItems);
      if(vip.compareTo(BigDecimal.valueOf(10000))==1){
return vip.subtract(BigDecimal.valueOf(500));      }
    
    return vip;
  }
}
