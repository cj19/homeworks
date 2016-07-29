package com.company.rolanddarvas.service;

import com.company.rolanddarvas.dto.UserDTO;
import com.company.rolanddarvas.exception.NoSuchUserException;
import com.company.rolanddarvas.exception.UserAlreadyRegistered;

import javax.ejb.Singleton;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by darvasr on 2016.07.28..
 */
@Singleton
public class UserDB {

    private Map<String, UserDTO> registeredUser = new HashMap<>();

    public UserDB() {
    }

    public UserDTO register(UserDTO user) {
        if (!registeredUser.containsKey(user.getUsername())) {
            user.setRegistrationDate(new Date(System.currentTimeMillis()));
            registeredUser.put(user.getUsername(), user);
            return user;
        } else {
            throw new UserAlreadyRegistered("User already in the database!");
        }
    }

    public UserDTO getUser(String username) {
        if (registeredUser.containsKey(username)) {
            return registeredUser.get(username);
        } else {
            throw new NoSuchUserException("There is no such user!");
        }
    }

    public boolean authenticate(String username, String password) {
        return registeredUser.containsKey(username)
                && registeredUser.get(username).getPassword().equals(password);

    }

    public boolean remove(String username){
        if (registeredUser.containsKey(username)){
            registeredUser.remove(username);
            return true;
        } else {
            throw new NoSuchUserException("There is no such user!");
        }
    }

    public Map<String, UserDTO> getRegisteredUser() {
        return registeredUser;
    }
}
