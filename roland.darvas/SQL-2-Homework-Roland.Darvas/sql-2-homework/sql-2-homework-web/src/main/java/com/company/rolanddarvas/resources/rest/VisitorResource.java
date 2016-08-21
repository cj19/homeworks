package com.company.rolanddarvas.resources.rest;

import com.company.rolanddarvas.entity.Visitor;
import com.company.rolanddarvas.model.dto.VisitorDTO;
import com.company.rolanddarvas.model.dto.VisitorListDTO;
import com.company.rolanddarvas.service.VisitorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by darvasr on 2016.08.21..
 */
@Path("visitor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VisitorResource {

    private VisitorService visitorService;

    @GET
    @Path("{id}")
    public Response getVisitor(@PathParam("id") Long id) {
        Visitor visitor = visitorService.getVisitorById(id);
        return Response.ok(visitor).build();
    }

    @POST
    public Response createVisitor(VisitorDTO visitorDTO) {
        Visitor visitor = visitorService.createVisitor(visitorDTO);
        return Response.ok(visitor).build();
    }

    @PUT
    @Path("{id}")
    public Response updateVisitor(@PathParam("id") Long id, VisitorDTO visitorDTO) {
        Visitor visitor = visitorService.updateVisitor(id, visitorDTO);
        return Response.ok(visitor).build();
    }

    @POST
    @Path("{visitorId}/machine/{machineId}")
    public Response addToMachine(@PathParam("visitorId") Long visitorId, @PathParam("machineId") Long machineId) {
        Visitor visitor = visitorService.addVisitorToMachine(visitorId, machineId);
        return Response.ok(visitor).build();
    }

    @DELETE
    @Path("{id}/machine")
    public Response removeFromMachine(@PathParam("id") Long id) {
        Visitor visitor = visitorService.removeFromMachine(id);
        return Response.ok(visitor).build();
    }

    @POST
    @Path("{visitorId}/park/{parkId}")
    public Response addToPark(@PathParam("visitorId") Long visitorId, @PathParam("parkId") Long parkId) {
        Visitor visitor = visitorService.enterAmusementPark(visitorId, parkId);
        return Response.ok(visitor).build();
    }

    @DELETE
    @Path("{id}/park")
    public Response removeFromPark(@PathParam("id") Long id) {
        Visitor visitor = visitorService.leaveAmusementPark(id);
        return Response.ok(visitor).build();
    }

    @GET
    public Response getAllVisitor() {
        VisitorListDTO visitors = visitorService.getAllVisitors();
        return Response.ok(visitors).build();
    }

    @Inject
    public void setVisitorService(VisitorService visitorService) {
        this.visitorService = visitorService;
    }
}
