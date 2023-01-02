package com.solvd.taxi.services.generators;

import com.solvd.taxi.enums.DriverStatus;
import com.solvd.taxi.helpers.DriverLicense;
import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.people.Customer;
import com.solvd.taxi.people.Driver;
import com.solvd.taxi.transport.CasualCar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DriversGenerator {
    public static List<Driver> generate() {
        return List.of(
                new Driver("+380631232323",
                        "Maximka",
                        "Raketa",
                        new Date(1993, Calendar.MARCH, 2),
                        350,
                        new Location("Ukraine", "Moscow", "Troeshina", "St", "29"),
                new DriverLicense("Maximka",
                        "Raketa",
                        new Date(1993, Calendar.MARCH, 2),
                        new Date(2013, Calendar.MARCH, 2),
                        new Date(2053, Calendar.MARCH, 2),
                        "AAAA-BBBB-CCCC-DDDD"), DriverStatus.UNAVAILABLE),
                new Driver("+380632342332",
                        "Antoshka",
                        "Pulya",
                        new Date(1993, Calendar.MARCH, 2),
                        350,
                        new Location("Ukraine", "Moscow", "Obolon", "Superstreet", "2/a"),
                        new DriverLicense("Antoshka",
                                "Pulya",
                                new Date(1997, Calendar.MARCH, 27),
                                new Date(2017, Calendar.MARCH, 27),
                                new Date(2057, Calendar.MARCH, 27),
                                "1234-BBBB-2345-DDDD"), DriverStatus.AVAILABLE)
        );
    }
}
