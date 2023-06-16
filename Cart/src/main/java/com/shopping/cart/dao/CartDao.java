package com.shopping.cart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.cart.model.Cart;
import com.shopping.cart.repository.CartRepository;



@Component
public class CartDao {

    @Autowired
    CartRepository cartRepository;

    public void addToCart(Cart cart){
    	cartRepository.save(cart);
    }

    public List<Cart> getCart(int userId){
        return cartRepository.findByUserId(userId);
    }

    public Cart getCartItem(int cartId){
        return cartRepository.findByCartId(cartId);
    }

    public void deleteItem(Cart cart) {
    	cartRepository.delete(cart);
    }

    public void deleteCart(List<Cart> items) {
    	cartRepository.deleteAll(items);
    }

    public List<Integer> getCartPrice(int userId) {
        return cartRepository.getCartPrice(userId);
    }
}