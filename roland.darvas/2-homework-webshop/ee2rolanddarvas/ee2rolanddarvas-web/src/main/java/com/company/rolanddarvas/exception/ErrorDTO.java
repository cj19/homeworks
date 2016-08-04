package com.company.rolanddarvas.exception;

/**
 * Created by darvasr on 2016.08.04..
 */
public class ErrorDTO {

    private String message;

    public ErrorDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
