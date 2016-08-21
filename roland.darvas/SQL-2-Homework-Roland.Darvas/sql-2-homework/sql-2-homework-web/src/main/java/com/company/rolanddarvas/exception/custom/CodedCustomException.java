package com.company.rolanddarvas.exception.custom;

/**
 * Created by darvasr on 2016.08.21..
 */
public class CodedCustomException extends RuntimeException {

    private String code;

    public CodedCustomException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
