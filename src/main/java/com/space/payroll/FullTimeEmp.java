package com.space.payroll;

import java.util.Scanner;

public class FullTimeEmp extends Employee{


    private double monthlySalary;

    public FullTimeEmp(){

    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public FullTimeEmp(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void inputEmployee(){
        super.inputEmployee();
        System.out.print("Enter salary : ");
        monthlySalary = sc.nextDouble();

    }



    public double inputSalary(){
        System.out.print("Input salary : ");
        monthlySalary = sc.nextDouble();
        return monthlySalary;

    }


    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
