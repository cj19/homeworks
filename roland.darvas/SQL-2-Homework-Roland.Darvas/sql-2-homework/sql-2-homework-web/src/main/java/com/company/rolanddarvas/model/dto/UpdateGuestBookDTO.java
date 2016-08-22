package com.company.rolanddarvas.model.dto;

/**
 * Created by darvasr on 2016.08.21..
 */
public class UpdateGuestBookDTO {

    private Long parkId;

    private Long visitorId;

    private String record;

    public UpdateGuestBookDTO() {
        //default constructor
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateGuestBookDTO that = (UpdateGuestBookDTO) o;

        if (!parkId.equals(that.parkId)) return false;
        if (!visitorId.equals(that.visitorId)) return false;
        return record.equals(that.record);

    }

    @Override
    public int hashCode() {
        int result = parkId.hashCode();
        result = 31 * result + visitorId.hashCode();
        result = 31 * result + record.hashCode();
        return result;
    }
}


