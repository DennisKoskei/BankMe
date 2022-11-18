package com.students.bankme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String username, setUsername;
    int password, setPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usernameInput = findViewById(R.id.usernameInputEditText);
        EditText passwordInput = findViewById(R.id.passwordEditText);
        Button signUpButton = findViewById(R.id.signUpButton);
        Button signInButton = findViewById(R.id.signInButton);

        //-----  THE MAIN CODE STARTS HERE -----

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent usernameIntent = getIntent();
                Intent passwordIntent = getIntent();
                setUsername = usernameIntent.getStringExtra("message_fullname");
                setPassword = passwordIntent.getIntExtra("message_password", 0);

                username = usernameInput.getText().toString();
                password = Integer.parseInt(passwordInput.getText().toString());

                if (password != setPassword){ //username.equals(setUsername)
                    Toast.makeText(MainActivity.this, "Unsuccessful Login ....", Toast.LENGTH_LONG).show();
                    WrongCredentials();
                    usernameInput.getText().clear();
                    passwordInput.getText().clear();
                }else{
                    Toast.makeText(MainActivity.this, "Password Verification Successful ...", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, AccountActivity.class));
                }
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CustomerActivity.class));
            }
        });
    }
    // ----- METHODS -----
    // ----- This method is used to display a warning message if the user inputs wrong username of password
    private void WrongCredentials() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Error !");
        builder.setMessage("Your username or password is wrong.");
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
}