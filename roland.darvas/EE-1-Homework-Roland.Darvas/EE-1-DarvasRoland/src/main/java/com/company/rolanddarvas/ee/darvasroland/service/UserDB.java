package com.company.rolanddarvas.ee.darvasroland.service;

import com.company.rolanddarvas.ee.darvasroland.dto.UserDTO;
import com.company.rolanddarvas.ee.darvasroland.exception.NoSuchUserException;
import com.company.rolanddarvas.ee.darvasroland.exception.UserAlreadyRegistrated;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author darvasr
 */
public class UserDB {

    private Map<String, UserDTO> registeredUser = new HashMap<>();

    public UserDTO register(UserDTO user) {
        if (!registeredUser.containsKey(user.getUsername())) {
            user.setRegistrationDate(new Date(System.currentTimeMillis()));
            registeredUser.put(user.getUsername(), user);
            return user;
        } else {
            throw new UserAlreadyRegistrated("User already in the database!");
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

}
