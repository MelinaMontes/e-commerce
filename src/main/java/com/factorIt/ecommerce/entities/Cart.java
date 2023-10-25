package com.factorIt.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name="is_special")
    private boolean isSpecial;

    @Column(name="is_vip")
    private boolean isVip;

    @Column(name="is_common")
    private boolean isCommon;

    @Column(name = "is_ended")
    private boolean isEnded;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}

