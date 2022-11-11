package com.students.bankme;

import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

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
            // alertMinMessage();
            accountBalance = accountBalance + amountToWithdraw;
        }
    }


    // ----- MAIN CODE IN DEPOSIT ENDS HERE -----
    /*
    private void alertMinMessage() {
        // AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Warning!");
        builder.setMessage("You cannot select a negative number of this item.");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

     */
}
