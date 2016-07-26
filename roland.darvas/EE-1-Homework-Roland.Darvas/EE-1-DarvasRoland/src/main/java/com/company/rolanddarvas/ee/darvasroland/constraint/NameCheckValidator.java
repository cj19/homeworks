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
        return nameValidator(user);
    }

    private boolean nameValidator(UserDTO user) {
        return (user.getFirstName() == null && user.getLastName() == null)
                || (!StringUtils.isEmpty(user.getFirstName()) 
                && !StringUtils.isEmpty(user.getLastName()));
    }
}
