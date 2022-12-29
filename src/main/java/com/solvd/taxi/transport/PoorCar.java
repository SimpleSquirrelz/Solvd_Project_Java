package com.solvd.taxi.transport;

import com.solvd.taxi.people.Customer;
import com.solvd.taxi.sales.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PoorCar extends Car {
    private List<Order> orders;
    private final Logger logger = LogManager.getLogger(PoorCar.class);

    public PoorCar() {
        super();
        this.orders = new ArrayList<>();
        logger.info("Object created: " + this);
    }

    public PoorCar(int capacity, float maxSpeed, List<Customer> passengers, List<Order> orders) {
        super(capacity, maxSpeed, passengers);
        this.orders = orders;
        logger.info("Object created: " + this);
    }

    @Override
    public String toString() {
        return "CasualCar {\n" +
                "capacity=" + getCapacity() + "',\n" +
                ", maxSpeed=" + getMaxSpeed() + "',\n" +
                ", orders=" + orders.toString() + "',\n" +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PoorCar poorCar = (PoorCar) object;
        return getCapacity() == poorCar.getCapacity() &&
                Float.compare(poorCar.getMaxSpeed(), getMaxSpeed()) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + getCapacity();
        result = prime * result + (int) (getMaxSpeed() * 10);
        result = prime * result + ((orders == null) ? 0 : orders.hashCode());

        return result;
    }
}
