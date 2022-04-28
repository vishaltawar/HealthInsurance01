package com.cg.health.exception;

public class PolicyUserNotFoundException extends RuntimeException {
	 private String message;
	    public PolicyUserNotFoundException(String message) {
	        super(message);
	        this.message = message;
	    }
	    public PolicyUserNotFoundException() {
	    }
}
