package com.students.bankme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AccountActivity extends AppCompatActivity {

    CustomerActivity cust1 = new CustomerActivity(); // This is an object of the CustomerActivity Class.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        EditText accountNameEditText = findViewById(R.id.accountNameEditText);
        EditText accountNoEditText = findViewById(R.id.accountNoEditText);
        EditText accountBalance = findViewById(R.id.accountBalanceEditText);

        Button depositButton = findViewById(R.id.depositButton);
        Button withdrawButton = findViewById(R.id.withdrawButton);
        Button logoutButton = findViewById(R.id.logoutButton);
        Button aboutButton = findViewById(R.id.aboutActionButton);

        accountNameEditText.setText(cust1.fullName);
        accountNoEditText.setText(cust1.accountNo);

        depositButton.setOnClickListener(view -> {
            // Code ...
            // Learn how to start a small dialog where the user can input a certain amount to deposit or withdraw
        });
        withdrawButton.setOnClickListener(view -> {
            // Code goes here ...
            // Learn how to start a small dialog where the user can input a certain amount to deposit or withdraw
        });
        logoutButton.setOnClickListener(view -> {
            finish();
        });
        aboutButton.setOnClickListener(view -> {
            startActivity(new Intent(AccountActivity.this, AboutScrollingActivity.class));
        });
    }
}