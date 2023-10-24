package com.factorIt.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_detail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartDetailId;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    private Product product;

    @Column(name="unit_price")
    private double unitPrice;

    private int quantity;

}
