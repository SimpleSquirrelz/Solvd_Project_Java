package com.solvd.taxi.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Operator extends Human {
    private Queue<Customer> customerCalls;
    private final Logger logger = LogManager.getLogger(Operator.class);

    public Operator() {
        super();
        customerCalls = new LinkedList<>();
    }

    public Operator(String phoneNumber, String name, String surname, Date birthday, Queue<Customer> customerCalls) {
        super(phoneNumber, name, surname, birthday);
        this.customerCalls = new LinkedList<>(customerCalls);
        logger.info("Object created: " + this);

    }

    public Queue<Customer> getCustomerCalls() {
        return new LinkedList<>(customerCalls);
    }

    public void setCustomerCalls(Queue<Customer> customerCalls) {
        this.customerCalls = new LinkedList<>(customerCalls);
    }

    @Override
    public String toString() {
        return "Operator {\n" +
                ", customerCalls=[" + customerCalls.stream().map(el -> el.getName() + " " + el.getSurname() + " " + el.getPhoneNumber()).collect(Collectors.joining(" | ")) +
                "],\n phoneNumber='" + getPhoneNumber() + "',\n" +
                ", name='" + getName() + "',\n" +
                ", surname='" + getSurname() + "',\n" +
                ", birthday=" + getBirthday() + "',\n" +
                '}';
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
}
