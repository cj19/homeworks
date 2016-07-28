package com.company.rolanddarvas.ee.darvasroland.producer;

import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by darvasr on 2016.07.27..
 */
public class ValidatorProducer {

    @Produces
    public Validator injectValidator(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator();
    }
}
