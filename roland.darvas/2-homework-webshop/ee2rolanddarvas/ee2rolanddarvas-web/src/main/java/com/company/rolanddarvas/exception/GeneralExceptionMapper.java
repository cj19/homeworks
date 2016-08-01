package com.company.rolanddarvas.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by darvasr on 2016.08.01..
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        return Response
                .status(500)
                .entity(exception)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
