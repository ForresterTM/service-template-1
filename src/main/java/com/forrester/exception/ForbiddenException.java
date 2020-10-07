package com.forrester.exception;

public class ForbiddenException extends Exception {

    public ForbiddenException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public ForbiddenException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }

}
