package com.company.rolanddarvas.model.dto;

/**
 * Created by darvasr on 2016.08.21..
 */
public class AddressDTO {

    private String postcode;

    private String country;

    private String city;

    private String street;

    private String houseNumber;

    public AddressDTO(String postcode, String country, String city, String street, String houseNumber) {
        this.postcode = postcode;
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public AddressDTO() {
        //Default constructor
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddressDTO that = (AddressDTO) o;
        if (!postcode.equals(that.postcode)) {
            return false;
        }
        if (!country.equals(that.country)) {
            return false;
        }
        if (!city.equals(that.city)) {
            return false;
        }
        if (!street.equals(that.street)) {
            return false;
        }
        return houseNumber.equals(that.houseNumber);

    }

    @Override
    public int hashCode() {
        int result = postcode.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + houseNumber.hashCode();
        return result;
    }
}


