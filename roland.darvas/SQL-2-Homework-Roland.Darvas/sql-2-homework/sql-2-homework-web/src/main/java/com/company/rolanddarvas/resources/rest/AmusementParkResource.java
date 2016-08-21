package com.company.rolanddarvas.resources.rest;

import com.company.rolanddarvas.entity.AmusementPark;
import com.company.rolanddarvas.model.dto.*;
import com.company.rolanddarvas.service.AmusementParkService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by darvasr on 2016.08.21..
 */
@Path("park")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AmusementParkResource {

    private AmusementParkService amusementParkService;

    @GET
    @Path("{id}")
    public Response getAmusementPark(@PathParam("id") Long id) {
        AmusementPark amusementPark = amusementParkService.getAmusementParkById(id);
        return Response.ok(amusementPark).build();
    }

    @POST
    public Response create(AmusementParkDTO amusementParkDTO) {
        AmusementPark amusementPark = amusementParkService.createAmusementPark(amusementParkDTO);
        return Response.ok(amusementPark).build();
    }

    @PUT
    @Path("{id}")
    public Response updatePark(@PathParam("id") Long id, AmusementParkDTO amusementParkDTO) {
        AmusementPark amusementPark = amusementParkService.updateAmusementPark(id, amusementParkDTO);
        return Response.ok(amusementPark).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePark(@PathParam("id") Long id) {
        AmusementPark amusementPark = amusementParkService.removeAmusementParkById(id);
        return Response.ok(amusementPark).build();
    }

    @GET
    @Path("{id}/machines")
    public Response getMachinesOfPark(@PathParam("id") Long id) {
        MachineListDTO machines = amusementParkService.getAllMachines(id);
        return Response.ok(machines).build();
    }

    @GET
    @Path("{id}/visitors")
    public Response getVisitorsOfPark(@PathParam("id") Long id) {
        VisitorListDTO visitors = amusementParkService.getAllVisitors(id);
        return Response.ok(visitors).build();
    }

    @GET
    @Path("{id}/idleVisitors")
    public Response getIdleVisitorsOfPark(@PathParam("id") Long id) {
        VisitorReportDTO visitors = amusementParkService.getIdleVisitors(id);
        return Response.ok(visitors).build();
    }

    @GET
    public Response getAllParks() {
        AmusementParkListDTO amusementParks = amusementParkService.getAmusementParkList();
        return Response.ok(amusementParks).build();
    }

    @Inject
    public void setAmusementParkService(AmusementParkService amusementParkService) {
        this.amusementParkService = amusementParkService;
    }
}
