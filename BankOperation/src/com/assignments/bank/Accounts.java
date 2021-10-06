package com.assignments.bank;

import java.util.*;

public class Accounts {
    Scanner sc = new Scanner(System.in);

    //for create new account number
    public int createAccountNo() {
        Random random = new Random();
        return random.nextInt(9999);
    }

    //find account
    public boolean checkAccountNo(List<User> userList,int accountNo){
        for (User user:userList){
            if(user.getAccountNo()==accountNo){
                return true;
            }
        }
        return false;
    }

    //for add new user
    public void addUser(List<User> userList) {
        System.out.println("Name:");
        String name = sc.next();//name input
        System.out.println("Mobile No:");
        String mobileNo = sc.next();//mobile input
        System.out.println("Enter Your initial Amount");
        int amount;
        amount = sc.nextInt();//initial amount input
        if (amount < 0) {
            amount = 0;
        }
        int accountNo = createAccountNo();//account number
        userList.add(new User(name, mobileNo, accountNo, amount));
        System.out.println("Account created successfully!");
        System.out.println("Your Account Number is " + accountNo);
        System.out.println("--------------------------------------");
    }

    //for check balance
    public void checkBalance(List<User> userList, int accountNo) {
        for (User user : userList) {
            if (user.getAccountNo() == accountNo) {
                System.out.println("Your Account Balance is :" + user.getBalance());
            }
        }
        System.out.println("----------------------------------------------");
    }

    //for add deposit in account
    public void deposit(List<User> userList, int accountNo, int amount) {
        for (User user : userList) {
            if (user.getAccountNo() == accountNo) {
                user.setBalance(user.getBalance() + amount);
                System.out.println("Amount Successfully Deposit in your account ");
            }
        }
        System.out.println("----------------------------------------------");
    }

    //for withdraw deposit from account
    public void withdraw(List<User> userList, int accountNo, int amount) {
        for (User user : userList) {
            if (user.getAccountNo() == accountNo) {
                if (user.getBalance() < amount) {
                    System.out.println("Your balance is Low");
                } else if (user.getBalance() == 0) {
                    System.out.println("Your balance is 0");
                } else {
                    user.setBalance(user.getBalance() - amount);
                    System.out.println("Amount successfully withdraw from your account");
                }
            }
        }
        System.out.println("----------------------------------------------");
    }


    //operations for methods
    public void operation(List<User> userList, int operationNo) {
        switch (operationNo) {
            case 1://create new user
                addUser(userList);
                break;
            case 2://check balance
                System.out.println("Enter Account Number:");
                int accountNo = sc.nextInt();
                if(checkAccountNo(userList,accountNo)) {
                    checkBalance(userList, accountNo);
                }else{
                    System.out.println("Account Not Found");
                }
                break;
            case 3://deposit
                System.out.println("Enter Account Number:");
                int accountNo1 = sc.nextInt();
                if(checkAccountNo(userList, accountNo1)){
                System.out.println("Enter Deposit Amount");
                int deposit = sc.nextInt();
                deposit(userList, accountNo1, deposit);
                }else {
                    System.out.println("Account Not Found");
                }

                break;
            case 4://withdraw
                System.out.println("Enter Account Number:");
                int accountNo2 = sc.nextInt();
                if(checkAccountNo(userList,accountNo2)) {
                    System.out.println("Enter withdraw Amount");
                    int withdraw = sc.nextInt();
                    withdraw(userList, accountNo2, withdraw);
                }else{
                    System.out.println("Account Not Found");
                }
                break;
            default://invalid
                System.out.println("INVALID INPUT");
                break;
        }
    }


}
