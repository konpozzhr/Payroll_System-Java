package com.space.car_rental_system;

public class MainCarRental {

    public MainCarRental(){

        CarRentalSystem cr = new CarRentalSystem();

        Car car1 = new Car("A01", "Ford", "2018", 10);
        Car car2 = new Car("A02", "Ford", "2020", 20);
        Car car3 = new Car("A03", "Ford", "2022", 30);

        cr.addCar(car1);
        cr.addCar(car2);
        cr.addCar(car3);

        cr.menu();

    }

    public static void main(String[] args) {
        new MainCarRental();
    }
}




//  2024-01-01  : Skip