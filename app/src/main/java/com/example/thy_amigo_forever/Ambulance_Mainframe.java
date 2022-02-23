package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ambulance_Mainframe extends AppCompatActivity {

    public void alert(View view){


    }

    public void maps(View view){

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    //intend to Main_Maps
    // and alert
    // to send and accept permissions !

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ambulance_mainframe_activity);
    }
}