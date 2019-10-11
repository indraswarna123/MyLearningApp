package com.example.mylearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylearningapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //GET PARAMETER VALUES FROM LoginActivity
        //getString inside here = putString on the other class

        Bundle params = getIntent().getExtras();
        String welcomeText = params.getString("username");
        String emailText = params.getString("email");

        TextView welcomeTextView = findViewById(R.id.welcomeText);
        welcomeTextView.setText("Welcome "+  welcomeText);



        //BUTTON LISTENER AND MOVE PAGE
        Button btn2 = findViewById(R.id.viewDataButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intent2 = new Intent(MainActivity.this, recyclerAdapter.class);

                startActivity(intent2);
                finish();
            }
        });
    }
}
