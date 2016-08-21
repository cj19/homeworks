package com.company.rolanddarvas.exception.custom.machine;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class MachineIsNotClosed extends CodedCustomException {

    private static final String MACHINE_NOT_CLOSED = "machine.notClosed";

    public MachineIsNotClosed(String message) {
        super(message, MACHINE_NOT_CLOSED);
    }
}
