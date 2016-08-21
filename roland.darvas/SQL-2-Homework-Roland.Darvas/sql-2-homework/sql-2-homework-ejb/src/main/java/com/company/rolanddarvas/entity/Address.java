package com.company.rolanddarvas.entity;

import javax.persistence.*;

/**
 * Created by darvasr on 2016.08.19..
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postcode;

    private String country;

    private String city;

    private String street;

    private String houseNumber;

    public Address() {
        //default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Address address = (Address) o;
        if (!id.equals(address.id)) {
            return false;
        }
        if (!postcode.equals(address.postcode)) {
            return false;
        }
        if (!country.equals(address.country)) {
            return false;
        }
        if (!city.equals(address.city)) {
            return false;
        }
        if (!street.equals(address.street)) {
            return false;
        }
        return houseNumber.equals(address.houseNumber);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + postcode.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + houseNumber.hashCode();
        return result;
    }
}
