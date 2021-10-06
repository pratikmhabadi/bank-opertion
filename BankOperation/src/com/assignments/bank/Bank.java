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
        userList.add(new User("user1","9111111101",112,500));
        userList.add(new User("user2","9111111102",102,500));
        userList.add(new User("user3","9111111103",103,500));
        userList.add(new User("user4","9111111104",117,500));
        userList.add(new User("user5","9111111105",105,500));
        userList.add(new User("user6","9111111106",126,500));
        userList.add(new User("user7","9111111107",104,500));
        userList.add(new User("user8","9111111108",188,500));
        userList.add(new User("user9","9111111109",109,500));
        userList.add(new User("user10","9111111110",110,500));
        int work = 1;
        while (work > 0) {
            System.out.println("Create New Account = 1 \n" +
                    "Check Balance =2 \n" +
                    "Deposit = 3 \n" +
                    "Withdraw = 4 \n" +
            "Display Account in Sorted Ascending order =5 \n" +
                    "User Details By Mobile =6 ");
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
