package com.forrester.exception;

public class NotAcceptableException extends Exception {

    public NotAcceptableException(String message) {
        super(message);
    }

    public NotAcceptableException(String message, Throwable cause) {
        super(message, cause);
    }
}
