package com.company.rolanddarvas.model.dto;

import com.company.rolanddarvas.model.MachineType;

/**
 * Created by darvasr on 2016.08.21..
 */
public class MachineDTO {

    private String fancyName;

    private Long size;

    private Long price;

    private Long ticketPrice;

    private Long requiredSpace;

    private Integer freeSpace;

    private Integer ageLimit;

    private MachineType type;

    private Boolean closed;

    public MachineDTO() {
        //Default constructor
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

    public Long getRequiredSpace() {
        return requiredSpace;
    }

    public void setRequiredSpace(Long requiredSpace) {
        this.requiredSpace = requiredSpace;
    }

    public Integer getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Integer freeSpace) {
        this.freeSpace = freeSpace;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public MachineType getType() {
        return type;
    }

    public void setType(MachineType type) {
        this.type = type;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        MachineDTO that = (MachineDTO) o;
        if (!fancyName.equals(that.fancyName)){
            return false;
        }
        if (!size.equals(that.size)) {
            return false;
        }
        if (!price.equals(that.price)) {
            return false;
        }
        if (!ticketPrice.equals(that.ticketPrice)){
            return false;
        }
        if (!requiredSpace.equals(that.requiredSpace)){
            return false;
        }
        if (!freeSpace.equals(that.freeSpace)){
            return false;
        }
        if (!ageLimit.equals(that.ageLimit)){
            return false;
        }
        if (type != that.type){
            return false;
        }
        return closed.equals(that.closed);
    }

    @Override
    public int hashCode() {
        int result = fancyName.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + ticketPrice.hashCode();
        result = 31 * result + requiredSpace.hashCode();
        result = 31 * result + freeSpace.hashCode();
        result = 31 * result + ageLimit.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + closed.hashCode();
        return result;
    }
}
