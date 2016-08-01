package com.company.rolanddarvas.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by darvasr on 2016.07.28..
 */
@ApplicationPath("app")
public class ApplicationConfig extends Application{


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.company.rolanddarvas.exception.GeneralExceptionMapper.class);
        resources.add(com.company.rolanddarvas.exception.PermissionDeniedMapper.class);
        resources.add(com.company.rolanddarvas.rest.CartResource.class);
        resources.add(com.company.rolanddarvas.rest.MobileInventoryResource.class);
        resources.add(com.company.rolanddarvas.rest.MobileTypeResource.class);
        resources.add(com.company.rolanddarvas.rest.UserResource.class);
    }
}
