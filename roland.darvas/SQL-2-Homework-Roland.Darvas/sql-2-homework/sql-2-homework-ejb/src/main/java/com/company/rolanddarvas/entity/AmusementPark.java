package com.company.rolanddarvas.entity;

import javax.persistence.*;

/**
 * Created by darvasr on 2016.08.19..
 */
@Entity
@Table(name = "AMUSEMENT_PARK")
public class AmusementPark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(targetEntity = Address.class)
    private Address address;

    private Long fund;

    private Long land;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getLand() {
        return land;
    }

    public void setLand(Long land) {
        this.land = land;
    }

}
