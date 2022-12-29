package com.solvd.taxi.services.generators;

import com.solvd.taxi.bar.Bar;
import com.solvd.taxi.bar.Drink;
import com.solvd.taxi.transport.CasualCar;
import com.solvd.taxi.transport.LuxCar;

import java.util.*;

public class LuxCarsGenerator {
    public static List<LuxCar> generate() {
        return List.of(
                new LuxCar(4, 50,
                        new ArrayList<>(),
                        new Bar(new HashMap<String, Drink>() {{
                            put("Vodka", new Drink("Vodka", 3, 150, 34.5f, new Date(1888, Calendar.JANUARY, 1)));
                            put("Mineral water", new Drink("Chistiy spirt", 99, 0, 100f, new Date(1888, Calendar.JANUARY, 1)));
                        }}))
        );
    }
}
