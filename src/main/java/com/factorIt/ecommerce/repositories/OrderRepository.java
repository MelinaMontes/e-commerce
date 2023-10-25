package com.factorIt.ecommerce.repositories;

import com.factorIt.ecommerce.entities.Order;
import com.factorIt.ecommerce.entities.User;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
  
List<Order> findByUserAndCreatedDateBetween(User user, LocalDate from, LocalDate to, Sort sort);

}
