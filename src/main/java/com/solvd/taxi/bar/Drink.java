package com.solvd.taxi.bar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Date;

public final class Drink {
    private String name;
    private int amount;
    private float price;
    private float degree;
    private Date expirationDate;
    private final Logger logger = LogManager.getLogger(Drink.class);

    public Drink() {
        this.name = "NoName";
        this.amount = 0;
        this.price = 0.0f;
        this.degree = 0.0f;
        this.expirationDate = new Date(1900, Calendar.JANUARY, 1);
        logger.info("Drink created: " + this);
    }

    public Drink(String name, int amount, float price, float degree, Date expirationDate) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.degree = degree;
        this.expirationDate = expirationDate;
        logger.info("Drink created: " + this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDegree() {
        return degree;
    }

    public void setDegree(float degree) {
        this.degree = degree;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return String.format("\n%s vol:%f\n%d per %f$\nExpiration: %s",
                name, degree, amount, price, expirationDate.toString());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass())  return false;
        Drink drink = (Drink) object;
        return amount == drink.amount &&
                Float.compare(drink.price, price) == 0 &&
                Float.compare(drink.degree, degree) == 0 &&
                name.equals(drink.name) &&
                expirationDate.equals(drink.expirationDate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + amount;
        result = prime * result + (int) (degree * 10);
        result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());

        return result;
    }
}
