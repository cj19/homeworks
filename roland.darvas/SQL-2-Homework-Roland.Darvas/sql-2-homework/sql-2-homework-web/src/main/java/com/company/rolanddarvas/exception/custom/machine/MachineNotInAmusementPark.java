package com.company.rolanddarvas.exception.custom.machine;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class MachineNotInAmusementPark extends CodedCustomException {

    private static final String NOT_IN_PARK = "machine.notInPark";

    public MachineNotInAmusementPark(String message) {
        super(message, NOT_IN_PARK);
    }
}
