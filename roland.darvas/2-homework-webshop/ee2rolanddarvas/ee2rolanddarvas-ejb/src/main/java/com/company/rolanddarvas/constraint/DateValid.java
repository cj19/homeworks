package com.company.rolanddarvas.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by darvas on 2016.07.28..
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface DateValid {

    String message() default "{DateValid.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
