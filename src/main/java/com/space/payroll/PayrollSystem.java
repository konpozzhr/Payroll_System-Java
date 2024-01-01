package com.space.payroll;

import java.util.*;

public class PayrollSystem {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private ArrayList<Employee> employeeList;
    private final String username = "sathya";
    private final int password = 1111;


    public String getUsername(){
        return username;
    }

    public int getPassword(){
        return password;
    }

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(){

        FullTimeEmp fullEmp = new FullTimeEmp();
        PartTimeEmp partEmp = new PartTimeEmp();
        System.out.println("1. Full Time Employee");
        System.out.println("2. Part Time Employee");
        System.out.print("Please choose type of Employee : ");
        int type = sc.nextInt();
        boolean empID_Exist = false;
        if(type == 1){
            try{
                fullEmp.inputEmployee();
                for (Employee chkEmp : employeeList){
                    if(fullEmp.getId() == chkEmp.getId()){
                        System.out.println(ANSI_YELLOW + "Employee [ ID = " + chkEmp.getId() + " ] already exist! Cannot be add." + ANSI_RESET);
                        empID_Exist = true;
                    }
                }
            }catch (Exception ex){
                System.out.println("\n" + PayrollSystem.ANSI_RED + ex + "\nID/Salary should be input as number." + PayrollSystem.ANSI_RESET);
                menu();
            }
            if(!empID_Exist)
                employeeList.add(fullEmp);
        }


        else if(type == 2){
            try{
                partEmp.inputEmployee();
                for(Employee chkEmp : employeeList){
                    if(partEmp.getId() == chkEmp.getId()){
                        System.out.println(ANSI_YELLOW + "Employee [ ID = " + chkEmp.getId() + " ] already exist! Cannot be add." + ANSI_RESET);
                        empID_Exist = true;
                    }
                }
            }catch (Exception ex){
                System.out.println("\n" + PayrollSystem.ANSI_RED + ex + "\nID/HourWork/rate should be input as number." + PayrollSystem.ANSI_RESET);
                menu();
            }

            if(!empID_Exist)
                employeeList.add(partEmp);

        }
        else {
            System.out.printf("%s \nInvalid Option. %s\n\n", ANSI_RED, ANSI_RESET);
        }

        menu();
    }

    public void removeEmployee(){

        try{
            System.out.print("Please input employee id to remove : ");
            int id = Integer.parseInt(sc.next());

            Employee empToRemove = null;
            for(Employee employee : employeeList){
                if(employee.getId() == id){
                    empToRemove = employee;
                    break;
                }
            }

            if(empToRemove != null){
                System.out.printf("\n%sEmployee%s [ ID = " + empToRemove.getId() + ", Name = " + empToRemove.getName() + " ] %s has been removed successfully %s \n\n"
                        ,ANSI_GREEN, ANSI_RESET, ANSI_GREEN, ANSI_RESET);
                employeeList.remove(empToRemove);
            }
            else {
                System.out.printf("%s \nID not found !%s  \n\n", ANSI_RED, ANSI_RESET);
            }
        }catch (Exception ex){
            System.out.println("\n" + PayrollSystem.ANSI_RED + ex + "\nEmployee ID should be number only. "+ PayrollSystem.ANSI_RESET + "\n");
            menu();
        }

        menu();

    }


    public void updateEmployee(){

        try {
            System.out.print("Input Employee ID to update:  ");
            int id = Integer.parseInt(sc.next());
            FullTimeEmp full = new FullTimeEmp();

            PartTimeEmp part = new PartTimeEmp();


            Employee empFound = null;
            for(Employee emp : employeeList){
                if(emp.getId() == id){
                    empFound = emp;
                    break;
                }
            }
            if(empFound != null){

                System.out.println("Employee to update ");
                System.out.println(empFound);
                full.setId(empFound.getId());
                full.setName(empFound.getName());

                try{
                    full.setMonthlySalary(full.inputSalary());
                }catch (Exception ex) {
                    System.out.println("\n" + PayrollSystem.ANSI_RED + ex + "\nSalary should be number only. "+ PayrollSystem.ANSI_RESET + "\n");
                    menu();
                }
                employeeList.set(employeeList.indexOf(empFound), full);
                System.out.printf("%s \nUpdate successfully %s \n\n" , ANSI_GREEN, ANSI_RESET);
            }
            else {
                System.out.printf("%s \nEmployee ID = " + id + " not found !%s \n\n", ANSI_RED, ANSI_RESET );
            }

        }catch (Exception ex){
            System.out.println("\n" + PayrollSystem.ANSI_RED + ex + "\nEmployee ID should be number only. "+ PayrollSystem.ANSI_RESET + "\n");
            menu();
        }

        menu();
    }

