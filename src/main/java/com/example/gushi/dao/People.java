package com.example.gushi.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class People implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "pass_word")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Column(name = "qq")
    private String qq;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
