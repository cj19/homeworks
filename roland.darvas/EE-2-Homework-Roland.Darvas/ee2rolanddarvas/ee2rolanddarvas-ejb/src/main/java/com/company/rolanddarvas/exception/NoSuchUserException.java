package com.company.rolanddarvas.exception;

/**
 * Created by darvasr on 2016.07.28..
 */
public class NoSuchUserException extends RuntimeException{

    public NoSuchUserException(String message) {
        super(message);
    }
}
