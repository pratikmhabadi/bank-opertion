package com.assignments.bank;

public class User {
    private String name;
    private String mobileNo;
    private int accountNo;
    private double balance;

    public User(String name, String mobileNo, int accountNo, double balance) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


