package com.solvd.taxi.people;

import com.solvd.taxi.exceptions.InsufficientBalanceException;
import com.solvd.taxi.helpers.DriverLicense;
import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.interfaces.ISolvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class Driver extends Human implements ISolvent {
    private Location location;
    private DriverLicense driverLicense;
    private float balance;
    private final Logger logger = LogManager.getLogger(Driver.class);

    public Driver() {
        super();
        this.location = new Location();
        this.driverLicense = new DriverLicense();
        this.balance = 0.0f;
        logger.info("Object created: " + this);
    }

    public Driver(String phoneNumber,
                  String name,
                  String surname,
                  Date birthday,
                  float balance,
                  Location location,
                  DriverLicense driverLicense) {
        super(phoneNumber, name, surname, birthday);
        this.balance = balance;
        this.location = location;
        this.driverLicense = driverLicense;
        logger.info("Object created: " + this);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public void pay(Human human, float amount) throws InsufficientBalanceException {
        if (this.getBalance() - amount < 0) {
            logger.error("Driver payment ERROR");
            throw new InsufficientBalanceException();
        }
        else {
            ((Customer) human).receiveMoney(amount);
            this.balance -= amount;
        }
        logger.info("Driver paid '" + amount + "$'");
    }

    @Override
    public void receiveMoney(float amount) {
        this.balance += amount;
        logger.info("Driver received '" + amount + "$'");
    }


    @Override
    public String toString() {
        return "Driver {\n" +
                "location=" + location.toString() + "',\n" +
                ", driverLicense=" + driverLicense.toString() + "',\n" +
                ", phoneNumber='" + getPhoneNumber() + "',\n" +
                ", name='" + getName() + "',\n" +
                ", surname='" + getSurname() + "',\n" +
                ", birthday=" + getBirthday().toString() + "',\n" +
                ", balance='" + balance +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Driver driver = (Driver) object;
        return Float.compare(driver.balance, balance) == 0 &&
                location.equals(driver.location) &&
                driverLicense.equals(driver.driverLicense) &&
                getPhoneNumber().equals(driver.getPhoneNumber()) &&
                getName().equals(driver.getName()) &&
                getSurname().equals(driver.getSurname()) &&
                getBirthday().equals(driver.getBirthday());
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSurname() == null) ? 0 : getSurname().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((driverLicense == null) ? 0 : driverLicense.hashCode());
        result = prime * result + (int) (balance * 10);

        return result;
    }
}
