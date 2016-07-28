package com.company.rolanddarvas.dto;

import com.company.rolanddarvas.annotation.ValidateBean;
import com.company.rolanddarvas.constraint.ManufacturerWithColor;
import com.company.rolanddarvas.model.Brand;
import com.company.rolanddarvas.model.ColorType;
import com.company.rolanddarvas.model.CurrencyType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Created by CJ on 2016.07.28..
 */
@ManufacturerWithColor
@ValidateBean
public class MobileType {

    @NotNull
    @Pattern(regexp = ".{36}")
    private String id;

    @NotNull
    private Brand manufacturer;

    @Size(min = 3)
    private String type;

    @NotNull
    @Min(1)
    private Double price;

    @NotNull
    private CurrencyType currency;

    @NotNull
    private ColorType color;

    public MobileType() {
        //to create json objects..
    }

    public MobileType(String id, Brand manufacturer, String type, double price, CurrencyType currency, ColorType color) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
        this.currency = currency;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Brand getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Brand manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.manufacturer);
        hash = 73 * hash + Objects.hashCode(this.type);
        hash = 73 * hash + Objects.hashCode(this.price);
        hash = 73 * hash + Objects.hashCode(this.currency);
        hash = 73 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MobileType other = (MobileType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (this.manufacturer != other.manufacturer) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (this.currency != other.currency) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        return true;
    }
}

