package com.example.data;

import javax.persistence.*;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@Entity
public class Address {
    private String street;
    private String city;
    private String state;
    private String country;

    @Id
    @GeneratedValue
    private long id;


    public Address() {
    }


    public Address(String street, String city, String state, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "City: " + city + " Street: "+ street + " State: " + state + " Country: " + country;
    }
}
