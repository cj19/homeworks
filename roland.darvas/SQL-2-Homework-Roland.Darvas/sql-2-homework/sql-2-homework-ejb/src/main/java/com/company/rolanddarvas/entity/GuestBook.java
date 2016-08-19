package com.company.rolanddarvas.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darvasr on 2016.08.19..
 */
@Entity
@Table(name = "GUEST_BOOK")
public class GuestBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = AmusementPark.class)
    private AmusementPark amusementParkId;

    @ManyToOne(targetEntity = Visitor.class)
    private Visitor visitorId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;

    private String record;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AmusementPark getAmusementParkId() {
        return amusementParkId;
    }

    public void setAmusementParkId(AmusementPark amusementParkId) {
        this.amusementParkId = amusementParkId;
    }

    public Visitor getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Visitor visitorId) {
        this.visitorId = visitorId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
