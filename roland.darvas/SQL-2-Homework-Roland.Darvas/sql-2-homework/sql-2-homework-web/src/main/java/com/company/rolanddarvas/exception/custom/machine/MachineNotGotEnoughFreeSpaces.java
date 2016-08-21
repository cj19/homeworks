package com.company.rolanddarvas.exception.custom.machine;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class MachineNotGotEnoughFreeSpaces extends CodedCustomException {

    private static final String NOT_ENOUGH_SPACE = "machine.notEnoughSpaces";

    public MachineNotGotEnoughFreeSpaces(String message) {
        super(message, NOT_ENOUGH_SPACE);
    }
}
