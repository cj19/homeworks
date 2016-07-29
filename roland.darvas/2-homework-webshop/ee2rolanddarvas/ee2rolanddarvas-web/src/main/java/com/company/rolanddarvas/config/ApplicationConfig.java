package com.company.rolanddarvas.config;

import com.company.rolanddarvas.rest.UserResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by darvasr on 2016.07.28..
 */
@ApplicationPath("/web")
public class ApplicationConfig extends Application{


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(UserResource.class);
    }
}
