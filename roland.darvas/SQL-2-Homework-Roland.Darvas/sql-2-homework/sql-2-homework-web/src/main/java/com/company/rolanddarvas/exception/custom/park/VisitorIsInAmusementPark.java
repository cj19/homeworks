package com.company.rolanddarvas.exception.custom.park;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class VisitorIsInAmusementPark extends CodedCustomException {

    private static final String NOT_IN_AMUSEMENT_PARK = "park.notInParkYet";

    public VisitorIsInAmusementPark(String message) {
        super(message, NOT_IN_AMUSEMENT_PARK);
    }
}
