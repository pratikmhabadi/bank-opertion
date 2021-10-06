package com.assignments.bank;

public class User {
    private String Name;
    private String mobileNo;
    private int accountNo;
    private int balance;

    public User(String name, String mobileNo, int accountNo, int balance) {
        Name = name;
        this.mobileNo = mobileNo;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", accountNo=" + accountNo +
                ", balance=" + balance +
                '}';
    }
}


