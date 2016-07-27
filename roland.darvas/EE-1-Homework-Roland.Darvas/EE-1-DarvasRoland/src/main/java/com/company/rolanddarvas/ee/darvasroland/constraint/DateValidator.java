package com.company.rolanddarvas.ee.darvasroland.constraint;

import com.company.rolanddarvas.ee.darvasroland.dto.UserDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author darvasr
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
