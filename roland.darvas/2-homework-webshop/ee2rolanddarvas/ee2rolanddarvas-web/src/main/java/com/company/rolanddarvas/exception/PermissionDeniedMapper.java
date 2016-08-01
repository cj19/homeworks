package com.company.rolanddarvas.exception;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by darvasr on 2016.08.01..
 */
@Provider
public class PermissionDeniedMapper implements ExceptionMapper<ForbiddenException> {

    @Override
    public Response toResponse(ForbiddenException e) {
        return Response.status(403).entity(e.getMessage())
                .type(MediaType.APPLICATION_JSON).build();
    }
}
