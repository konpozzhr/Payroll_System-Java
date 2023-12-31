package com.space.payroll;

import java.text.NumberFormat;
import java.util.Scanner;

public abstract class Employee {

    private String name;
    private int id;

    public Employee(){

    }

    public Employee(String name, int id){
        this.name = name;
        this.id = id;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    // Abstract method
    public abstract double calculateSalary();

    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();

    Scanner sc = new Scanner(System.in);
    public void inputEmployee(){
        System.out.print("Enter Name : ");
        name = sc.next();
        System.out.print("Enter ID : ");
        id = sc.nextInt();


    }

    public abstract double inputSalary();




    @Override
    public String toString(){

        return String.format("Employee [ ID = %d, Name = %s, Salary = %s ]",
                getId(), getName(), currencyInstance.format(calculateSalary()));

    }




}
