package com.shop.demo.repositoey;

import com.shop.demo.model.AuthenticationToken;
import com.shop.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken,Integer> {

    AuthenticationToken findByUser(User user);
}
