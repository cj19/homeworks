package com.company.rolanddarvas.exception.custom.park;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class NotInTheSamePark extends CodedCustomException{

    private static final String NOT_IN_SAME_PARK = "park.visitorAndMachineNotInTheSamePark";

    public NotInTheSamePark(String message) {
        super(message, NOT_IN_SAME_PARK);
    }
}
