package com.company.rolanddarvas.rest;

import com.company.rolanddarvas.dto.MobileType;
import com.company.rolanddarvas.service.MobileInventory;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.company.rolanddarvas.utility.Session.validateAdminLogin;

/**
 * Created by darvasr on 2016.08.01..
 */
@Path("/mobile")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MobileTypeResource implements Serializable {

    @EJB
    private transient MobileInventory mobileInventory;

    private final transient Logger LOGGER = Logger.getLogger(MobileTypeResource.class.getName());

    @POST
    @Path("/add")
    public MobileType addMobile(@Context HttpServletRequest request, MobileType mobileType){
        validateAdminLogin(request);
        mobileInventory.addNewMobileType(mobileType);
        LOGGER.log(Level.INFO, mobileType.getType()+" type added to the inventory list!");
        return mobileType;
    }

    @DELETE
    @Path("/remove")
    public MobileType removeMobile(@Context HttpServletRequest request, MobileType mobileType){
        validateAdminLogin(request);
        mobileInventory.removeMobile(mobileType);
        LOGGER.log(Level.INFO, mobileType.getType()+" type removed from the inventory list!");
        return mobileType;
    }

    @GET
    @Path("/get/{id}")
    public MobileType getMobileById(@PathParam("id") String id) {
        return mobileInventory.getMobileById(id);
    }

    @GET
    public String getInventory(){
        return mobileInventory.getInventoryAsString();
    }
}
