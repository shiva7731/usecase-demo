package com.shopping.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.exception.CartServiceException;
import com.shopping.cart.model.Cart;
import com.shopping.cart.model.Payment;
import com.shopping.cart.repository.PaymentRepository;
import com.shopping.cart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    
    @Autowired
    PaymentRepository paymentService;

    @GetMapping("/getCart/{userId}")
    public ResponseEntity getCart(@PathVariable int userId){
        List<Cart> cart = cartService.getCart(userId);
        return new ResponseEntity(cart, HttpStatus.OK);
    }

    @PostMapping("/addItem")
    public ResponseEntity addToCart(@RequestBody Cart cart){
        cartService.addToCart(cart);
    return new ResponseEntity("Added item to Cart",HttpStatus.OK);}

    @DeleteMapping("/deleteItem/{cartId}")
    public ResponseEntity deleteItem(@PathVariable int cartId) throws CartServiceException {
         cartService.deleteItem(cartId);
        return new ResponseEntity("Deleted item from the cart",HttpStatus.OK);
    }

    @PutMapping("/decreaseItem/{cartId}")
    public ResponseEntity decreaseItem(@PathVariable int cartId){
        cartService.decreaseItem(cartId);
        return new ResponseEntity("Reduced quantity by one",HttpStatus.OK);
    }

    @DeleteMapping("/deleteCart/{userId}")
    public ResponseEntity deleteCart(@PathVariable int userId){
        cartService.deleteCart(userId);
        return new ResponseEntity("Deleted Cart",HttpStatus.OK);
    }

    @GetMapping("/getCartPrice/{userId}")
    public ResponseEntity getCartPrice(@PathVariable int userId){
        int cartPrice = cartService.getCartPrice(userId);
        return new ResponseEntity(cartPrice, HttpStatus.OK);
    }

    @DeleteMapping("/checkout/{userId}")
    public ResponseEntity checkout(@PathVariable int userId){
        cartService.checkoutCart(userId);
        return new ResponseEntity("Checkout cart completed",HttpStatus.OK);
    }
    
    @PostMapping("/payment")
    public ResponseEntity savePayment(@RequestBody Payment payment){
    	paymentService.save(payment);
    return new ResponseEntity("Payment completed Sucessfully",HttpStatus.OK);}
}
