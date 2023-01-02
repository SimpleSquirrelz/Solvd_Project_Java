package com.solvd.taxi.services.generators;

import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.people.Customer;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomerGenerator {
    public static List<Customer> generate() {
        return List.of(
                new Customer("+380631232323",
                        "Zeri",
                        "Loun",
                        new Date(1993, Calendar.MARCH, 2),
                        3450,
                        new Location("Ukraine", "Moscow", "Troeshina", "St", "29")),
                new Customer("+380634444444",
                        "Levi",
                        "Akkerman",
                        new Date(1760, Calendar.APRIL, 1),
                        35650,
                        new Location("Ukraine", "Kyiv", "Kyiv", "St", "1")),
                new Customer("+380639999999",
                        "Zeri",
                        "Loun",
                        new Date(2001, Calendar.MARCH, 2),
                        350,
                        new Location("Tallin", "Tartu", "Daleko", "Srrrr", "99"))
        );
    }
}
