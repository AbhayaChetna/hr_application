package com.example.hr_application.employee;

import com.example.hr_application.address.Address;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String job;
    private int score;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee(String name, String job, int score) {
        this.name = name;
        this.job = job;
        this.score = score;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

