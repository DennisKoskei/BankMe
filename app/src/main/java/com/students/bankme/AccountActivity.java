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

        Bundle bundle3 = getIntent().getExtras();
        if (bundle3 != null) {
            username = bundle3.getString("message_username");
            accountNo = bundle3.getInt("message_accountNo", 0);
            accountBal = bundle3.getInt("message_accountBal",0);
        }
    }
}