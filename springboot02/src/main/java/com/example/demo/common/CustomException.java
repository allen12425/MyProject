package com.example.demo.common;

public class CustomException extends RuntimeException {
    private Integer code;

    public CustomException(Exception e) {
        this(null, e.getMessage(), e);
    }

    public CustomException(String messge) {
        this(null, messge, null);
    }

    public CustomException(String message, Throwable throwable) {
        this(null, message, throwable);
    }

    public CustomException(Integer code, String message) {
        this(code, message, null);
    }

    public CustomException(Integer code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code == null ? 0 : code;
    }

    public Integer getCode() {
        return code;
    }
}
