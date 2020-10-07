package com.forrester.exception;

public class AuthorizationException extends Exception {
    private static final long serialVersionUID = 7950315256164993754L;

    public AuthorizationException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public AuthorizationException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }
}
