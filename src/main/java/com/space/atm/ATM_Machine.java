package com.space.atm;

import java.io.IOException;

public class ATM_Machine {

    public ATM_Machine() throws InterruptedException, IOException {

        String banner = """
                
                 █████╗ ████████╗███╗   ███╗    ███╗   ███╗ █████╗  ██████╗██╗  ██╗██╗███╗   ██╗███████╗
                ██╔══██╗╚══██╔══╝████╗ ████║    ████╗ ████║██╔══██╗██╔════╝██║  ██║██║████╗  ██║██╔════╝
                ███████║   ██║   ██╔████╔██║    ██╔████╔██║███████║██║     ███████║██║██╔██╗ ██║█████╗ \s
                ██╔══██║   ██║   ██║╚██╔╝██║    ██║╚██╔╝██║██╔══██║██║     ██╔══██║██║██║╚██╗██║██╔══╝ \s
                ██║  ██║   ██║   ██║ ╚═╝ ██║    ██║ ╚═╝ ██║██║  ██║╚██████╗██║  ██║██║██║ ╚████║███████╗
                ╚═╝  ╚═╝   ╚═╝   ╚═╝     ╚═╝    ╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝╚══════╝
                                                                                                       \s
                """;


        for(int i = 0; i< banner.length(); i++){
            System.out.print(banner.charAt(i));
            Thread.sleep(5);
        }
//        System.out.println(banner);
        ATM a = new ATM();
        a.CheckPin();

    }

    public static void main(String[] args) throws InterruptedException, IOException {

        new ATM_Machine();


    }
}
