package com.shopping.review.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
