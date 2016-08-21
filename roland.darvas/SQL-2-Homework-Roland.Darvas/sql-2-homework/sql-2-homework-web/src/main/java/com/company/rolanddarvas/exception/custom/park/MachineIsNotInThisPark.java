package com.company.rolanddarvas.exception.custom.park;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class MachineIsNotInThisPark extends CodedCustomException {

    private static final String MACHINE_NOT_IN_PARK = "park.machineNotInThisPark";

    public MachineIsNotInThisPark(String message) {
        super(message, MACHINE_NOT_IN_PARK);
    }
}
