package com.solvd.taxi.people;

import com.solvd.taxi.exceptions.InsufficientBalanceException;
import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.interfaces.ISolvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class Customer extends Human implements ISolvent {
    private Location location;
    private float balance;
    private final Logger logger = LogManager.getLogger(Customer.class);


    public Customer() {
        super();
        this.location = new Location();
        logger.info("Object created: " + this);
    }

    public Customer(String phoneNumber, String name, String surname, Date birthday, float balance, Location location) {
        super(phoneNumber, name, surname, birthday);
        this.location = location;
        this.balance = balance;
        logger.info("Object created: " + this);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    @Override
    public void pay(Human human, float amount) throws InsufficientBalanceException {
        if(this.getBalance() - amount < 0) {
            logger.error("Customer payment ERROR");
            throw new InsufficientBalanceException();
        }
        else {
            ((Driver) human).receiveMoney(amount);
            this.balance -= amount;
        }
        logger.info("Customer paid '" + amount + "$'");
    }

    @Override
    public void receiveMoney(float amount) {
        this.balance += amount;
        logger.info("Customer received '" + amount + "$'");
    }

    @Override
    public String toString() {
        return "Customer {\n" +
                "location=" + location.toString() + "\n" +
                ", phoneNumber='" + getPhoneNumber() + "',\n" +
                ", name='" + getName() + "',\n" +
                ", surname='" + getSurname() + "',\n" +
                ", birthday='" + getBirthday().toString() + "',\n" +
                ", balance='" + balance +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Customer customer = (Customer) object;
        return Float.compare(customer.balance, balance) == 0 &&
                location.equals(customer.location) &&
                getPhoneNumber().equals(customer.getPhoneNumber()) &&
                getName().equals(customer.getName()) &&
                getSurname().equals(customer.getSurname()) &&
                getBirthday().equals(customer.getBirthday());
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
        result = prime * result + (int) (balance * 10);

        return result;
    }
}
