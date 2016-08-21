package com.company.rolanddarvas.exception.custom.park;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class VisitorIsNotInThisAmusementPark extends CodedCustomException {

    private static final String NOT_IN_THIS_PARK = "park.visitorNotInThisPark";

    public VisitorIsNotInThisAmusementPark(String message) {
        super(message, NOT_IN_THIS_PARK);
    }
}
