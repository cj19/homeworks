package com.company.rolanddarvas.rest;

import com.company.rolanddarvas.dto.UserDTO;
import com.company.rolanddarvas.service.UserDB;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.company.rolanddarvas.utility.Session.validateAdminLogin;

/**
 * Created by darvasr on 2016.07.28..
 */
@Path("/user")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource implements Serializable {

    @EJB
    private transient UserDB userDB;

    private final transient Logger LOGGER = Logger.getLogger(UserResource.class.getName());

    @POST
    @Path("/add")
    public UserDTO addUser(@Context HttpServletRequest request, UserDTO user) {
        validateAdminLogin(request);
        userDB.register(user);
        LOGGER.log(Level.INFO, user.getUsername() + " added to the registered user's list!");
        return user;
    }

    @DELETE
    @Path("/remove")
    public UserDTO removeUser(@Context HttpServletRequest request, UserDTO user) {
        validateAdminLogin(request);
        userDB.remove(user.getUsername());
        LOGGER.log(Level.INFO, user.getUsername() + " removed from the registered user's list!");
        return user;
    }

    @GET
    @Path("/getUser")
    public UserDTO getUser(@Context HttpServletRequest request, @QueryParam("username") String username) {
        request.getSession(true).setMaxInactiveInterval(2000);
        return userDB.getUser(username);
    }

    @GET
    public Collection<UserDTO> getUsers() {
        return userDB.getRegisteredUser().values();
    }

    @POST
    @Path("/loginUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDTO login(@Context HttpServletRequest request, UserDTO user) {
        if (userDB.authenticate(user.getUsername(), user.getPassword())) {
            UserDTO loggedUser = userDB.getUser(user.getUsername());
            HttpSession session = request.getSession(false);
            session.setAttribute("user", loggedUser);
            return user;
        }
        throw new WebApplicationException("wrong username or password!");
    }
}
