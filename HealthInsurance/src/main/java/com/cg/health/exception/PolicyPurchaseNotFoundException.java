package com.cg.health.exception;

public class PolicyPurchaseNotFoundException extends RuntimeException {
	private String message;
    public PolicyPurchaseNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public PolicyPurchaseNotFoundException() {
    }
}
