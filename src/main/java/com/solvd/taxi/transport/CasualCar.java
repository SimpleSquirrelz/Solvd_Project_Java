package com.solvd.taxi.transport;

import com.solvd.taxi.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class CasualCar extends Car {
    private final Logger logger = LogManager.getLogger(CasualCar.class);

    public CasualCar() {
        super();
        logger.info("Casual car created: " + this);
    }

    public CasualCar(int capacity, float maxSpeed, List<Customer> passengers) {
        super(capacity, maxSpeed, passengers);
        logger.info("Casual car created: " + this);
    }

    @Override
    public String toString() {
        return String.format("\nCASUAL Car:\nMax speed: %s\nCapacity: %s\nPassengers: %s",
                getMaxSpeed(), getMaxSpeed(),getPassengers().toString());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CasualCar casualCar = (CasualCar) object;
        return getCapacity() == casualCar.getCapacity() &&
                Float.compare(casualCar.getMaxSpeed(), getMaxSpeed()) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + getCapacity();
        result = prime * result + (int) (getMaxSpeed() * 10);

        return result;
    }
}
