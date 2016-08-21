package com.company.rolanddarvas.model.dto;

/**
 * Created by darvasr on 2016.08.21..
 */
public class VisitorReportDTO {

    private Long count;

    public VisitorReportDTO(Long count) {
        this.count = count;
    }

    public VisitorReportDTO() {
        //Default constructor
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
