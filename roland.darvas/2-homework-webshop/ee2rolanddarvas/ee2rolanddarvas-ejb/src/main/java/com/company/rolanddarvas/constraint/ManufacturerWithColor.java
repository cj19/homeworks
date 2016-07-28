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
@Target(value = ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = ManufacturerWithColorValidator.class)
public @interface ManufacturerWithColor {

    String message() default "{ManufacturerWithColor.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
