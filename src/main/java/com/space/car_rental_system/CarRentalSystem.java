package com.space.car_rental_system;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }
        else {
            System.out.println("Car is not available!");
        }

    }


    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove = null;
        for(Rental rental : rentals){
            if(rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }
        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
            System.out.println(ANSI_GREEN + "Car returned successfully" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + "Car was not return!" + ANSI_RESET);
        }
    }


    Scanner sc = new Scanner(System.in);
    public void menu(){

        while(true){

            System.out.println("\n\n\n===========[ Car Rental System ]=============");
            System.out.println("\t1. Rent a car");
            System.out.println("\t2. Return a car");
            System.out.println("\t3. Exit ");
            System.out.print(" Enter your choice : ");

            int option = Integer.parseInt(sc.next());
            if (option == 1) {
                System.out.println("\n============= Rent a car ================");
                System.out.print("Enter your name : ");
                String customerName = sc.next();

                System.out.println("\nAvailable Car");
                for(Car car : cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarID() + " " + car.getBrand() + " " + car.getModel());
                    }
                }
                System.out.print("\nEnter the car ID you want to rent : ");
                String carID = sc.next();

                System.out.print("Enter the number of day for rental : ");
                int rentalDay = sc.nextInt();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for(Car car : cars){
                    if(car.getCarID().equals(carID) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }
                if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDay);
                    System.out.println("\n================== Rental Information ===============");
                    System.out.println("Customer ID : " + newCustomer.getCustomerID());
                    System.out.println("Customer Name : " + newCustomer.getName());
                    System.out.println("Car : " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Days : " + rentalDay);
                    System.out.printf("Total price : $%.2f\n", totalPrice);

                    System.out.print("\n Confirm Rental : ");
                    String confirm = sc.next();

                    if(confirm.equalsIgnoreCase("yes") || confirm.equalsIgnoreCase("y")){
                        rentCar(selectedCar, newCustomer, rentalDay);
                        System.out.println(ANSI_GREEN + "Car rent successfully" + ANSI_RESET);
                    }
                    else {
                        System.out.println(ANSI_RED + "Rental canceled" + ANSI_RESET);
                    }
                }
                else {
                    System.out.println(ANSI_RED + "\nInvalid car selection or car not available for rent." + ANSI_RESET);
                }

            }
            else if(option == 2){
                System.out.println("\n============= Return a car ================");
                System.out.print("Enter car ID you want to return : ");
                String carID = sc.next();

                Car carToReturn = null;
                for(Car car : cars){
                    if(car.getCarID().equals(carID) && !car.isAvailable()){
                        carToReturn = car;
                        break;
                    }
                }
                if(carToReturn != null){
                    Customer customer = null;
                    for(Rental rental : rentals){
                        if(rental.getCar() == carToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if(customer != null){
                        returnCar(carToReturn);
                        System.out.println(ANSI_GREEN + "\nCar returned successfully by "+ customer.getName() + ANSI_RESET);
                    }
                    else {
                        System.out.println(ANSI_RED + "\nCar was not rental or information is missing." + ANSI_RESET);
                    }
                }
                else {
                    System.out.println(ANSI_RED + "\nInvalid car ID or car is not rent." + ANSI_RESET);
                }

            }
            else if(option == 3){
//                System.exit(0);
                break;
            }
            else {
                System.out.println(ANSI_RED + "\nInvalid choice " + ANSI_RESET);
            }

        }

        System.out.println(ANSI_GREEN + "\n Thanks for using our service " + ANSI_RESET);

    }




}














