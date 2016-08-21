package com.company.rolanddarvas.exception.mapper;

import com.company.rolanddarvas.model.dto.ErrorDTO;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by darvasr on 2016.08.21..
 */
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {

    @Inject
    private Logger logger;

    @Override
    public Response toResponse(Throwable throwable) {
        logger.log(Level.SEVERE, "General exception threw!", throwable);

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorDetail(throwable.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorDTO).type(MediaType.APPLICATION_JSON).build();
    }
}
