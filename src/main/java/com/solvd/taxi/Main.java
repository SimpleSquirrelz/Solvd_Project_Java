package com.solvd.taxi;

import com.solvd.taxi.exceptions.InsufficientBalanceException;
import com.solvd.taxi.exceptions.NoAvailableDriverException;
import com.solvd.taxi.helpers.Location;
import com.solvd.taxi.people.Customer;

import com.solvd.taxi.people.Driver;
import com.solvd.taxi.people.Manager;
import com.solvd.taxi.people.Operator;
import com.solvd.taxi.sales.Order;
import com.solvd.taxi.services.generators.*;
import com.solvd.taxi.services.menus.CarMenu;
import com.solvd.taxi.services.menus.DriverMenu;
import com.solvd.taxi.services.menus.LocationMenu;
import com.solvd.taxi.transport.Car;
import com.solvd.taxi.transport.CasualCar;
import com.solvd.taxi.transport.LuxCar;
import com.solvd.taxi.transport.PoorCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.*;

public class Main {
    //    private static Generator generator = new Generator();
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static List<Car> cars;
    private static List<Customer> customers;
    private static List<Operator> operators;
    private static List<Driver> drivers;
    private static List<Manager> managers;

    private static Customer customer;
    private static Operator operator;
    private static Driver driver;
    private static Order order;
    private static Car car;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        generateAll();
        mainMenu();
    }

    public static void mainMenu() {
        while (true) {
            System.out.println("0 - exit\n" +
                    "1 - Display all users\n" +
                    "2 - Login\n");
            String input = in.nextLine();
            switch (input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    customers.forEach(System.out::println);
                    break;
                case "2":
                    System.out.println("Enter user phone number to log in ");
                    String phone = in.nextLine();
                    customer = customers.stream().filter(el -> el.getPhoneNumber().equals(phone)).findFirst().orElse(null);
                    if(customer != null) {
                        System.out.println("Congratulations, you authorized as" + customer);
                        orderMenu();
                    }
                    else
                        System.out.println("No user with such phone number exist in the system");
                    break;
                default:
                    logger.error("Main menu. There is no such command in the list");
                    break;
            }
        }
    }

    public static void orderMenu() {
        boolean stop = false;
        while (!stop) {
            System.out.println("0 - exit\n" +
                    "1 - Get current login info\n" +
                    "2 - Create an order\n" +
                    "99 - Log out");
            String input = in.nextLine();
            switch (input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println(customer);
                    break;
                case "2":
                    operator = operators.stream().min(Comparator.comparing(operator -> operator.getCustomerCalls().size()))
                            .orElseThrow(NoSuchElementException::new);
                    operator.addCustomerCalls(customer);

                    order = createOrder();
                    if(order != null)
                        sss();
                    break;
                case "99":
                    stop = true;
                    break;
                default:
                    System.out.println("There is no such command in the list");
                    break;
            }
        }
    }

    public static Order createOrder() {
        try {
            driver = DriverMenu.chooseDriver(drivers);
        } catch (NoAvailableDriverException e) {
            logger.error(e);
            return null;
        }

        try {
            car = CarMenu.selectCarType(cars);
        } catch (NoAvailableDriverException e) {
            logger.error(e);
            return null;
        }

        Location location = LocationMenu.specifyDestinationLocation(customer);
        float price = Operator.countPrice(customer.getLocation(), location, car.getCarClass());



        return new Order(customer,
                driver,
                operator,
                location,
                price);
    }


    public static void sss(){
        while (true) {
            System.out.println("0 - exit\n" +
                    "1 - Create an order\n" +
                    "2 - Get in the car\n" +
                    "3 - Check for drinks\n" +
                    "4 - Drink\n" +
                    "5 - Pay for taxi\n" +
                    "6 - Leave the car\n" +
                    "7 - Leave a feedback\n");
            String input = in.nextLine();
            switch (input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    try {
                        customer.pay(drivers.get(0), 10);
                    } catch (InsufficientBalanceException e) {
                        logger.error("Not enough money!!");
                    }
                    break;
                case "6":

                    break;
                case "7":

                    break;
                default:
                    System.out.println("There is no such command in the list");
                    break;
            }
        }
    }

    public static void generateAll() {
        List<CasualCar> casualCars = CasualCarsGenerator.generate();
        List<PoorCar> poorCars = PoorCarsGenerator.generate();
        List<LuxCar> luxCars = LuxCarsGenerator.generate();

        cars = new ArrayList<>();
        cars.addAll(casualCars);
        cars.addAll(poorCars);
        cars.addAll(luxCars);

        customers = CustomerGenerator.generate();
        operators = OperatorsGenerator.generate();
        drivers = DriversGenerator.generate();
        managers = ManagersGenerator.generate();
//        try {
//            List<CasualCar> casualCars = generator.generate(CasualCar.class, 5);
//            List<PoorCar> poorCars = generator.generate(PoorCar.class, 3);
//            List<LuxCar> luxCars = generator.generate(LuxCar.class, 1);
//
//            cars = new ArrayList<>();
//            cars.addAll(poorCars);
//            cars.addAll(casualCars);
//            cars.addAll(luxCars);
//
//            cars.stream().map(Object::toString).forEach(System.out::println);
//
//            customers = generator.generate(Customer.class, 2);
//            operators = generator.generate(Operator.class, 1);
//            drivers = generator.generate(Driver.class, 4);
//            managers = generator.generate(Manager.class, 2);
//        } catch (InstantiationException | IllegalAccessException e) {
//            logger.error(e.getMessage());
//            throw new RuntimeException(e);
//        }
    }
}
