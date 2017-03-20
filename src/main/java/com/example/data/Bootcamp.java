package com.example.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@Entity
public class Bootcamp {
    private String name;
    private String startDay;
    private String endDay;

    @OneToMany
    private List<Instructor> teachers;

    @OneToMany
    private List<Student> students;

    @Id
    @GeneratedValue
    private long id;

    public Bootcamp() {
    }

    public Bootcamp(String name, String startDay, String endDay) {
        this.name = name;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public Bootcamp(String name, String startDay, String endDay, List<Instructor> teachers, List<Student> students) {
        this.name = name;
        this.startDay = startDay;
        this.endDay = endDay;
        this.teachers = teachers;
        this.students = students;
    }

    public List<Instructor> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Instructor> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bootcamp" +
                "name='" + name + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", teachers=" + teachers +
                ", students=" + students +
                ", id=" + id +
                '}';
    }
}
