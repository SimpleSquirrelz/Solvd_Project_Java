package com.solvd.taxi.services.generators;

import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.people.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Generator <T> {
    public List<T> generate(Class<T> clazz, int instances) throws InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList<>();
        for(int i = 0; i < instances; i++){
            list.add(clazz.newInstance());
        }
        return list;
    }

    public static Customer initializeCustomer() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        int sleepTime = 750;

        System.out.println("Welcome, customer. Let's the game begin.");
        Thread.sleep(sleepTime);

        System.out.println("First we need to create your profile in our system");
        Thread.sleep(sleepTime);

        System.out.println("How can I call you?");
        String name = in.nextLine();
        System.out.println(name + ", really? Your parents should have come up with something better");
        Thread.sleep(sleepTime);

        System.out.println("Nevermind..");
        Thread.sleep(sleepTime);
        System.out.println("So.. What is your surname???");
        String surname = in.nextLine();

        System.out.println("...");
        Thread.sleep(sleepTime);
        System.out.println(".....");
        Thread.sleep(sleepTime);
        System.out.println(".......");
        Thread.sleep(sleepTime);

        System.out.println("Phone number?");
        String phone = in.nextLine();

        System.out.println("Country name?");
        String country = in.nextLine();

        System.out.println("City?");
        String city = in.nextLine();

        System.out.println("Region?");
        String region = in.nextLine();

        System.out.println("Street?");
        String street = in.nextLine();

        System.out.println("Building number?");
        String building = in.nextLine();

        System.out.println("Ook, we are almost done");
        Thread.sleep(sleepTime);
        System.out.println("I see your fingers tired");
        Thread.sleep(sleepTime);

        int month = 0;
        boolean isMonthValid = false;
        while (!isMonthValid) {
            System.out.println("So just enter a number :)");
            System.out.println("0 - January\n" +
                    "1 - February\n" +
                    "2 - March\n" +
                    "3 - April\n" +
                    "4 - May\n" +
                    "5 - June\n" +
                    "6 - July\n" +
                    "7 - August\n" +
                    "8 - September\n" +
                    "9 - October\n" +
                    "10 - November\n" +
                    "11 - December");
            int option = in.nextInt();
            if (option > 11 || option < 0)
                System.out.println("Select option from 0 to 11 dude");
            else {
                month = option;
                isMonthValid = true;
            }
        }
        System.out.println("Enter your day of a birth");
        int day = in.nextInt();

        System.out.println("Enter year");
        int year = in.nextInt();
        Thread.sleep(sleepTime);

        System.out.println("Aaand here we go");
        Customer customer = new Customer(
                phone,
                name,
                surname,
                new Date(year, month, day),
                0.0f,
                new Location(country, city, region, street, building));

        System.out.println(customer.toString());
        System.out.println("You are registered!");

        return customer;
    }
}
