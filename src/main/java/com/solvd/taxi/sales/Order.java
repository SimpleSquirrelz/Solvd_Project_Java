package com.solvd.taxi.sales;

import com.solvd.taxi.enums.OrderStatus;
import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.people.Customer;
import com.solvd.taxi.people.Driver;
import com.solvd.taxi.people.Operator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Order {
    private Customer customer;
    private Driver driver;
    private Operator operator;
    private Location pickup;
    private Location destination;
    private float price;
    private static int amount = 0;
    private final Logger logger = LogManager.getLogger(Order.class);
    private OrderStatus orderStatus = OrderStatus.OPENED;

    public Order() {
        this.customer = new Customer();
        this.driver = new Driver();
        this.operator = new Operator();
        this.destination = new Location();
        this.pickup = this.customer.getLocation();
        this.price = 0.0f;
        logger.info("Order created: " + this);
        amount++;
    }

    public Order(Customer customer, Driver driver, Operator operator, Location destination, float price) {
        this.customer = customer;
        this.driver = driver;
        this.operator = operator;
        this.destination = destination;
        this.pickup = this.customer.getLocation();
        this.price = price;
        logger.info("Order created: " + this);
        amount++;
    }

    public Order(Customer customer, Driver driver, Operator operator, Location pickup, Location destination, float price) {
        this.customer = customer;
        this.driver = driver;
        this.operator = operator;
        this.pickup = pickup;
        this.destination = destination;
        this.price = price;
        logger.info("Order created: " + this);
        amount++;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Location getPickup() {
        return pickup;
    }

    public void setPickup(Location pickup) {
        this.pickup = pickup;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static int getCount(){
        return amount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return String.format("\nORDER:\nCustomer: %s\nDriver: %s\nOperator: %s\nPickup location: %s\nDestination: %s\nPrice: %f",
                customer.toString(), driver.toString(), operator.toString(), pickup.toString(), destination.toString(), price);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Order order = (Order) object;
        return Float.compare(order.price, price) == 0 &&
                customer.equals(order.customer) &&
                driver.equals(order.driver) &&
                operator.equals(order.operator) &&
                pickup.equals(order.pickup) &&
                destination.equals(order.destination);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((driver == null) ? 0 : driver.hashCode());
        result = prime * result + ((operator == null) ? 0 : operator.hashCode());
        result = prime * result + ((pickup == null) ? 0 : pickup.hashCode());
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + (int) (price * 10);

        return result;
    }
}
