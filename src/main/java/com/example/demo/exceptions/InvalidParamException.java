package com.example.demo.exceptions;

public class InvalidParamException extends RuntimeException {

    public InvalidParamException(String msg) {
        super(msg);
    }
}
