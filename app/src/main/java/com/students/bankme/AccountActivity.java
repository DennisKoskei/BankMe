package com.students.bankme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {

    int accountNo;
    int accountBal;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText accountNoEditText = findViewById(R.id.accountNoEditText);
        EditText accountBalEditText = findViewById(R.id.accountBalEditText);
        Button depositButton = findViewById(R.id.depositButton);
        Button withdrawButton = findViewById(R.id.withdrawButton);
        Button logoutButton = findViewById(R.id.logoutButton);

        Bundle bundle3 = getIntent().getExtras();
        if (bundle3 != null) {
            username = bundle3.getString("message_username");
            accountNo = bundle3.getInt("message_accountNo", 0);
            accountBal = bundle3.getInt("message_accountBal",0);
        }
        usernameEditText.setText(username);
        accountNoEditText.setText(String.valueOf(accountNo));
        accountBalEditText.setText(String.valueOf(accountBal));

        depositButton.setOnClickListener(view -> {
            Toast.makeText(this, "Deposit successful", Toast.LENGTH_SHORT).show();
        });
        withdrawButton.setOnClickListener(view ->{
            Toast.makeText(this, "withdraw successful", Toast.LENGTH_SHORT).show();
        });
        logoutButton.setOnClickListener(view -> {
            Toast.makeText(this, "Logout successful ..", Toast.LENGTH_SHORT).show();
        });
    }
}