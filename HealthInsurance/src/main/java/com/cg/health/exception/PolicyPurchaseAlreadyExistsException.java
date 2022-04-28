package com.cg.health.exception;

public class PolicyPurchaseAlreadyExistsException extends RuntimeException {
	   private String message;
	    public PolicyPurchaseAlreadyExistsException(String message) {
	        super(message);
	        this.message = message;
	    }
	    public PolicyPurchaseAlreadyExistsException() {
	    }
}
