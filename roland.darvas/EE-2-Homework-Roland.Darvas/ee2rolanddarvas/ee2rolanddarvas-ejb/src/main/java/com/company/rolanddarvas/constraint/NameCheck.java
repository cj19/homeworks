package com.company.rolanddarvas.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by darvasr on 2016.07.28..
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = NameCheckValidator.class)
public @interface NameCheck {
    String message() default "{NameCheck.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
