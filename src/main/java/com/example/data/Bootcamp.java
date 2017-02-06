package com.example.data;

import javax.persistence.*;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@Entity
public class Bootcamp {
    private Instructor teacher;
    private String name;
    private String startDay;
    private String endDay;
    private Student students;

    @Id
    @GeneratedValue
    private long id;


}
