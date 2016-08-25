package com.company.rolanddarvas.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

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

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;

    private Long fund;

    private Long land;

    private Long ticketPrice;

    @OneToMany(mappedBy = "currentPark", targetEntity = Visitor.class, cascade = CascadeType.ALL)
    private List<Visitor> visitors;

    @OneToMany(mappedBy = "amusementPark", targetEntity = Machine.class, cascade = CascadeType.ALL)
    private List<Machine> machines;

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

    public Long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @XmlTransient
    public List<Visitor> getVisitors() {
        return visitors;
    }

    @XmlTransient
    public List<Machine> getMachines() {
        return machines;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmusementPark that = (AmusementPark) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!address.equals(that.address)) return false;
        if (!fund.equals(that.fund)) return false;
        if (!land.equals(that.land)) return false;
        return ticketPrice.equals(that.ticketPrice);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + fund.hashCode();
        result = 31 * result + land.hashCode();
        result = 31 * result + ticketPrice.hashCode();
        return result;
    }
}
