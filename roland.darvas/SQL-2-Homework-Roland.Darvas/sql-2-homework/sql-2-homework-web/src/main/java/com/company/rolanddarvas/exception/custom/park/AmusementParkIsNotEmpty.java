package com.company.rolanddarvas.exception.custom.park;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class AmusementParkIsNotEmpty extends CodedCustomException{

    private static final String NOT_EMPTY_YET = "park.notCompletelyEmptyPark";

    public AmusementParkIsNotEmpty(String message) {
        super(message, NOT_EMPTY_YET);
    }
}
