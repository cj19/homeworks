package com.company.rolanddarvas.model.dto;

import com.company.rolanddarvas.entity.Visitor;

import java.util.List;

/**
 * Created by darvasr on 2016.08.21..
 */
public class VisitorListDTO {

    private List<Visitor> visitors;

    public VisitorListDTO(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public VisitorListDTO() {
        //Default constructor
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }
}
