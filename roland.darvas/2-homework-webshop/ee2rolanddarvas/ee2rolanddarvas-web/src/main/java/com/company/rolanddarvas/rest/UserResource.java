package com.company.rolanddarvas.rest;

import com.company.rolanddarvas.dto.UserDTO;
import com.company.rolanddarvas.service.UserDB;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by darvasr on 2016.07.28..
 */
@Path("/user")
@SessionScoped
@Produces(APPLICATION_JSON)
public class UserResource implements Serializable {

    @EJB
    private transient UserDB userDB;

    private final transient  Logger LOGGER = Logger.getLogger(UserResource.class.getName());

    @POST
    @Path("/add")
    @Consumes(APPLICATION_JSON)
    public UserDTO addUser(@Context HttpServletRequest request, UserDTO user) {
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(5000);
        Object userObject = request.getSession().getAttribute("userDTO");
        if ((userObject != null) && (userObject instanceof UserDTO)) {
            UserDTO userDTO = (UserDTO) userObject;
            if (userDTO.isAdmin()) {
                LOGGER.log(Level.INFO, userDTO.getUsername() + " add a new user to the registered user's list!");
                userDB.register(user);
                return user;
            }
        }
        return null;
    }

    @DELETE
    @Path("/remove")
    public UserDTO removeUser(@Context HttpServletRequest request, UserDTO user) {
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(5000);
        Object userObject = request.getSession().getAttribute("userDTO");
        if ((userObject != null) && (userObject instanceof UserDTO)) {
            UserDTO userDTO = (UserDTO) userObject;
            if (userDTO.isAdmin()) {
                LOGGER.log(Level.INFO, userDTO.getUsername() + " remove a user from the registered user's list!");
                userDB.remove(user.getUsername());
                return user;
            }
        }
        return null;
    }

    @GET
    @Path("/getUser")
    public UserDTO getUser(@Context HttpServletRequest request, String username){
        request.getSession(true).setMaxInactiveInterval(2000);
        return userDB.getUser(username);
    }

    @GET
    @Path("/userList")
    public Collection<UserDTO> getUsers(){
        return userDB.getRegisteredUser().values();
    }

    @POST
    @Path("/login")
    public boolean login(@Context HttpServletRequest request, UserDTO user){
        HttpSession session = request.getSession(true);
        for (Entry<String, UserDTO> acceptedUser: userDB.getRegisteredUser().entrySet()) {
            String username = acceptedUser.getKey();
            if (username.equals(user.getUsername())) {
                session.setMaxInactiveInterval(2000);
                return true;
            }
        }
        session.invalidate();
        return false;
    }
}
