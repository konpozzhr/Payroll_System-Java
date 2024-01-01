package com.space.car_rental_system;

public class Car {

    private String carID;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(){}

    public Car(String carID, String brand, String model, double basePricePerDay){
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
    }

    public Car(String carID, String brand, String model, double basePricePerDay, boolean isAvailable){
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarID(){ return  carID; }
    public String getBrand(){ return brand; }
    public String getModel(){ return model; }
    public double getBasePricePerDay(){ return basePricePerDay; }
    public boolean isAvailable(){ return true; }

    public void setCarID(String carID){ this.carID = carID; }
    public void setBrand(String brand){ this.brand = brand; }
    public void setModel(String model){ this.model = model; }
    public void setBasePricePerDay(double basePricePerDay){ this.basePricePerDay = basePricePerDay; }

    public void rent(){
        isAvailable = false;
    }

    public void returnCar(){
        isAvailable = true;
    }


    public double calculatePrice(int rentalDays){
        return basePricePerDay * rentalDays;
    }








}
