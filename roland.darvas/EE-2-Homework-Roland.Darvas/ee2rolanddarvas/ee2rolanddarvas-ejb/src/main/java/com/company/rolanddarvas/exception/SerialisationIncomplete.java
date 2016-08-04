package com.company.rolanddarvas.exception;

/**
 * Created by darvasr on 2016.08.02..
 */
public class SerialisationIncomplete extends RuntimeException {

    public SerialisationIncomplete(String message, Throwable cause) {
        super(message, cause);
    }
}
