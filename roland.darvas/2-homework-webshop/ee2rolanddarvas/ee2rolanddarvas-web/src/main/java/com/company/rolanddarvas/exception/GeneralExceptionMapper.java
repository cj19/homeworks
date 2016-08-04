package com.company.rolanddarvas.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by darvasr on 2016.08.01..
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        Logger.getLogger(GeneralExceptionMapper.class.getName()).log(Level.SEVERE, null, exception);
        return Response
                .status(500)
                .entity(new ExceptionToJson(exception, exception.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
