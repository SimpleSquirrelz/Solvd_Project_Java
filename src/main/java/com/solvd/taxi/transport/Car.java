package com.solvd.taxi.transport;

import com.solvd.taxi.enums.CarClass;
import com.solvd.taxi.exceptions.CapacityOverflowException;
import com.solvd.taxi.exceptions.EmptyInputException;
import com.solvd.taxi.exceptions.UnsuitableDataTypeException;
import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.interfaces.IDrivable;
import com.solvd.taxi.interfaces.IStorable;
import com.solvd.taxi.people.Customer;
import com.solvd.taxi.people.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Car implements IDrivable, IStorable {

    private List<Customer> passengers;
    private Driver driver = null;
    private int capacity;
    private float maxSpeed;
    private final Logger logger = LogManager.getLogger(Car.class);


    public Car() {
        this.capacity = 0;
        this.maxSpeed = 0;
        this.passengers = new ArrayList<>();
        this.driver = new Driver();
    }

    public Car(int capacity, float maxSpeed, List<Customer> passengers) {
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.passengers = new ArrayList<>(passengers);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public List<Customer> getPassengers() {
        return passengers;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public CarClass getCarClass() {
        var carClass = this.getClass().getName();
        return carClass.equals("PoorCar") ? CarClass.POOR :
                carClass.equals("CasualCar") ? CarClass.CASUAL : CarClass.LUX;
    }

    @Override
    public final void pickUp(List<Object> objects) throws CapacityOverflowException, UnsuitableDataTypeException, EmptyInputException {
        if (this.getCapacity() < this.getPassengers().size() + objects.size()) {
            logger.error("Capacity overflow!");
            throw new CapacityOverflowException();
        }
        else if (objects.size() == 0) {
            logger.error("Empty input value error!");
            throw new EmptyInputException();
        }
    }
    public final void pickUp(Customer customer) throws CapacityOverflowException {
        if (this.getCapacity() < this.getPassengers().size() + 1) {
            logger.error("Capacity overflow!");
            throw new CapacityOverflowException();
        }
        else if (customer == null) {
            logger.error("Null pointer exception!");
            throw new NullPointerException();
        } else {
            this.getPassengers().add(customer);
        }
    }

    @Override
    public void dropOff(List<Object> object) {

    }

    @Override
    public void drive(Location targetLocation) {
        var pas = this.getPassengers();
        pas.stream().peek(customer -> customer.setLocation(targetLocation));
    }
}
