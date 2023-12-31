package com.space.payroll;

import java.util.Scanner;

public class PartTimeEmp extends Employee{

    private int hourWorked;

    private double hourlyRate;

    public PartTimeEmp(){}

    public PartTimeEmp(String name, int id, int hourWorked, double hourlyRate){
        super(name, id);
        this.hourWorked = hourWorked;
        this.hourlyRate = hourlyRate;
    }


    Scanner sc = new Scanner(System.in);

    @Override
    public void inputEmployee(){
        super.inputEmployee();
        System.out.print("Enter Hour worked : ");
        hourWorked = sc.nextInt();
        System.out.print("Enter hour rate : ");
        hourlyRate = sc.nextDouble();

    }

    @Override
    public double inputSalary() {
        return 0;
    }


    @Override
    public double calculateSalary() {
        return hourWorked * hourlyRate;
    }
}
