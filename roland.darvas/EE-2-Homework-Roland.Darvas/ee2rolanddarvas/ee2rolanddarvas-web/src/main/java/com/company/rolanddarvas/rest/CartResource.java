package com.company.rolanddarvas.rest;

import com.company.rolanddarvas.dto.MobileType;
import com.company.rolanddarvas.service.Cart;
import com.company.rolanddarvas.utility.LoginAssister;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

/**
 * Created by darvasr on 2016.08.01..
 */
@Path("/cart")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource implements Serializable {

    @EJB
    private transient Cart cart;

    @POST
    @Path("/add")
    public MobileType add(@Context HttpServletRequest request, MobileType mobileType) {
        LoginAssister.userLogin(request);
        cart.add(mobileType, 1);
        return mobileType;
    }

    @DELETE
    @Path("/remove")
    public MobileType remove(@Context HttpServletRequest request, MobileType mobileType) {
        LoginAssister.userLogin(request);
        cart.remove(mobileType, 1);
        return mobileType;
    }

    @POST
    @Path("/checkout")
    public String checkout(@Context HttpServletRequest request) {
        LoginAssister.userLogin(request);
        String checkout = cart.checkout();
        request.getSession().invalidate();
        return checkout;
    }
}
