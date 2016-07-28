package com.company.rolanddarvas.exception;

/**
 * Created by CJ on 2016.07.28..
 */
public class UserAlreadyRegistered extends RuntimeException {

    public UserAlreadyRegistered(String message) {
        super(message);
    }
}
