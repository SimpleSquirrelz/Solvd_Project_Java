package com.solvd.taxi.services.generators;

import com.solvd.taxi.transport.CasualCar;

import java.util.ArrayList;
import java.util.List;

public class CasualCarsGenerator {
    public static List<CasualCar> generate() {
        return List.of(
                new CasualCar(4, 50, new ArrayList<>()),
                new CasualCar(2, 150, new ArrayList<>()),
                new CasualCar(1, 200, new ArrayList<>())
        );
    }
}
