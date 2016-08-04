package com.company.rolanddarvas.constraint;

import com.company.rolanddarvas.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by darvasr on 2016.07.28..
 */
public class DateValidator implements ConstraintValidator<DateValid, UserDTO> {

    @Override
    public void initialize(DateValid a) {
        //no need to initialize here
    }

    @Override
    public boolean isValid(UserDTO user, ConstraintValidatorContext context) {
        if (user.getDateOfBirth() == null) {
            return true;
        } else {
            return user.getDateOfBirth().before(user.getRegistrationDate());
        }
    }

}
