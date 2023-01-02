package com.solvd.taxi.services.menus;

import com.solvd.taxi.exceptions.NoAvailableDriverException;
import com.solvd.taxi.transport.Car;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CarMenu {
    private static Scanner in = new Scanner(System.in);

    public static Car selectCarType(List<Car> cars) throws NoAvailableDriverException {
        List<Car> filteredCars = null;
        boolean stop = false;
        while (!stop) {
            System.out.println("Which type of car you want to use?");
            System.out.println("0 - exit\n1 - Poor\n2 - Casual\n3 - Lux");
            String option = in.nextLine();
            switch (option) {
                case "0":
                    System.exit(0);
                case "1":
                    System.out.println(cars.get(0).getClass());
                    filteredCars = cars.stream().filter(car -> car.getClass().getName().contains("PoorCar")).toList();
                    stop = true;
                    break;
                case "2":
                    filteredCars = cars.stream().filter(car -> car.getClass().getName().contains("CasualCar")).toList();
                    stop = true;
                    break;
                case "3":
                    filteredCars = cars.stream().filter(car -> car.getClass().getName().contains("LuxCar")).toList();
                    stop = true;
                    break;
                default:
                    System.out.println("There is no such option");
            }
        }

        Iterator<Car> iterator = filteredCars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            System.out.println("There is an option");
            System.out.println(car);
            System.out.println("Would you like to choose it?");
            System.out.println("0 - exit\n1 - Yes\n2 - No");
            String option = in.nextLine();
            switch (option) {
                case "0":
                    System.exit(0);
                case "1":
                    return car;
                case "2":
                    if(!iterator.hasNext()) {
                        throw new NoAvailableDriverException("No suitable car were found");
                    }
                default:
                    System.out.println("There is no such option");
            }
        }
        return null;
    }
}
