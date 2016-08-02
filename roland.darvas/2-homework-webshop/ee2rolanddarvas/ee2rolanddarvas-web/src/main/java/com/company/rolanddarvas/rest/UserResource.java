package com.company.rolanddarvas.rest;

import com.company.rolanddarvas.dto.UserDTO;
import com.company.rolanddarvas.exception.SerialisationIncomplete;
import com.company.rolanddarvas.service.UserDB;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.company.rolanddarvas.utility.LoginAssister.adminLogin;

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

    private static final transient Logger LOGGER = Logger.getLogger(UserResource.class.getName());

    @POST
    @Path("/add")
    public UserDTO addUser(@Context HttpServletRequest request, UserDTO user) {
        adminLogin(request);
        userDB.register(user);
        LOGGER.log(Level.INFO, user.getUsername() + " added to the registered user's list!");
        return user;
    }

    @DELETE
    @Path("/remove")
    public UserDTO removeUser(@Context HttpServletRequest request, UserDTO user) {
        adminLogin(request);
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
    public UserDTO login(@Context HttpServletRequest request, UserDTO user) {
        if (userDB.authenticate(user.getUsername(), user.getPassword())) {
            UserDTO loggedUser = userDB.getUser(user.getUsername());
            HttpSession session = request.getSession(false);
            serializeUser(loggedUser);
            session.setAttribute("user", loggedUser);
            LOGGER.log(Level.INFO, loggedUser.getUsername() + " has logged in!");
            return user;
        }
        throw new WebApplicationException("wrong username or password!");
    }

    private void serializeUser(UserDTO loggedUser) {
        byte[] contentInBytes = loggedUser.toString().getBytes();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("loggedUser"))) {
            oos.write(contentInBytes);
            oos.writeObject(loggedUser);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            throw new SerialisationIncomplete("File not found, cant serialize!", ex);
        }
    }
}
