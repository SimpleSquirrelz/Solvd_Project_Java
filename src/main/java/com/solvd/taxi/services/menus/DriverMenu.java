package com.solvd.taxi.services.menus;

import com.solvd.taxi.enums.DriverStatus;
import com.solvd.taxi.exceptions.NoAvailableDriverException;
import com.solvd.taxi.people.Driver;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DriverMenu {
    private static Scanner in = new Scanner(System.in);
    public static Driver chooseDriver(List<Driver> drivers) throws NoAvailableDriverException {
        Iterator<Driver> iterator = drivers.stream()
                .filter(driver -> driver.getStatus() == DriverStatus.AVAILABLE)
                .iterator();


        while (iterator.hasNext()) {
            Driver driver = iterator.next();

            System.out.println("We found available driver:");
            System.out.println(driver.toString());
            System.out.println("Would you like to choose him?");

            System.out.println("0 - exit\n" +
                    "1 - Yes\n" +
                    "2 - No\n");

            String input = in.nextLine();
            switch (input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    return driver;
                case "2":
                    if(!iterator.hasNext()) {
                        throw new NoAvailableDriverException("No available suitable driver were found");
                    }
                    break;
                default:
                    System.out.println("There is no such command in the list");
                    break;
            }
        }
        return null;
    }
}
