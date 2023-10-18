package com.shop.demo.repositoey;

import com.shop.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart,Long> {


    Optional<Cart> findByUser(Long user);

}
