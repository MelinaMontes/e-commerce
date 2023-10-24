package com.factorIt.ecommerce.services;

import com.factorIt.ecommerce.entities.User;
import com.factorIt.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(int id) {
        Optional<User> userOpt = userRepository.findById(id);
        return userOpt.orElse(null);
    }
}
