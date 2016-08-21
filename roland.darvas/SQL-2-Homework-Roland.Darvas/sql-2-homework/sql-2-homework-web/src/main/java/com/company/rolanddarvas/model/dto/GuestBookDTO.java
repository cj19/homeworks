package com.company.rolanddarvas.model.dto;

/**
 * Created by darvasr on 2016.08.21..
 */
public class GuestBookDTO {

    private String record;

    public GuestBookDTO(String record) {
        this.record = record;
    }

    public GuestBookDTO() {
        //Default constructor
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
