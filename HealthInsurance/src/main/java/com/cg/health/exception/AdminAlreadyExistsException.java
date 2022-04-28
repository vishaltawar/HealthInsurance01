package com.cg.health.exception;

public class AdminAlreadyExistsException extends RuntimeException {

    private String message;
public AdminAlreadyExistsException(String message) {
    super(message);
    this.message = message;
}
public AdminAlreadyExistsException() {
}
}
