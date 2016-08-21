package com.company.rolanddarvas.exception.custom.machine;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class MachineAlreadyInAmusementPark extends CodedCustomException {

    private static final String ALREADY_IN_PARK = "machine.alreadyInPark";

    public MachineAlreadyInAmusementPark(String message) {
        super(message, ALREADY_IN_PARK);
    }
}
