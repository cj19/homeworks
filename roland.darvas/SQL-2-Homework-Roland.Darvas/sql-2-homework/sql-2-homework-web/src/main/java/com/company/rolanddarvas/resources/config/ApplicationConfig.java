package com.company.rolanddarvas.resources.config;

import com.company.rolanddarvas.exception.mapper.CodedCustomExceptionMapper;
import com.company.rolanddarvas.exception.mapper.GeneralExceptionMapper;
import com.company.rolanddarvas.resources.rest.AmusementParkResource;
import com.company.rolanddarvas.resources.rest.GuestBookResource;
import com.company.rolanddarvas.resources.rest.MachineResource;
import com.company.rolanddarvas.resources.rest.VisitorResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by darvasr on 2016.08.21..
 */
@ApplicationPath("app")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        addRestResources(resources);
        return Collections.unmodifiableSet(resources);
    }

    private void addRestResources(Set<Class<?>> resources) {
        resources.add(GeneralExceptionMapper.class);
        resources.add(CodedCustomExceptionMapper.class);
        resources.add(AmusementParkResource.class);
        resources.add(GuestBookResource.class);
        resources.add(MachineResource.class);
        resources.add(VisitorResource.class);
    }
}
