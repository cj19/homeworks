package com.company.rolanddarvas.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by darvasr on 2016.07.28..
 */
@Size(min = 6)
@Pattern.List({
        @Pattern(regexp = ".*[0-9].*"),
        @Pattern(regexp = ".*[a-z].*"),
        @Pattern(regexp = ".*[A-Z].*"),
        @Pattern(regexp = ".*[\\+,<=>\\.].*")})
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface Password {

    String message() default "{Password.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
