package com.factorIt.ecommerce.dtos;

import com.factorIt.ecommerce.entities.Cart;
import com.factorIt.ecommerce.entities.Product;

import lombok.Data;

@Data
public class ItemsCartDTO {

    private Integer cartId;
    private Product product;
    private int quantity;


     public ItemsCartDTO(Cart cart) {
        this.setCartId(cart.getCartId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());    
    }
}
