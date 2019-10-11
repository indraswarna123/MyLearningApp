package com.example.mylearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mylearningapp.MainActivity;
import com.example.mylearningapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        Button loginButton = findViewById(R.id.loginButton);
        final EditText username = findViewById(R.id.username_edit);
        final EditText password = findViewById(R.id.password_edit);

        Button btnReg = findViewById(R.id.registerButton);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intentReg = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivity(intentReg);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getSupportActionBar().setTitle();

                if(username.getText().toString().equals("Joseph") && password.getText().toString().equals("Andreas")) {
                    //SET PAGE MOVEMENT FROM SOURCE (class.this) TO DESTINATION (class.class)
                    // extras.putString = PASS PARAMETERS FROM THIS PAGE TO MainActivity
                    //putString inside here = getString on the other class

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    Bundle extras = new Bundle();
                    extras.putString("username", username.getText().toString());
                    intent.putExtras(extras);

                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login Invalid" + "\n" + "Please enter correct credentials",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}