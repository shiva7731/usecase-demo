package com.shopping.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.cart.model.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserId(int userId);

    Cart findByCartId(int cartId);

    @Query("SELECT c.totalProductPrice FROM Cart c WHERE c.userId = ?1")
    List<Integer> getCartPrice(int userId);
}
