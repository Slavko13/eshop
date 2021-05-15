package com.future.eshop.exceptions.simpleException;

public class InternalServerException extends RequestException {

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerException(String message) {
        super(message);
    }

}
