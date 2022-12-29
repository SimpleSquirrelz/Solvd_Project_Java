package com.solvd.taxi.transport;

import com.solvd.taxi.exceptions.CapacityOverflowException;
import com.solvd.taxi.exceptions.EmptyInputException;
import com.solvd.taxi.exceptions.UnsuitableDataTypeException;
import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.interfaces.IDrivable;
import com.solvd.taxi.interfaces.IStorable;
import com.solvd.taxi.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Car implements IDrivable, IStorable {

    private List<Customer> passengers;
    private int capacity;
    private float maxSpeed;
    private final Logger logger = LogManager.getLogger(Car.class);


    public Car() {
        this.capacity = 0;
        this.maxSpeed = 0;
        this.passengers = new ArrayList<>();
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
//        } else if (!(objects.get(0) instanceof Customer)) {
//            logger.error("Unsuitable object in list was found!");
//            throw new UnsuitableDataTypeException();
//        } else {
//            this.getPassengers().addAll(objects.stream().map(obj -> ((Customer) obj)).toList());
//        }
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
