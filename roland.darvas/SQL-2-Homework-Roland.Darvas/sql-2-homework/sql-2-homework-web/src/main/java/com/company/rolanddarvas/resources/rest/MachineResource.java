package com.company.rolanddarvas.resources.rest;

import com.company.rolanddarvas.entity.Machine;
import com.company.rolanddarvas.model.dto.MachineDTO;
import com.company.rolanddarvas.model.dto.MachineListDTO;
import com.company.rolanddarvas.model.dto.VisitorListDTO;
import com.company.rolanddarvas.service.MachineService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by darvasr on 2016.08.21..
 */
@Path("machine")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MachineResource {

    private MachineService machineService;

    @GET
    @Path("{id}")
    public Response getMachine(@PathParam("id") Long id) {
        Machine machine = machineService.getMachineById(id);
        return Response.ok(machine).build();
    }

    @POST
    public Response createMachine(MachineDTO machineDTO) {
        Machine machine = machineService.createMachine(machineDTO);
        return Response.ok(machine).build();
    }

    @PUT
    @Path("{id}")
    public Response updateMachine(@PathParam("id") Long id, MachineDTO machineDTO) {
        Machine machine = machineService.updateMachine(id, machineDTO);
        return Response.ok(machine).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteMachine(@PathParam("id") Long id) {
        Machine machine = machineService.removeMachine(id);
        return Response.ok(machine).build();
    }

    @POST
    @Path("{id}/close")
    public Response closeMachine(@PathParam("id") Long id) {
        Machine machine = machineService.closeMachineById(id);
        return Response.ok(machine).build();
    }

    @POST
    @Path("{id}/open")
    public Response openMachine(@PathParam("id") Long id) {
        Machine machine = machineService.openMachineById(id);
        return Response.ok(machine).build();
    }

    @POST
    @Path("{machineId}/{parkId}")
    public Response addToPark(@PathParam("machineId") Long machineId, Long parkId) {
        Machine machine = machineService.addToAmusementParkById(machineId, parkId);
        return Response.ok(machine).build();
    }

    @GET
    @Path("{id}/visitors")
    public Response getVisitorsByMachineId(@PathParam("id") Long id) {
        VisitorListDTO visitors = machineService.getVisitorsByMachineId(id);
        return Response.ok(visitors).build();
    }

    @GET
    @Path("limited")
    public Response getLimited(Integer ageLimit) {
        MachineListDTO machines = machineService.getMachinesAboveAgeLimit(ageLimit);
        return Response.ok(machines).build();
    }

    @GET
    public Response getAllMachine() {
        MachineListDTO machines = machineService.getAllMachines();
        return Response.ok(machines).build();
    }

    @Inject
    public void setMachineService(MachineService machineService) {
        this.machineService = machineService;
    }
}
