package com.company.rolanddarvas.ee.darvasroland.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author darvasr
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface DateValid {

    String message() default "{DateValid.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
