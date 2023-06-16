package com.shopping.cart.exception;

import org.springframework.http.HttpStatus;

public class ProductServiceException extends RuntimeException {
    String errorMessage;
    HttpStatus httpStatus;
    public ProductServiceException(String errorMessage, HttpStatus httpStatusCode){
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatusCode;
    }
}
