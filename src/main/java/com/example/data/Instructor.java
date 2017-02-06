package com.example.data;

import javax.persistence.*;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@Entity
public class Instructor {
    private String name;
    private Address homeAddress;
    private Address workAddress;
    private String hireDate;
    private Bootcamp bootCampsTaught;

    @Id
    @GeneratedValue
    private long id;
}
