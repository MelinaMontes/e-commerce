package com.factorIt.ecommerce.dtos;

import com.factorIt.ecommerce.enums.CartType;
import lombok.Data;

@Data
public class NewCartDTO {

    private int userId;
    private  int productId;
    private int quantity;

}
