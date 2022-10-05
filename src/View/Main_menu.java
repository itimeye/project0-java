package View;

import View.CustomerMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class Main_menu {
    public static void main_menu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("++++++++++++++++++++++++++++");
            System.out.println("Welcome to HallowBank");
            System.out.println("++++++++++++++++++++++++++++");
            System.out.println("Please make a selection from the options below.");
            System.out.println("Select 1: Customer");
            System.out.println("Select 2: Employee");

            int input = scanner.nextInt();
            switch (input){
                case 1: {
                    CustomerMenu.newCustomer();
                }
                case 2:{
                   Employ_menu.show();

                }
            }
        }

    }
}
