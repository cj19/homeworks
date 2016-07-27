package com.company.rolanddarvas.ee.darvasroland.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

/**
 *
 * @author darvasr
 */
@Pattern(regexp = "(^06+\\d{9})|(^\\+36+\\d{9})")
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface Phone {
    
    String message() default "{Phone.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
