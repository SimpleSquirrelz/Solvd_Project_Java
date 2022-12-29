package com.solvd.taxi.transport;

import com.solvd.taxi.bar.Bar;
import com.solvd.taxi.helpers.DriverLicense;
import com.solvd.taxi.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LuxCar extends Car {
    private Bar bar;
    private final Logger logger = LogManager.getLogger(LuxCar.class);

    public LuxCar(){
        super();
        this.bar = new Bar();
        logger.info("Object created: " + this);
    }

    public LuxCar(int capacity, float maxSpeed, List<Customer> passengers, Bar bar) {
        super(capacity, maxSpeed, passengers);
        this.bar = bar;
        logger.info("Object created: " + this);
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return "CasualCar {\n" +
                "capacity=" + getCapacity() + "',\n" +
                ", maxSpeed=" + getMaxSpeed() + "',\n" +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LuxCar luxCar = (LuxCar) object;
        return getCapacity() == luxCar.getCapacity() &&
                Float.compare(luxCar.getMaxSpeed(), getMaxSpeed()) == 0 &&
                bar.equals(luxCar.getBar());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + getCapacity();
        result = prime * result + (int) (getMaxSpeed() * 10);
        result = prime * result + ((bar == null) ? 0 : bar.hashCode());

        return result;
    }
}
