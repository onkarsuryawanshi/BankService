package com.Bank.exceptions;

public class InsufficientAmount extends RuntimeException {
    public InsufficientAmount(String message) {
        super(message);
    }
}
