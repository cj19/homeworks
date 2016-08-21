package com.company.rolanddarvas.exception.custom.visitor;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class AgeLimit extends CodedCustomException {

    private static final String AGE_LIMIT_CODE = "visitor.AgeLimit";

    public AgeLimit(String message) {
        super(message, AGE_LIMIT_CODE);
    }
}
