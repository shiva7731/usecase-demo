package com.shopping.cart.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.shopping.cart.model.Cart;

public class CheckOutException  extends RuntimeException {
    String errorMessage;
    HttpStatus httpStatus;

    List<Cart> unavailableItems;

    public CheckOutException(String errorMessage, HttpStatus httpStatus, List<Cart> unavailableItems){
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.unavailableItems = unavailableItems;
    }
}
