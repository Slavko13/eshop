package com.future.eshop.exceptions.simpleException;

public class BadRequestException extends RequestException{

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(String message) {
        super(message);
    }

}
