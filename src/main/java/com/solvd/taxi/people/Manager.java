package com.solvd.taxi.people;

import com.solvd.taxi.sales.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Human {

    private List<Order> orders;
    private final Logger logger = LogManager.getLogger(Manager.class);

    public Manager() {
        super();
        this.orders = new ArrayList<>();
        logger.info("Object created: " + this);
    }

    public Manager(String phoneNumber, String name, String surname, Date birthday, List<Order> orders) {
        super(phoneNumber, name, surname, birthday);
        this.orders = new ArrayList<>(orders);
        logger.info("Object created: " + this);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return String.format("\nMANAGER:\n%s %s\nTel: %s\nBirthday: %s\nOrders: %s",
                getName(), getSurname(), getPhoneNumber(), getBirthday().toString(),orders.toString());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Manager manager = (Manager) object;
        return getPhoneNumber().equals(manager.getPhoneNumber()) &&
                getName().equals(manager.getName()) &&
                getSurname().equals(manager.getSurname()) &&
                getBirthday().equals(manager.getBirthday()) &&
                orders.equals(manager.getOrders());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSurname() == null) ? 0 : getSurname().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + orders.hashCode();

        return result;
    }
}
