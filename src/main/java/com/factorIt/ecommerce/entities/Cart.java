package com.factorIt.ecommerce.entities;

import com.factorIt.ecommerce.enums.CartType;
import com.factorIt.ecommerce.enums.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Integer cartId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="cart_type")
    private CartType cartType;

    @Column(name="is_ended")
    private boolean isEnded;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;

}
