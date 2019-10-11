package com.example.mylearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btn = findViewById(R.id.submitRegister);
        final EditText username = findViewById(R.id.usernameRegister);
        final EditText password = findViewById(R.id.passwordRegister);
        final EditText confirmPassword = findViewById(R.id.confirmPasswordRegister);
        final EditText email = findViewById(R.id.emailRegister);
        final EditText age = findViewById(R.id.ageRegister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                String passwordVal = String.valueOf(password.getText());
                String confirmPasswordVal = String.valueOf(confirmPassword.getText());
                Log.d("Main_activity",passwordVal);
                Log.d("Main_activity",confirmPasswordVal);
                if(passwordVal.equals(confirmPasswordVal)){
                    String emailText = String.valueOf(email.getText());
                    if (emailText.matches(emailPattern) && emailText.length() > 0){

                        Toast.makeText(RegisterActivity.this, "Register Success",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this, "Email is empty or didn't follow rules",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "Password Didn't Match",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
