package com.example.data;

import javax.persistence.*;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@Entity
public class Company {
    private String name;
    private String phone;
    private Address workAddress;
    private Instructor teachers;
    private Bootcamp bootcamps;

    @OneToOne
    // company can reference to an teacher


    @Id
    @GeneratedValue
    private long id;

  }
