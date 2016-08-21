package com.company.rolanddarvas.exception.custom.shared;

import com.company.rolanddarvas.exception.custom.CodedCustomException;

/**
 * Created by darvasr on 2016.08.21..
 */
public class NotEnoughMoney extends CodedCustomException {

    private static final String NOT_ENOUGH_MONEY_MESSAGE = "custom.notEnoughMoney";

    public NotEnoughMoney(String message) {
        super(message, NOT_ENOUGH_MONEY_MESSAGE);
    }
}
