package com.example.demo.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        this("Unauthorized");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
