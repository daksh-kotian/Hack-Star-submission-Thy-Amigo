package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //A pop-up is needed upon the single button
    //with 2 more buttons to navigate to :
    // Hospital_Login_Register
    // &
    // Police_Register_Login
    // respectively...


    // Ignore the Login_and_Register Activity For RN !

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}