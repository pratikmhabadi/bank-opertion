package com.assignments.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Accounts account = new Accounts();
        List<User> userList= new ArrayList<>();
        int work = 1;
        while (work > 0) {
            System.out.println("Create New Account = 1 \n" +
                    "Check Balance =2 \n" +
                    "Deposit = 3 \n" +
                    "Withdraw = 4");
            System.out.println("Choose your options :");
            System.out.println("---------------------------------------------");
            int operationNo = sc.nextInt();
            account.operation(userList,operationNo);
            System.out.println(" ");
            System.out.println("Would you like to continue? (y/n) :");
            String exit = sc.next().toUpperCase(Locale.ROOT);
            if (exit.equals("N")) {
                System.out.println("Thank You");
                work = 0;
            }

        }
    }



}
