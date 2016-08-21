package com.company.rolanddarvas.exception.custom.machine;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class MachineIsNotEmpty extends CodedCustomException {

    private static final String MACHINE_NOT_EMPTY = "machine.NotEmptyYet";

    public MachineIsNotEmpty(String message) {
        super(message, MACHINE_NOT_EMPTY);
    }
}
