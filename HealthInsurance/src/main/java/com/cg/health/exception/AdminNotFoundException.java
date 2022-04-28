package com.cg.health.exception;

public class AdminNotFoundException extends RuntimeException {
    private String message;
    public AdminNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public AdminNotFoundException() {
    }
}
