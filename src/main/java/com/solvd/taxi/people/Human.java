package com.solvd.taxi.people;

import java.util.Calendar;
import java.util.Date;

public abstract class Human {
    private String phoneNumber;
    private String name;
    private String surname;
    private Date birthday;

    public Human() {
        this.phoneNumber = "+00 000 000 00 00";
        this.name = "NoName";
        this.surname = "NoSurname";
        this.birthday = new Date(1900, Calendar.JANUARY,1);
    }

    public Human(String phoneNumber, String name, String surname, Date birthday) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
