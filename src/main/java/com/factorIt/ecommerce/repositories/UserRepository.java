package com.factorIt.ecommerce.repositories;

import com.factorIt.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override

    Optional<User> findById(Integer integer);
}
