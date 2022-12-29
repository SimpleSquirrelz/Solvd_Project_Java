package com.solvd.taxi.services.generators;

import com.solvd.taxi.people.Manager;
import com.solvd.taxi.people.Operator;

import java.util.*;

public class OperatorsGenerator {
    public static List<Operator> generate() {
        return List.of(
                new Operator("+380631232323",
                        "Nikita",
                        "Pushka",
                        new Date(1993, Calendar.OCTOBER, 2),
                        new LinkedList<>())
        );
    }
}
