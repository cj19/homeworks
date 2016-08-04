package com.company.rolanddarvas.exception;

/**
 * Created by darvasr on 2016.07.28..
 */
public class MobileAlreadyRegistered extends RuntimeException {

    public MobileAlreadyRegistered(String message) {
        super(message);
    }
}
