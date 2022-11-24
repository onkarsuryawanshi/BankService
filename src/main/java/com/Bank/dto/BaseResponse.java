package com.Bank.dto;

import java.io.Serializable;

public class BaseResponse implements Serializable {
    private String message;
    private boolean success;

    public BaseResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public BaseResponse() {}

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
