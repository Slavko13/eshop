package com.future.eshop.exceptions.simpleException;

public class TeapotException extends RequestException{

    public TeapotException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeapotException (String message) {
        super(message);
    }

}
