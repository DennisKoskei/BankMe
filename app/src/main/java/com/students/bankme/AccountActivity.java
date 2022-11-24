package com.students.bankme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity implements DepositDialog.DepositDialogListener implements De{

    int accountNo;
    int accountBal;
    String username;
    TextView accountBalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        TextView usernameTextView = findViewById(R.id.usernameTextView);
        TextView accountNoTextView = findViewById(R.id.accountNoTextView);
        accountBalTextView = findViewById(R.id.accountBalTextView);
        Button depositButton = findViewById(R.id.depositButton);
        Button withdrawButton = findViewById(R.id.withdrawButton);
        Button logoutButton = findViewById(R.id.logoutButton);
        Button infoButton = findViewById(R.id.infoButton);

        Bundle bundle3 = getIntent().getExtras();
        if (bundle3 != null) {
            username = bundle3.getString("message_username");
            accountNo = bundle3.getInt("message_accountNo", 0);
            accountBal = bundle3.getInt("message_accountBal",0);
        }
        usernameTextView.setText(username);
        accountNoTextView.setText(String.valueOf(accountNo));
        accountBalTextView.setText(String.valueOf(accountBal));

        depositButton.setOnClickListener(view -> {
            openDialog();
            Toast.makeText(this, "Deposit successful", Toast.LENGTH_SHORT).show();
        });
        withdrawButton.setOnClickListener(view ->{
            withdrawAmount();
            Toast.makeText(this, "withdraw successful", Toast.LENGTH_SHORT).show();
        });
        logoutButton.setOnClickListener(view -> {
            Toast.makeText(this, "Logout successful ..", Toast.LENGTH_SHORT).show();
        });
        infoButton.setOnClickListener(view -> {
            startActivity(new Intent(AccountActivity.this, AboutScrollingActivity.class));
        });
    }
    public void openDialog(){
        DepositDialog depositDialog= new DepositDialog();
        depositDialog.show(getSupportFragmentManager(), "depositDialog");
    }

    public void withdrawAmount(){
        // Code ...
    }

    @Override
    public void applyTexts(int enteredAmount) {
        accountBal = accountBal + enteredAmount;
        accountBalTextView.setText(String.valueOf(accountBal));
    }
}