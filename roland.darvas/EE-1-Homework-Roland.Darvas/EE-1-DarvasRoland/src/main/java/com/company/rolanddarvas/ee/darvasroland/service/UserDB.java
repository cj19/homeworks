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

    private Map<String, UserDTO> registratedUsers = new HashMap<>();

    public UserDTO registrate(UserDTO user) {
        if (!registratedUsers.containsKey(user.getUsername())) {
            user.setRegistrationDate(new Date(System.currentTimeMillis()));
            registratedUsers.put(user.getUsername(), user);
            return user;
        } else {
            throw new UserAlreadyRegistrated("User already in the database!");
        }
    }

    public UserDTO getUser(String username) {
        if (registratedUsers.containsKey(username)) {
            return registratedUsers.get(username);
        } else {
            throw new NoSuchUserException("There is no such user!");
        }
    }

    public boolean authenticate(String username, String password) {
        return registratedUsers.containsKey(username)
                && registratedUsers.get(username).getPassword().equals(password);

    }

}
