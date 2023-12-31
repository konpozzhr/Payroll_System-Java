package com.space.payroll;

import java.io.IOException;

public class Emp_Payroll {

    public Emp_Payroll() throws InterruptedException, IOException {


       String banner = """
                   ____                 ____        ____   _____            __              \s
                  / __ \\____ ___  __   / __ \\____  / / /  / ___/__  _______/ /____  ____ ___\s
                 / /_/ / __ `/ / / /  / /_/ / __ \\/ / /   \\__ \\/ / / / ___/ __/ _ \\/ __ `__ \\
                / ____/ /_/ / /_/ /  / _, _/ /_/ / / /   ___/ / /_/ (__  ) /_/  __/ / / / / /
               /_/    \\__,_/\\__, /  /_/ |_|\\____/_/_/   /____/\\__, /____/\\__/\\___/_/ /_/ /_/\s
                           /____/                            /____/                         \s
               
               """;

        System.out.println(banner);

        PayrollSystem payroll = new PayrollSystem();

        payroll.login_System();


//        try {
//
//            payroll.login_System();
//
//        }catch (Exception ex){
//            System.out.println("\n" + PayrollSystem.ANSI_RED + ex + PayrollSystem.ANSI_RESET);
//
//        }

    }


    public static void main(String[] args) throws InterruptedException, IOException {

        new Emp_Payroll();
    }
}
