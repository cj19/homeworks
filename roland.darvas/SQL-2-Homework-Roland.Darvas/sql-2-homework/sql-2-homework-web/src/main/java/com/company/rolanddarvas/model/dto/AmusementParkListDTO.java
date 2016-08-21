package com.company.rolanddarvas.model.dto;

import com.company.rolanddarvas.entity.AmusementPark;

import java.util.List;

/**
 * Created by darvasr on 2016.08.21..
 */
public class AmusementParkListDTO {

    private List<AmusementPark> amusementParks;

    public AmusementParkListDTO(List<AmusementPark> amusementParks) {
        this.amusementParks = amusementParks;
    }

    public List<AmusementPark> getAmusementParks() {
        return amusementParks;
    }

    public AmusementParkListDTO() {
        //Default constructor
    }

    public void setAmusementParks(List<AmusementPark> amusementParks) {
        this.amusementParks = amusementParks;
    }
}
