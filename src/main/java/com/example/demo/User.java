package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "userinfo")
public class User {

    public User() {}

    public User(String name, String password, Integer credits) {
        this.name = name;
        this.password = password;
        this.credits = credits;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    public String name;
    private String password;
    private Integer credits;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getCredits() {
        return credits;
    }


    public void setName(String newName) {
        this.name = newName;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setCredits(Integer newCredits) {
        this.credits = newCredits;
    }
}
