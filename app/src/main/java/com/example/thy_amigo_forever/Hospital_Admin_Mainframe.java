package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Hospital_Admin_Mainframe extends AppCompatActivity {


    //intent to Main_Map
    //and alert
    //to inform communication with Police_Mainframe

    public void alert(View view){

        Toast.makeText(this, "Alert Notification sent to On-Route Police for Assistance", Toast.LENGTH_SHORT).show();
    }

    public void maps(View view){

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void logout(View view){
        Intent intent = new Intent(this, Hospital_Login_Register.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_admin_mainframe_activity);

        Intent intent = getIntent();
        String string = intent.getStringExtra(Hospital_Login_Register.Msg);

        TextView textView = findViewById(R.id.tv2);

        textView.setText("Welcome, " + string);
    }
}