package com.solvd.taxi.bar;

import com.solvd.taxi.interfaces.IStorable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bar implements IStorable {
    private Map<String, Drink> drinks;
    private final Logger logger = LogManager.getLogger(Bar.class);

    public Bar(){
        this.drinks = new HashMap<>();
        logger.info("Object created: " + this);
    }

    public Bar(Map<String, Drink> drinks) {
        this.drinks = new HashMap<>(drinks);
        logger.info("Object created: " + this);
    }

    public Map<String, Drink> getDrinks() {
        return new HashMap<>(drinks);
    }

    public void setDrinks(Map<String, Drink> drinks) {
        this.drinks = new HashMap<>(drinks);
    }


    @Override
    public void pickUp(List<Object> objects) {

    }

    @Override
    public void dropOff(List<Object> object) {

    }
}
