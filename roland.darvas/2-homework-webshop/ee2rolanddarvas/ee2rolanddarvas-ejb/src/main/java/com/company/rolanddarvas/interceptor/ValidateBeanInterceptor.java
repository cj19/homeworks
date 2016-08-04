package com.company.rolanddarvas.interceptor;

import com.company.rolanddarvas.annotation.ValidateBean;
import com.company.rolanddarvas.annotation.ValidatorInterceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by darvasr on 2016.07.28..
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
    public Object logMethod(InvocationContext ic) {
        try {
            checkAnnotation(ic.getParameters());
            return ic.proceed();
        } catch (Exception ex) {
            throw new ValidationException("Validation was not successful!");
        }
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
        StringBuilder message = new StringBuilder();
        violations.stream().forEach(new Consumer<ConstraintViolation<Object>>() {
            @Override
            public void accept(ConstraintViolation<Object> violation) {
                message.append("Messages: ").append(violation.getMessage())
                        .append(" ")
                        .append(violation.getMessageTemplate())
                        .append(" ")
                        .append("Properypath: ")
                        .append(violation.getPropertyPath());
            }
        });
        return message.toString();
    }
}
