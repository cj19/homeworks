package com.company.rolanddarvas.exception.custom.machine;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class VisitorNotOnThisMachine extends CodedCustomException {

    private static final String VISITOR_NOT_ON_THIS_MACHINE = "machine.visitorNotOnThisMachine";

    public VisitorNotOnThisMachine(String message) {
        super(message, VISITOR_NOT_ON_THIS_MACHINE);
    }
}
