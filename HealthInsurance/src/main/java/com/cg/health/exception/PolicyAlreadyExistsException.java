package com.cg.health.exception;

public class PolicyAlreadyExistsException extends RuntimeException {
	
	    private String message;
	    public PolicyAlreadyExistsException(String message) {
	        super(message);
	        this.message = message;
	    }
	    public PolicyAlreadyExistsException() {
	    }
	}

