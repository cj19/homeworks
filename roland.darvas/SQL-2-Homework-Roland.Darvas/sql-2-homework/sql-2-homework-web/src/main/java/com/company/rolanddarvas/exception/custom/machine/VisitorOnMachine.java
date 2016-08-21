package com.company.rolanddarvas.exception.custom.machine;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class VisitorOnMachine extends CodedCustomException {

    private static final String VISITOR_ON_MACHINE_ALREADY = "machine.visitorAlreadyOnMachine";

    public VisitorOnMachine(String message) {
        super(message, VISITOR_ON_MACHINE_ALREADY);
    }
}
