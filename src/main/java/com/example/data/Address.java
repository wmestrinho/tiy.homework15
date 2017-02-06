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

}
