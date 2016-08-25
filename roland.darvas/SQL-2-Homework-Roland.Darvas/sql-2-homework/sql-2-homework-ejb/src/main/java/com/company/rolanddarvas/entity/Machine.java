package com.company.rolanddarvas.entity;

import com.company.rolanddarvas.model.MachineType;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by darvasr on 2016.08.19..
 */
@Entity
@Table(name = "MACHINE")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fancyName;

    private Long size;

    private Long price;

    private Long ticketPrice;

    private Long requiredSpace;

    private Integer freeSpace;

    @Enumerated(EnumType.STRING)
    private MachineType type;

    private Integer ageLimit;

    private Boolean closed;

    @ManyToOne(targetEntity = AmusementPark.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "amusement_park_id")
    private AmusementPark amusementPark;

    @OneToMany(mappedBy = "currentMachine", targetEntity = Visitor.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Visitor> visitors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFancyName() {
        return fancyName;
    }

    public void setFancyName(String fancyName) {
        this.fancyName = fancyName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Integer freeSpace) {
        this.freeSpace = freeSpace;
    }

    public Long getRequiredSpace() {
        return requiredSpace;
    }

    public void setRequiredSpace(Long space) {
        this.requiredSpace = space;
    }

    public MachineType getType() {
        return type;
    }

    public void setType(MachineType type) {
        this.type = type;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public AmusementPark getAmusementPark() {
        return amusementPark;
    }

    public void setAmusementPark(AmusementPark amusementParkId) {
        this.amusementPark = amusementParkId;
    }

    @XmlTransient
    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public Boolean isClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public boolean hasNoVisitorsOn() {
        return getVisitors().isEmpty();
    }

    public boolean hasAmusementPark() {
        return amusementPark != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Machine machine = (Machine) o;

        if (!id.equals(machine.id)) return false;
        if (!fancyName.equals(machine.fancyName)) return false;
        if (!size.equals(machine.size)) return false;
        if (!price.equals(machine.price)) return false;
        if (!ticketPrice.equals(machine.ticketPrice)) return false;
        if (!requiredSpace.equals(machine.requiredSpace)) return false;
        if (!freeSpace.equals(machine.freeSpace)) return false;
        if (type != machine.type) return false;
        if (!ageLimit.equals(machine.ageLimit)) return false;
        if (!closed.equals(machine.closed)) return false;
        return amusementPark.equals(machine.amusementPark);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + fancyName.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + ticketPrice.hashCode();
        result = 31 * result + requiredSpace.hashCode();
        result = 31 * result + freeSpace.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + ageLimit.hashCode();
        result = 31 * result + closed.hashCode();
        result = 31 * result + amusementPark.hashCode();
        return result;
    }
}
