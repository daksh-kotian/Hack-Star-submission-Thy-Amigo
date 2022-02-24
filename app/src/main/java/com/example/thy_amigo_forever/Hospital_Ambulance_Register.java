package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hospital_Ambulance_Register extends AppCompatActivity {

    public void revertBack(View view){

        Intent intent = new Intent(this, Hospital_Login_Register.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_ambulance_register_activity);
    }
}