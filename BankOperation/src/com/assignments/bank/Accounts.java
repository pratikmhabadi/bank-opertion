package com.assignments.bank;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accounts {
    //for create new account number
    public int createAccountNo(List<User> userList) {
        Random random = new Random();
        int accountNo = random.nextInt(9999);
        if (!checkAccountNo(userList, accountNo)) {
            return random.nextInt(9999);
        } else {
            return createAccountNo(userList);
        }
    }

    //find account
    public boolean checkAccountNo(List<User> userList, int accountNo) {
        for (User user : userList) {
            if (user.getAccountNo() == accountNo) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMobileNo(List<User> userList, String mobileNo) {
        for (User user : userList) {
            if (user.getMobileNo().trim().equals(mobileNo)) {
                if (mobileValid(mobileNo)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean mobileValid(String mobileNo) {
        Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = pattern.matcher(mobileNo);
        return match.find() && match.group().equals(mobileNo);
    }

    //for add new user
    public void addUser(List<User> userList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name:");
        String name = sc.next();//name input
        System.out.println("Mobile No:");
        String mobileNo = sc.next();//mobile input
        if (!checkMobileNo(userList, mobileNo)) {
            int number = 1;
            while (number > 0) {
                System.out.println("Mobile number is Invalid , Enter again");
                mobileNo = sc.next();
                if (checkMobileNo(userList, mobileNo)) {
                    number = 0;
                }
            }
        }
        System.out.println("Enter Your initial Amount");
        double amount;
        amount = sc.nextDouble();//initial amount input
        if (amount < 0) {
            amount = 0;
        }
        int accountNo = createAccountNo(userList);//account number
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
    public void deposit(List<User> userList, int accountNo, double amount) {
        for (User user : userList) {
            if (user.getAccountNo() == accountNo) {
                user.setBalance(user.getBalance() + amount);
                System.out.println("Amount Successfully Deposit in your account ");
            }
        }
        System.out.println("----------------------------------------------");
    }

    //for withdraw deposit from account
    public void withdraw(List<User> userList, int accountNo, double amount) {
        for (User user : userList) {
            if (user.getAccountNo() == accountNo) {
                if (user.getBalance() < amount) {
                    System.out.println("Your balance is Low");
                } else if (user.getBalance() == 0 || amount == 0) {
                    System.out.println("Your balance is 0 or you entered amount is 0");
                } else {
                    user.setBalance(user.getBalance() - amount);
                    System.out.println("Amount successfully withdraw from your account");
                }
            }
        }
        System.out.println("----------------------------------------------");
    }


    //get user by mobile number
    public User getUserByMobileNo(List<User> userList, String mobileNo) {
        for (User user : userList) {
            if (user.getMobileNo().trim().equals(mobileNo)) {
                return user;
            }
        }
        return null;
    }

    //sorting account number in ascending order
    public List<Integer> sortList(List<User> userList) {
        List<Integer> sortList = new ArrayList<>();
        for (User user : userList) {
            sortList.add(user.getAccountNo());
        }
        Collections.sort(sortList);
        return sortList;
    }

    //printing account number py sorted account list
    public void getUserByAccountNo(List<User> userList, int accountNo) {
        for (User user : userList) {
            if (user.getAccountNo() == accountNo) {
                System.out.println(user.getAccountNo());
            }
        }
    }


    //operations for methods
    public void operation(List<User> userList, int operationNo) {
        try {
            Scanner sc = new Scanner(System.in);
            switch (operationNo) {
                case 1://create new user
                    addUser(userList);
                    break;

                case 2://check balance
                    System.out.println("Enter Account Number:");
                    int accountNo = sc.nextInt();
                    if (checkAccountNo(userList, accountNo)) {
                        checkBalance(userList, accountNo);
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;

                case 3://deposit
                    System.out.println("Enter Account Number:");
                    int accountNo1 = sc.nextInt();
                    if (checkAccountNo(userList, accountNo1)) {
                        System.out.println("Enter Deposit Amount");
                        double deposit = sc.nextDouble();
                        deposit(userList, accountNo1, deposit);
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;

                case 4://withdraw
                    System.out.println("Enter Account Number:");
                    int accountNo2 = sc.nextInt();
                    if (checkAccountNo(userList, accountNo2)) {
                        System.out.println("Enter withdraw Amount");
                        double withdraw = sc.nextDouble();
                        withdraw(userList, accountNo2, withdraw);
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;

                case 5://getListByAccountNo
                    List<Integer> integer = sortList(userList);
                    if (integer.size() > 0) {
                        for (int number : integer) {
                            getUserByAccountNo(userList, number);
                        }
                    } else {
                        System.out.println("No record");
                    }
                    break;

                case 6://getListByAccountNo
                    System.out.println("Enter Your Mobile Number");
                    String mobileNo = sc.next();
                    User mobileUser = getUserByMobileNo(userList, mobileNo);
                    if (mobileUser != null) {
                        System.out.println("---------Details of User------");
                        System.out.println("Name of User : " + mobileUser.getName());
                        System.out.println("Mobile No of User : " + mobileUser.getMobileNo());
                        System.out.println("Account Balance of User : " + mobileUser.getBalance());
                    } else {
                        System.out.println("Didn't find any record with your mobile number");
                    }
                    break;

                default://invalid
                    System.out.println("INVALID INPUT");
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid Account number");
        }
    }
}
