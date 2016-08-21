package com.company.rolanddarvas.exception.mapper;

import com.company.rolanddarvas.exception.custom.CodedCustomException;
import com.company.rolanddarvas.model.dto.CodedExceptionDTO;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by darvasr on 2016.08.21..
 */
public class CodedCustomExceptionMapper implements ExceptionMapper<CodedCustomException> {

    @Inject
    private Logger logger;

    @Override
    public Response toResponse(CodedCustomException exception) {
        logger.log(Level.SEVERE, "Custom exception threw!", exception.toString());

        CodedExceptionDTO codedExceptionDTO = new CodedExceptionDTO();
        codedExceptionDTO.setExceptionCode(exception.getCode());
        codedExceptionDTO.setDetails(exception.getMessage());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(codedExceptionDTO).type(MediaType.APPLICATION_JSON).build();
    }
}
