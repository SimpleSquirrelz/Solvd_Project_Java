package com.solvd.taxi.services.generators;

import com.solvd.taxi.people.Manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ManagersGenerator {
    public static List<Manager> generate() {
        return List.of(
                new Manager("+38063000000",
                        "Oleg",
                        "JustOleg",
                        new Date(1993, Calendar.SEPTEMBER, 23),
                        new ArrayList<>())
        );
    }
}
