package com.cg.health.exception;

public class PolicyUserAlreadyExistsException extends RuntimeException {
	 private String message;
	    public PolicyUserAlreadyExistsException(String message) {
	        super(message);
	        this.message = message;
	    }
	    public PolicyUserAlreadyExistsException() {
	    }
}
