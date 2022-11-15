package com.students.bankme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CustomerActivity extends AppCompatActivity {

    String fullName;
    int accountNo;
    int IDno;
    boolean gender;
    int dateOfBirth;
    int age;
    int password;
    int passwordConfirmation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        EditText fullNameEditText = findViewById(R.id.fullNameEditText);
        EditText idNoEtNum = findViewById(R.id.idNoEtNum);
        EditText dateEditText = findViewById(R.id.dateEditText);
        CheckBox maleCheckBox = findViewById(R.id.maleCheckBox);
        EditText accountNumberEtNum = findViewById(R.id.accountNumberEtNum);
        EditText passwordInput = findViewById(R.id.passwordEditTextNumber);
        EditText passwordConfirmEditText = findViewById(R.id.confirmPasswordEditTextNumber);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullName = fullNameEditText.getText().toString();
                IDno = Integer.parseInt(idNoEtNum.getText().toString());
//                gender = ;
//                dob
//                age
                accountNo = Integer.parseInt(accountNumberEtNum.getText().toString());
                password = Integer.parseInt(passwordInput.getText().toString());
                passwordConfirmation = Integer.parseInt(passwordConfirmEditText.getText().toString());

                if (password != passwordConfirmation){
                   passwordsMismatchAlert();
                   passwordInput.getText().clear(); // used to clear the passwordInput field
                    passwordConfirmEditText.getText().clear(); // used to clear the passwordConfirmation field
                }else{
                    // Code ... = Add code to print out a message to say that the details have been saved.
                    finish(); // Kill the current Activity and go back to the previous activity--> MainActivity.java
                }
            }
        });
    }

    // ----- METHODS TO BE CALLED-----
    // This method is used to display an AlertDialog saying that the passwords entered to not match.
    public void passwordsMismatchAlert (){
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomerActivity.this);
        builder.setTitle("Passwords Mismatch !");
        builder.setMessage("The passwords entered to not match !! Enter passwords again.");
        builder.setCancelable(true);
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.cancel());
        builder.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel());
        builder.show();

    }
}