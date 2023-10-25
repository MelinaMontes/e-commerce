package com.factorIt.ecommerce.ordercoasts;

import java.math.BigDecimal;
import java.util.List;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;

public class DiscountFourProducts extends TotalCoastImpl{

  public DiscountFourProducts(TotalCoast totalCoast){
    super(totalCoast);}


  @Override
  public BigDecimal calculateOrderCoast(List<ItemsCartDTO> allItems){
    BigDecimal fourProducts = BigDecimal.ZERO;
    for (ItemsCartDTO itemcart: allItems){
      if(itemcart.getQuantity()==4){
        fourProducts=fourProducts.add(itemcart.getProduct().getUnitPrice());
      }
    }
    return super.calculateOrderCoast(allItems).subtract(fourProducts);
  }
}

