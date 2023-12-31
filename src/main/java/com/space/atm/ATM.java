package com.space.atm;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

public class ATM {

    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private float Balance;
    private int PIN = 1234;

    public ATM(){

    }

    public ATM(float Balance, int PIN){
        this.Balance = Balance;
        this.PIN = PIN;
    }

    public float getBalance(){
        return Balance;
    }

    Scanner sc = new Scanner(System.in);

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public void CheckPin() throws InterruptedException, IOException {
        System.out.print("Enter your pin : ");


        int enteredpin =  sc.nextInt();
        if(enteredpin == PIN){
            menu();
//            System.out.println("Pin correct");
        }
        else {
            System.out.println("Invalid pin");

            int i = 0;
            while(i < 3){
                System.out.print("\nEnter your pin : ");
                enteredpin = sc.nextInt();
                if(enteredpin == PIN)
                    menu();
                else{
                    System.out.println("Invalid pin");
                    i++;
                }
            }

            System.out.print("\n" + ANSI_RED + "Exceed PIN Retry " );

            for(int x = 0; x< 3; x++){
                System.out.print(". ");
                Thread.sleep(1000);
            }
        }

    }

    public void Check_Balance() throws InterruptedException, IOException {
        System.out.printf("Your balance %s \n\n" , currencyInstance.format(getBalance()));
        menu();
    }

    public void Cash_Withdrawal() throws InterruptedException, IOException {
//        clearConsole();
        System.out.print("\033\143");
        System.out.print("Enter amount : ");
        float amount = sc.nextFloat();


        if(amount > getBalance()){
            System.out.println(ANSI_RED + "Insufficient fund" + ANSI_RESET + "\n\n");
        }
        else {
            Balance = Balance - amount;
            System.out.println( ANSI_GREEN + "Cash Withdrawal Successfully" + ANSI_RESET + "\n\n");
            Thread.sleep(2000);
            System.out.printf("Your remaining balance %s \n\n" , currencyInstance.format(getBalance()));
        }

        menu();
    }

    public void Cash_Deposit() throws InterruptedException, IOException {
        System.out.print("Enter amount deposit : ");
        float deposit = sc.nextFloat();
        Balance = Balance + deposit;

        System.out.print( ANSI_GREEN + "Deposit Successfully" + ANSI_RESET + "\n\n");
        Thread.sleep(2000);
//        System.out.println("Your current balance : " + getBalance() + "\n\n");
        System.out.printf("Your current balance %s \n\n" , currencyInstance.format(getBalance()));
        menu();
    }


    public void menu() throws InterruptedException, IOException {
        System.out.println("\n\n============ Option ==============");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Cash Withdrawal");
        System.out.println("3. Cash Deposit");
        System.out.println("4. Exit \n\n");

        System.out.print("Enter your choice : ");
        int opt = sc.nextInt();
        switch (opt){
            case 1:
                System.out.print("\033[H\033[2J");
                Check_Balance();
                break;
            case 2:
                Cash_Withdrawal();
                break;
            case 3:
                Cash_Deposit();
                break;
            case 4:
                System.exit(0);
                break;
            default :
                System.out.println("Invalid Option");
        }
    }

}
