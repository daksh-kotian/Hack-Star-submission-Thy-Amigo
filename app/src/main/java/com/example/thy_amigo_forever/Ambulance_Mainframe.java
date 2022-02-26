package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Ambulance_Mainframe extends AppCompatActivity {

    public void alert(View view){

        Toast.makeText(this, "Request for emergency sent to Admin", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Waiting for Admin Confirmation", Toast.LENGTH_SHORT).show();
    }

    public void maps(View view){

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void logout(View view){
        Intent intent = new Intent(this, Hospital_Login_Register.class);
        startActivity(intent);
    }

    //intend to Main_Maps
    // and alert
    // to send and accept permissions !

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ambulance_mainframe_activity);

        Intent intent = getIntent();
        String string = intent.getStringExtra(Hospital_Login_Register.Msg);

        TextView textView = findViewById(R.id.tv);

        textView.setText("Welcome, " + string);
    }
}