package com.students.bankme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity implements DepositDialog.DepositDialogListener, WithdrawDialog.WithdrawDialogListener {

    int accountNo;
    int accountBal;
    String username;
    TextView usernameTextView;
    TextView accountNoTextView;
    Button depositButton;
    Button withdrawButton;
    Button logoutButton;
    Button infoButton;
    TextView accountBalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        usernameTextView = findViewById(R.id.usernameTextView);
        accountNoTextView = findViewById(R.id.accountNoTextView);
        accountBalTextView = findViewById(R.id.accountBalTextView);
        depositButton = findViewById(R.id.depositButton);
        withdrawButton = findViewById(R.id.withdrawButton);
        logoutButton = findViewById(R.id.logoutButton);
        infoButton = findViewById(R.id.infoButton);

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
            openDepositDialog();
        });
        withdrawButton.setOnClickListener(view ->{
            openWithdrawDialog();
        });

        logoutButton.setOnClickListener(view -> {
            Toast.makeText(this, "Logout successful ..", Toast.LENGTH_SHORT).show();
            finish();
        });
        infoButton.setOnClickListener(view -> {
            startActivity(new Intent(AccountActivity.this, AboutScrollingActivity.class));
        });
    }
    public void openDepositDialog(){
        DepositDialog depositDialog= new DepositDialog();
        depositDialog.show(getSupportFragmentManager(), "depositDialog");
    }
    public void openWithdrawDialog(){
        WithdrawDialog withdrawDialog= new WithdrawDialog();
        withdrawDialog.show(getSupportFragmentManager(), "withdrawDialog");
    }

    @Override
    public void applyTexts(int enteredAmount) {
        accountBal = accountBal + enteredAmount;
        accountBalTextView.setText(String.valueOf(accountBal));
        Toast.makeText(this, "Deposit successful", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void applyTexts2(int enteredWithdrawAmount) {
        accountBal = accountBal - enteredWithdrawAmount;
        accountBalTextView.setText(String.valueOf(accountBal));
        Toast.makeText(this, "Withdraw successful", Toast.LENGTH_SHORT).show();
    }
}