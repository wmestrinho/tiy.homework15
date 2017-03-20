package com.example.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@Entity
public class Company {
    private String name;
    private String phone;

    @ManyToOne
    private Address workAddress;

    @OneToOne
    private Bootcamp bootcamps;

    @OneToMany
    private List<Instructor> teachers;

    @Id
    @GeneratedValue
    private long id;

    public Company() {
    }

    public Company(String name, String phone, Address workAddress, Bootcamp bootcamps, List<Instructor> teachers) {
        this.name = name;
        this.phone = phone;
        this.workAddress = workAddress;
        this.bootcamps = bootcamps;
        this.teachers = teachers;
    }

    public List<Instructor> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Instructor> teachers) {
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public Bootcamp getBootcamps() {
        return bootcamps;
    }

    public void setBootcamps(Bootcamp bootcamps) {
        this.bootcamps = bootcamps;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", workAddress=" + workAddress +
                ", bootcamps=" + bootcamps +
                ", teachers=" + teachers +
                ", id=" + id +
                '}';
    }
}
