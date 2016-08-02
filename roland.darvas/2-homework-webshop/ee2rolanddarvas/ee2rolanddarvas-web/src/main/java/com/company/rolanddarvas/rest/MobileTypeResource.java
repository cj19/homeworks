package com.company.rolanddarvas.rest;

import com.company.rolanddarvas.dto.MobileType;
import com.company.rolanddarvas.service.MobileInventory;
import com.company.rolanddarvas.utility.LoginAssister;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by darvasr on 2016.08.01..
 */
@Path("/mobiles")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MobileTypeResource implements Serializable {

    private static final transient Logger LOGGER = Logger.getLogger(MobileTypeResource.class.getName());

    @EJB
    private transient MobileInventory mobileInventory;

    @POST
    public MobileType addMobile(@Context HttpServletRequest request, MobileType mobileType){
        LoginAssister.adminLogin(request);
        mobileInventory.addNewMobileType(mobileType);
        LOGGER.log(Level.INFO, mobileType.getType()+" type added to the inventory list!");
        return mobileType;
    }

    @DELETE
    public MobileType removeMobile(@Context HttpServletRequest request, MobileType mobileType){
        LoginAssister.adminLogin(request);
        mobileInventory.removeMobile(mobileType);
        LOGGER.log(Level.INFO, mobileType.getType()+" type removed from the inventory list!");
        return mobileType;
    }

    @GET
    @Path("/{id}")
    public MobileType getMobileById(@PathParam("id") String id) {
        return mobileInventory.getMobileById(id);
    }

    @GET
    public Collection<MobileType> getInventory(){
        return mobileInventory.getInventory();
    }
}
