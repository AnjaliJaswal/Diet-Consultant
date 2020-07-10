package com.example.dietconsutant_dietician;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
  Toolbar toolbar;
  Button btn4,btn3,btn2;
  FloatingActionButton fbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        fbtn= findViewById(R.id.floating_btn);
        btn2= findViewById(R.id.button2);
        btn4=findViewById(R.id.button4);
        btn3=findViewById(R.id.button3);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,Login.class));
                finish();
            }
        });
       //floating button added here
        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Add_Element.class);
                startActivity(intent);
            }
        });
        // feedback
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,PostListActivity2.class);
                startActivity(intent);
            }
        });

        //display data
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,PostListActivity.class);
                startActivity(intent);
            }
        });
    }



}    
