package com.company.rolanddarvas.rest;

import com.company.rolanddarvas.service.MobileInventory;
import com.company.rolanddarvas.utility.LoginAssister;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by darvasr on 2016.08.01..
 */
@Path("/inventory")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MobileInventoryResource implements Serializable {

    private static final transient Logger LOGGER = Logger.getLogger(MobileInventoryResource.class.getName());

    @EJB
    private transient MobileInventory mobileInventory;

    @GET
    @Path("/count/{id}")
    public Integer count(@PathParam("id") String id) {
        return mobileInventory.count(id);
    }

    @PUT
    @Path("/add/{id}")
    public void add(@Context HttpServletRequest request, @PathParam("id") String id,
                          @QueryParam("amount") Integer amount){
        LoginAssister.userLogin(request);
        mobileInventory.increment(id, amount);
        LOGGER.log(Level.INFO, "Mobile with the id: "+id+", amount got incremented by "+amount);
    }

    @PUT
    @Path("/remove/{id}")
    public void remove(@Context HttpServletRequest request, @PathParam("id") String id,
                       @QueryParam("amount") Integer amount) {
        LoginAssister.userLogin(request);
        mobileInventory.decrement(id, amount);
        LOGGER.log(Level.INFO, "Mobile with the id: "+id+", amount got decremented by "+amount);
    }
}
