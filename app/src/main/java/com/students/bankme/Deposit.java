package com.students.bankme;

public class Deposit {

    private int accountBalance;
    public int accountBalanceAfter;
    private int amountToWithdraw;

    public void setAccountBalance(){

    }

    public int getAccountBalance(){
        return accountBalance;
    }

    public void deposit(){
        // Code goes here
    }

    public void withdraw(){
        // Code goes here
        accountBalanceAfter = accountBalance - amountToWithdraw;
        if(accountBalanceAfter < 1000){
            // Display Error Message
            accountBalance = accountBalance + amountToWithdraw;
        }
    }
}
