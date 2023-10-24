package com.factorIt.ecommerce.dtos;

import com.factorIt.ecommerce.enums.CartType;
import lombok.Data;

@Data
public class NewCartDTO {

    private int id;
    private  int productId;

}
