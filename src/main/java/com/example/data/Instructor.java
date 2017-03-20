package com.example.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@Entity
public class Instructor {
    private String name;
    private String hireDate;

    @ManyToOne
    private Address homeAddress;

    @ManyToOne
    private Address workAddress;

    @ManyToMany
    private List<Bootcamp> bootCampsTaught;

    @Id
    @GeneratedValue
    private long id;

    public Instructor() {
    }

    public Instructor(String name, String hireDate, Address homeAddress, Address workAddress) {
        this.name = name;
        this.hireDate = hireDate;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;

    }

    public List<Bootcamp> getBootCampsTaught() {
        return bootCampsTaught;
    }

    public void setBootCampsTaught(List<Bootcamp> bootCampsTaught) {
        this.bootCampsTaught = bootCampsTaught;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
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
                ", hireDate='" + hireDate + '\'' +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                ", bootCampsTaught=" + bootCampsTaught +
                ", id=" + id +
                '}';
    }
}