    public void sortEmployee(){

        System.out.println(ANSI_GREEN + "\n================ Before Sort =============" + ANSI_RESET);
        for(Employee empList : employeeList){
            System.out.println(empList);
        }

        System.out.println(ANSI_GREEN + "\n================ After Sort =============" + ANSI_RESET);
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return String.valueOf(o1.getId()).compareTo(String.valueOf(o2.getId()));
            }
        });

        employeeList.forEach(x -> System.out.println(x));

        menu();
    }

    public void searchEmployee(){

        System.out.print("Search by ID/Name : ");
        String opSearch = sc.next();
        if(opSearch.equalsIgnoreCase("ID")){
            try{
                System.out.print("Please input employee id to Search : ");
                int id = Integer.parseInt(sc.next());
                for(Employee employee : employeeList){
                    if(employee.getId() == id){
                        System.out.println("\n" + employee);
                        break;
                    }
                    else {
                        System.out.printf("%s \nID not found !%s  \n\n", ANSI_RED, ANSI_RESET);
                    }
                }
            }catch (Exception ex){
                System.out.println("\n" + PayrollSystem.ANSI_RED + ex + "\nEmployee ID should be number only. "+ PayrollSystem.ANSI_RESET + "\n");
                menu();
            }
        }
        else if(opSearch.equalsIgnoreCase("Name")){
            System.out.println("search by name ");
            System.out.print("Please input employee name to Search : ");
            String name = sc.next();

            System.out.println("\n");
            for(Employee employee : employeeList){
                if (employee.getName().equalsIgnoreCase(name)){
                    System.out.print("\n" + employee);
                }
                else{
                    System.out.printf("%s \nName not found !%s  \n\n", ANSI_RED, ANSI_RESET);
                }
            }

        }
        else {
            System.out.println("\n" + ANSI_RED + "Invalid option!" + ANSI_RESET);
        }

       menu();

    }



    public void displayEmployee(){

        if(employeeList.isEmpty()){
            System.out.println(ANSI_YELLOW + "\nEmployee list is empty" + ANSI_RESET);
        }
        else{
            for(Employee emp : employeeList){
                System.out.println(emp);
            }
        }

        menu();
    }


    Scanner sc = new Scanner(System.in);

    public void login_System() {

        try{

            System.out.print("Enter username : ");
            String name = sc.next();
            System.out.print("Enter password : ");
            int pass = Integer.parseInt(sc.next());

            if(name.equals(getUsername()) && (pass == getPassword())){
                System.out.println(ANSI_GREEN + "\nLogin success" + ANSI_RESET);
                menu();
            }
            else {
                System.out.println(ANSI_RED + "\nIncorrect username or password \n\n" + ANSI_RESET);

                int i = 0;
                while(i < 3){
                    System.out.print("Enter username : ");
                    name = sc.next();
                    System.out.print("Enter password : ");
                    pass = sc.nextInt();

                    if(name.equals(getUsername()) && (pass == getPassword())){
                        System.out.println(ANSI_GREEN + "\nLogin success" + ANSI_RESET);

                        menu();
                    }
                    else {
                        System.out.println(ANSI_RED + "\nIncorrect username or password \n\n" + ANSI_RESET);
                        i++;
                    }
                }

                System.out.println(ANSI_RED + "\nUser suspense " + ANSI_RESET);
            }
        }catch (Exception ex){
            System.out.println("\n" + PayrollSystem.ANSI_RED + ex + "\nPassword should be number only. "+ PayrollSystem.ANSI_RESET + "\n");

            login_System();
        }
    }

    public void menu(){



        System.out.println("\n\n\n\n\n===============[ Menu Option ]================\n");
        System.out.println("\t1. Show Employee List");
        System.out.println("\t2. Add Employee");
        System.out.println("\t3. Remove Employee");
        System.out.println("\t4. Update Employee");
        System.out.println("\t5. Sort Employee");
        System.out.println("\t6. Search Employee");
        System.out.println("\t7. Exit ");

        System.out.print("Please input option : ");
        int opt = Integer.parseInt(sc.next());

        System.out.println(opt);
        switch (opt){
            case 1:
                System.out.println("\n\n\n=============[ Employee List ]=============");
                displayEmployee();
                break;
            case 2:
                System.out.println("\n\n\n=============[ Add Employee ]==============");
                addEmployee();
                break;
            case 3:
                System.out.println("\n\n\n=============[ Remove Employee ]===========");
                removeEmployee();
                break;
            case 4:
                System.out.println("\n\n\n=============[ Update Employee ]===========");
                updateEmployee();
                break;
            case 5:
                System.out.println("\n\n\n=============[ Sort Employee ]============");
                sortEmployee();
                break;
            case 6:
                System.out.println("\n\n\n=============[ Search Employee ]============");
                searchEmployee();
                break;
            case 7:
                System.out.println(ANSI_PURPLE + "\n\n\n=============[ System Exit ]===========\n" + ANSI_PURPLE);
                System.exit(0);
                break;
            default:
                System.out.println(ANSI_RED + "\nInvalid Option \n" + ANSI_RESET);
                menu();
                break;

        }

    }


}
