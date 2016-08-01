package com.company.rolanddarvas.utility;

import com.company.rolanddarvas.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ForbiddenException;

/**
 * Created by darvasr on 2016.08.01..
 */
public class Session {

    public static final String USER_SESSION_ATTRIBUTE = "user";

    private Session() {
        // not to instantiate
    }

    public static void validateAdminLogin(HttpServletRequest request) {
        if (!validateUserLogin(request).isAdmin()) {
            request.getSession().invalidate();
            throw new ForbiddenException("not logged in as admin");
        }
    }

    public static UserDTO validateUserLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userObject = session.getAttribute(USER_SESSION_ATTRIBUTE);
        if ((userObject != null) && (userObject instanceof UserDTO)) {
            return (UserDTO) userObject;
        }
        session.invalidate();
        throw new ForbiddenException("user not logged in");
    }
}