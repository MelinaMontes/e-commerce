package com.factorIt.ecommerce.repositories;

import com.factorIt.ecommerce.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
