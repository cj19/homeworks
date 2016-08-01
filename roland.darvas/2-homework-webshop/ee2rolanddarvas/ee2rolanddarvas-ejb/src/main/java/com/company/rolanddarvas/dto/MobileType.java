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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileType that = (MobileType) o;

        if (!id.equals(that.id)) return false;
        if (manufacturer != that.manufacturer) return false;
        if (!type.equals(that.type)) return false;
        if (!price.equals(that.price)) return false;
        if (currency != that.currency) return false;
        return color == that.color;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + currency.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}

