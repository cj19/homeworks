package com.company.rolanddarvas.ee.darvasroland.interceptor;

import com.company.rolanddarvas.ee.darvasroland.annotation.ValidateBean;
import com.company.rolanddarvas.ee.darvasroland.annotation.ValidatorInterceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by darvasr on 2016.07.27..
 */
@Interceptor
@ValidatorInterceptor
public class ValidateBeanInterceptor {


    private final Validator validator;

    @Inject
    public ValidateBeanInterceptor(Validator validator) {
        this.validator = validator;
    }

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        checkAnnotation(ic.getParameters());
        return ic.proceed();
    }

    private void checkAnnotation(Object[] parameters) {
        for (Object parameter : parameters) {
            Class<?> clazz = parameter.getClass();
            if (clazz.isAnnotationPresent(ValidateBean.class)) {
                validateParameter(parameter);
            }
        }
    }

    private void validateParameter(Object parameter) {
        Set<ConstraintViolation<Object>> violations = validator.validate(parameter);
        if (!violations.isEmpty()) {
            throw new ValidationException(getViolationMessage(violations));
        }
    }

    private String getViolationMessage(Set<ConstraintViolation<Object>> violations) {
        return violations.iterator().next().getInvalidValue()+violations.toString();
    }
}
