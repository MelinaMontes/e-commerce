package com.factorIt.ecommerce.repositories;

import com.factorIt.ecommerce.entities.Cart;
import com.factorIt.ecommerce.entities.Product;
import com.factorIt.ecommerce.entities.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface CartRepository extends JpaRepository<Cart, Integer> {

  List<Cart> findByUserAndIsEnded(User user, boolean isEnded);


  void deleteByUserAndProductAndIsEnded(User user, Product product, boolean isEnded);

  //List<Cart>findEndedCartsByUserByCreatedDate(User user, boolean isEnded);


@Modifying
@Query("UPDATE Cart c set c.isEnded = true where c.user = :user")
  void endCart(@Param("user")User user);
}

