package com.company.rolanddarvas.model.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * Created by darvasr on 2016.08.21..
 */
public class LoggerProducer {

    @Produces
    public Logger loggerProducer(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().toString());
    }
}
