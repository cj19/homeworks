package com.company.rolanddarvas.producer;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Produces;

/**
 * Created by darvasr on 2016.07.28..
 */
public class ValidatorProducer {

    @Produces
    public Validator injectValidator(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator();
    }
}
