package com.space.car_rental_system;

public class Rental {

    private Car car;
    private Customer customer;
    private int days;


    public Rental(){}

    public Rental(Car car, Customer customer, int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar(){ return car; }
    public Customer getCustomer(){ return customer; }
    public int getDays(){ return days; }

    public void setCar(Car car){ this.car = car; }
    public void setCustomer(Customer customer){ this.customer = customer; }
    public void setDays(int days){ this.days =days; }



}
