package com.factorIt.ecommerce.ordercoasts;

public class OrderCoast {
  public static TotalCoast getAmountTotal( boolean VIP , int allItems, boolean promotions){
    TotalCoast totalCoast = new OrderTotalPrice();

  
          if (VIP) {
              totalCoast = new DiscountVip(totalCoast);
          }
  
          if (promotions) {
              totalCoast = new DiscountFourProducts(totalCoast);
          }
  
          return totalCoast;
      }
  }
  