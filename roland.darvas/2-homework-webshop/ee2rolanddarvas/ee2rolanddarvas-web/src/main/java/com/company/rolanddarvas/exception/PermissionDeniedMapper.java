package com.company.rolanddarvas.exception;

import javax.ws.rs.ForbiddenException;
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
public class PermissionDeniedMapper implements ExceptionMapper<ForbiddenException> {

    @Override
    public Response toResponse(ForbiddenException exception) {
        Logger.getLogger(PermissionDeniedMapper.class.getName()).log(Level.WARNING, "Permission Denied has been threw!", exception);
        return Response.status(Response.Status.FORBIDDEN).entity(exception.getMessage())
                .type(MediaType.APPLICATION_JSON).build();
    }
}
