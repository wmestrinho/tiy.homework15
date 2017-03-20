package com.example.data;

import javax.persistence.*;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@Entity
public class Student {
    private String name;
    private String email;

    @ManyToOne
    private Address homeAddress;

    @Id
    @GeneratedValue
    private long id;

    public Student() {
    }

    public Student(String name, String email, Address homeAddress) {
        this.name = name;
        this.email = email;
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", homeAddress=" + homeAddress +
                ", id=" + id +
                '}';
    }
}
