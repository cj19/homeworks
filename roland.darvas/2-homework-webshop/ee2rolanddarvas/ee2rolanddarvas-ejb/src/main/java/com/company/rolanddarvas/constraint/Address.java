package com.company.rolanddarvas.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by darvasr on 2016.07.28..
 */
@Pattern(regexp = "^\\d{4}.*")
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface Address {

    String message() default "{Address.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}