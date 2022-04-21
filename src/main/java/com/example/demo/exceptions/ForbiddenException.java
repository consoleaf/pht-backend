package com.example.demo.exceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException() {
        this("Forbidden");
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
