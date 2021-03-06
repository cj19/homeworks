package com.company.rolanddarvas.ee.darvasroland.constraint;

import com.company.rolanddarvas.ee.darvasroland.dto.UserDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author darvasr
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
