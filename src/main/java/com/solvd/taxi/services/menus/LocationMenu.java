package com.solvd.taxi.services.menus;

import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.people.Customer;

import java.util.Scanner;

public class LocationMenu {
    private static Scanner in = new Scanner(System.in);

    public static Location specifyPickupLocation(Customer customer) {
        while(true) {
            System.out.println("Would you like to use your current location?");
            System.out.println("0 - exit\n1 - Yes\n2 - No");
            String option = in.nextLine();
            switch (option) {
                case "0": System.exit(0);
                case "1": return customer.getLocation();
                case "2":
                    System.out.println("Enter country");
                    String country = in.nextLine();

                    System.out.println("Enter city");
                    String city = in.nextLine();

                    System.out.println("Enter region");
                    String region = in.nextLine();

                    System.out.println("Enter street");
                    String street = in.nextLine();

                    System.out.println("Enter buildingNumber");
                    String buildingNumber = in.nextLine();

                    return new Location(country, city, region, street, buildingNumber);
                default:
                    System.out.println("There is no such option");
            }
        }
    }

    public static Location specifyDestinationLocation() {
        System.out.println("Enter country");
        String country = in.nextLine();

        System.out.println("Enter city");
        String city = in.nextLine();

        System.out.println("Enter region");
        String region = in.nextLine();

        System.out.println("Enter street");
        String street = in.nextLine();

        System.out.println("Enter buildingNumber");
        String buildingNumber = in.nextLine();

        return new Location(country, city, region, street, buildingNumber);
    }
}
