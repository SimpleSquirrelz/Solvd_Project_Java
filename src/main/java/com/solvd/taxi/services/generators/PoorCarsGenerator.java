package com.solvd.taxi.services.generators;

import com.solvd.taxi.transport.CasualCar;
import com.solvd.taxi.transport.PoorCar;

import java.util.ArrayList;
import java.util.List;

public class PoorCarsGenerator {
    public static List<PoorCar> generate() {
        return List.of(
                new PoorCar(4, 50, new ArrayList<>(), new ArrayList<>()),
                new PoorCar(2, 150, new ArrayList<>(), new ArrayList<>()),
                new PoorCar(1, 200, new ArrayList<>(), new ArrayList<>())
        );
    }
}
