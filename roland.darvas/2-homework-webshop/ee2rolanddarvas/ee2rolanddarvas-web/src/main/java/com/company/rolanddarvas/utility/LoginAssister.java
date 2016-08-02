package com.company.rolanddarvas.utility;

import com.company.rolanddarvas.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ForbiddenException;

/**
 * Created by darvasr on 2016.08.01..
 */
public class LoginAssister {

    public static final String USER_SESSION_ATTRIBUTE = "user";

    private LoginAssister() {
        // not to instantiate
    }

    public static void adminLogin(HttpServletRequest request) {
        if (!userLogin(request).isAdmin()) {
            request.getSession().invalidate();
            throw new ForbiddenException("not logged in as admin");
        }
    }

    public static UserDTO userLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userObject = session.getAttribute(USER_SESSION_ATTRIBUTE);
        if ((userObject != null) && (userObject instanceof UserDTO)) {
            return (UserDTO) userObject;
        }
        session.invalidate();
        throw new ForbiddenException("user not logged in");
    }
}