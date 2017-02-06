package com.example.data;

import javax.persistence.*;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@Entity
public class Student {
    private Address homeAddress;
    private String name;
    private String email;

    @Id
    @GeneratedValue
    private long id;
}
