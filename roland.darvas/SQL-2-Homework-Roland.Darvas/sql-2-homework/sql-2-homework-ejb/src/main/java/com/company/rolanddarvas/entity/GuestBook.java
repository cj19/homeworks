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

    @ManyToOne(targetEntity = AmusementPark.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "amusement_park_id")
    private AmusementPark amusementParkId;

    @ManyToOne(targetEntity = Visitor.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor_id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GuestBook guestBook = (GuestBook) o;
        if (!id.equals(guestBook.id)) return false;
        if (!amusementParkId.equals(guestBook.amusementParkId)) return false;
        if (!visitorId.equals(guestBook.visitorId)) return false;
        if (!recordDate.equals(guestBook.recordDate)) return false;
        return record.equals(guestBook.record);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + amusementParkId.hashCode();
        result = 31 * result + visitorId.hashCode();
        result = 31 * result + recordDate.hashCode();
        result = 31 * result + record.hashCode();
        return result;
    }
}
