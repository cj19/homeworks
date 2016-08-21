package com.company.rolanddarvas.model.dto;

import com.company.rolanddarvas.entity.Address;

/**
 * Created by darvasr on 2016.08.21..
 */
public class AmusementParkDTO {

    private String name;

    private Address address;

    private Long fund;

    private Long ticketPrice;

    private Long land;

    public AmusementParkDTO(String name, Address address, Long fund, Long ticketPrice, Long land) {
        this.name = name;
        this.address = address;
        this.fund = fund;
        this.ticketPrice = ticketPrice;
        this.land = land;
    }

    public AmusementParkDTO() {
        //default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getFund() {
        return fund;
    }

    public void setFund(Long fund) {
        this.fund = fund;
    }

    public Long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Long getLand() {
        return land;
    }

    public void setLand(Long land) {
        this.land = land;
    }
}
