package com.company.rolanddarvas.constraint;

import com.company.rolanddarvas.dto.UserDTO;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by darvasr on 2016.07.28..
 */
public class NameCheckValidator implements ConstraintValidator<NameCheck, UserDTO> {

    @Override
    public void initialize(NameCheck a) {
        //no need to initialize here
    }

    @Override
    public boolean isValid(UserDTO user, ConstraintValidatorContext context) {
        return (isFirstNameNull(user) && isLastNameNull(user))
                || (isFirstNameNotEmpty(user)
                && isLastNameNotEmpty(user));
    }

    private static boolean isLastNameNotEmpty(UserDTO user) {
        return !StringUtils.isEmpty(user.getLastName());
    }

    private static boolean isFirstNameNotEmpty(UserDTO user) {
        return !StringUtils.isEmpty(user.getFirstName());
    }

    private static boolean isLastNameNull(UserDTO user) {
        return user.getLastName() == null;
    }

    private static boolean isFirstNameNull(UserDTO user) {
        return user.getFirstName() == null;
    }

}
