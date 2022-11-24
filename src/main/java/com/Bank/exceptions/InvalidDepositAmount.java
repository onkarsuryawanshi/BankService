package com.Bank.exceptions;

public class InvalidDepositAmount extends RuntimeException {
    public InvalidDepositAmount(String message) {
        super(message);
    }
}
