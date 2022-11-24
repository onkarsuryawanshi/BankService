package com.Bank.exceptions;

public class AccountTypeIsNotValidException extends RuntimeException{
    public AccountTypeIsNotValidException(String message) {
        super(message);
    }
}
