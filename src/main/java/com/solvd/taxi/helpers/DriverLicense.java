package com.solvd.taxi.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public final class DriverLicense {
    private final String name;
    private final String surname;
    private final Date birthday;
    private final Date issueDate;
    private final Date expirationDate;
    private final String licenseNumber;
    private final Logger logger = LogManager.getLogger(DriverLicense.class);

    public DriverLicense() {
        this.name = "NoName";
        this.surname = "NoSurname";
        this.birthday = new Date(1900, Calendar.JANUARY, 1);
        this.issueDate = new Date(1900, Calendar.JANUARY, 1);
        this.expirationDate = new Date(1900, Calendar.JANUARY, 1);
        this.licenseNumber = "None";
        logger.info("Object created: " + this);
    }

    public DriverLicense(String name, String surname, Date birthday, Date issueDate, Date expirationDate, String licenseNumber) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.licenseNumber = licenseNumber;
        logger.info("Object created: " + this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public String toString() {
        return "DriverLicense {\n" +
                "name='" + name + "',\n" +
                ", surname='" + surname + "',\n" +
                ", birthday=" + birthday.toString() + "',\n" +
                ", issueDate=" + issueDate.toString() + "',\n" +
                ", expirationDate=" + expirationDate.toString() + "',\n" +
                ", licenseNumber='" + licenseNumber + "',\n" +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        DriverLicense that = (DriverLicense) object;
        return name.equals(that.name) &&
                surname.equals(that.surname) &&
                birthday.equals(that.birthday) &&
                issueDate.equals(that.issueDate) &&
                expirationDate.equals(that.expirationDate) &&
                licenseNumber.equals(that.licenseNumber);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
        result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
        result = prime * result + ((licenseNumber == null) ? 0 : licenseNumber.hashCode());

        return result;
    }
}
