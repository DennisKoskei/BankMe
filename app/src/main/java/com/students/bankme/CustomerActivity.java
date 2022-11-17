package com.students.bankme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerActivity extends AppCompatActivity {

    String fullName;
    int accountNo;
    int IDno;
    String gender;
    String dateOfBirth;
    int age;
    int password;
    int passwordConfirmation;
    String nullStringChecker = "";
    int nullIntChecker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        EditText fullNameEditText = findViewById(R.id.fullNameEditText);
        EditText idNoEtNum = findViewById(R.id.idNoEtNum);
        EditText genderEditText = findViewById(R.id.genderEditText);
        EditText dateEditText = findViewById(R.id.dateEditText);
        EditText ageEditText = findViewById(R.id.ageEditText);
        EditText accountNumberEtNum = findViewById(R.id.accountNumberEtNum);
        EditText passwordInput = findViewById(R.id.passwordEditTextNumber);
        EditText passwordConfirmEditText = findViewById(R.id.confirmPasswordEditTextNumber);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullName = fullNameEditText.getText().toString();
                IDno = Integer.parseInt(idNoEtNum.getText().toString());
                gender = genderEditText.getText().toString();
                dateOfBirth = dateEditText.getText().toString();
                age = Integer.parseInt(ageEditText.getText().toString());
                accountNo = Integer.parseInt(accountNumberEtNum.getText().toString());
                password = Integer.parseInt(passwordInput.getText().toString());
                passwordConfirmation = Integer.parseInt(passwordConfirmEditText.getText().toString());

                // || IDno == nullIntChecker || gender == nullStringChecker || dateOfBirth == nullStringChecker || age == nullIntChecker || accountNo == nullIntChecker || password == nullIntChecker || passwordConfirmation == nullIntChecker
                if(fullName == nullStringChecker){
                    nullEntriesDetected();
                }else if (password != passwordConfirmation){
                    passwordsMismatchAlert();
                    passwordInput.getText().clear(); // used to clear the passwordInput field
                    passwordConfirmEditText.getText().clear(); // used to clear the passwordConfirmation field
                }else{
                    // Code ... = Add code to print out a message to say that the details have been saved.
                    Intent fullNameIntent = new Intent(getApplicationContext(), MainActivity.class);
                    Intent passwordIntent = new Intent(getApplicationContext(), MainActivity.class);
                    fullNameIntent.putExtra("message_fullname", fullName);
                    passwordIntent.putExtra("message_password", password);
                    startActivity(fullNameIntent);
                    startActivity(passwordIntent);
                    Toast.makeText(CustomerActivity.this, fullName, Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(CustomerActivity.this, MainActivity.class));
                     finish(); // Kill the current Activity and go back to the previous activity--> MainActivity.java
                }
            }
        });
    }

    // ----- METHODS TO BE CALLED-----
    private void nullEntriesDetected(){
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomerActivity.this);
        builder.setTitle("Empty Entries Detected !");
        builder.setMessage("Fill all the Entries required to proceed.");
        builder.setCancelable(true);
        builder.setNegativeButton("Cancel", ((dialogInterface, i) -> dialogInterface.cancel()));
        builder.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel());
        builder.show();
    }
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