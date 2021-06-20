package Entities.concretes;

import Entities.abstracts.BaseAccount;

public class IndividualAccount implements BaseAccount {
    private String accountId;
    private String customerFirstName;
    private String customerLastName;
    private String customerTC;
    private int customerBirthOfYear;
    private int balance;
    private double interest;


    public IndividualAccount (){}

    public IndividualAccount (String accountId, String customerFirstName, String customerLastName, String customerTC, int customerBirthOfYear, int balance,double interest){
        this.accountId = accountId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerTC = customerTC;
        this.customerBirthOfYear = customerBirthOfYear;
        this.balance = balance;
        this.interest = interest;
    }

    public String getAccountId() { return accountId; }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerTC() {
        return customerTC;
    }

    public void setCustomerTC(String customerTC) {
        this.customerTC = customerTC;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getCustomerBirthOfYear() { return customerBirthOfYear; }

    public void setCustomerBirthOfYear(int customerBirthOfYear) { this.customerBirthOfYear = customerBirthOfYear; }

}
