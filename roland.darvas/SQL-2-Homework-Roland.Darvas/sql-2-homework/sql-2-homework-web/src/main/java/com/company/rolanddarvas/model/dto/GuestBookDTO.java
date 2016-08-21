package com.company.rolanddarvas.model.dto;

/**
 * Created by darvasr on 2016.08.21..
 */
public class GuestBookDTO {

    private Long amusementParkId;

    private Long visitorId;

    private String record;

    public GuestBookDTO(String record) {
        this.record = record;
    }

    public GuestBookDTO() {
        //Default constructor
    }

    public Long getAmusementParkId() {
        return amusementParkId;
    }

    public void setAmusementParkId(Long amusementParkId) {
        this.amusementParkId = amusementParkId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
