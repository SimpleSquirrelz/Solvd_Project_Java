package com.solvd.taxi.people;

import com.solvd.taxi.enums.CarClass;
import com.solvd.taxi.helpers.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Operator extends Human {
    private Queue<Customer> customerCalls;

    private static final int MAX_PRICE = 500;
    private static final int MIN_PRICE = 20;
    private final Logger logger = LogManager.getLogger(Operator.class);

    public Operator() {
        super();
        customerCalls = new LinkedList<>();
        logger.info("Operator created: " + this);
    }

    public Operator(String phoneNumber, String name, String surname, Date birthday, Queue<Customer> customerCalls) {
        super(phoneNumber, name, surname, birthday);
        this.customerCalls = new LinkedList<>(customerCalls);
        logger.info("Operator created: " + this);

    }

    public Queue<Customer> getCustomerCalls() {
        return new PriorityQueue<>(customerCalls);
    }

    public void setCustomerCalls(Queue<Customer> customerCalls) {
        this.customerCalls = new LinkedList<>(customerCalls);
    }

    public void addCustomerCalls(Queue<Customer> customerCalls) {
        this.customerCalls.addAll(customerCalls);
    }

    public void addCustomerCalls(Customer customerCall) {
        this.customerCalls.add(customerCall);
    }

    @Override
    public String toString() {
        return String.format("\nOPERATOR:\n%s %s\nTel: %s\nBirthday: %s\nCustomer calls: %s",
                getName(), getSurname(), getPhoneNumber(), getBirthday().toString(),
                customerCalls.stream().map(el -> el.getName() + " " + el.getSurname() + " " + el.getPhoneNumber()).collect(Collectors.joining(" | ")));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Operator operator = (Operator) object;
        return getPhoneNumber().equals(operator.getPhoneNumber()) &&
                getName().equals(operator.getName()) &&
                getSurname().equals(operator.getSurname()) &&
                getBirthday().equals(operator.getBirthday());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSurname() == null) ? 0 : getSurname().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + customerCalls.hashCode();

        return result;
    }

    public static float countPrice(Location locationFrom, Location locationTo, CarClass carClass) {
        int locationFromNum = Arrays.stream(locationFrom.toString().replace(", ", "").split("")).mapToInt(el -> el.charAt(0)).sum();
        int locationToNum = Arrays.stream(locationTo.toString().replace(", ", "").split("")).mapToInt(el -> el.charAt(0)).sum();

        Random random = new Random(Math.abs(locationToNum - locationFromNum));

        return (random.nextInt(MAX_PRICE) + MIN_PRICE) + (carClass.getValue());
    }
}
