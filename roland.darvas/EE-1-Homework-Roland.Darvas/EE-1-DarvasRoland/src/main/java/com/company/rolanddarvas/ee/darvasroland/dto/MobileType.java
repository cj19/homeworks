package com.company.rolanddarvas.ee.darvasroland.dto;

import com.company.rolanddarvas.ee.darvasroland.constraint.ManufacturerWithColor;
import com.company.rolanddarvas.ee.darvasroland.model.ColorType;
import com.company.rolanddarvas.ee.darvasroland.model.CurrencyType;
import com.company.rolanddarvas.ee.darvasroland.model.Brand;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author darvasr
 */
@ManufacturerWithColor
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

}
