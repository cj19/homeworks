package com.company.rolanddarvas.exception;

/**
 * Created by darvasr on 2016.08.04..
 */
public class ExceptionToJson {

    private Throwable exception;

    private String message;

    public ExceptionToJson(Throwable exception, String message) {
        this.message = message;
        this.exception = exception;
    }

    public Throwable getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }
}
