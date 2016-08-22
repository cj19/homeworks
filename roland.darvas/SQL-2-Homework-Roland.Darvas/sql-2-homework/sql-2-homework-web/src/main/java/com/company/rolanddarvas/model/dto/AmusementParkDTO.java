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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmusementParkDTO that = (AmusementParkDTO) o;

        if (!name.equals(that.name)) return false;
        if (!address.equals(that.address)) return false;
        if (!fund.equals(that.fund)) return false;
        if (!ticketPrice.equals(that.ticketPrice)) return false;
        return land.equals(that.land);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + fund.hashCode();
        result = 31 * result + ticketPrice.hashCode();
        result = 31 * result + land.hashCode();
        return result;
    }
}
