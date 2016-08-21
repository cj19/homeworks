package com.company.rolanddarvas.exception.custom.park;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class NotFreeLandLeftInPark extends CodedCustomException{

    private static final String NOT_FREE_LAND = "park.notFreeLandLeft";

    public NotFreeLandLeftInPark(String message) {
        super(message, NOT_FREE_LAND);
    }
}
