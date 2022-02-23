package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Hospital_Admin_Mainframe extends AppCompatActivity {


    //intent to Main_Map
    //and alert
    //to inform communication with Police_Mainframe

    public void alert(View view){

        Toast.makeText(this, "Alert sent to Hospital-Admin", Toast.LENGTH_SHORT).show();
    }

    public void maps(View view){

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_admin_mainframe_activity);
    }
}