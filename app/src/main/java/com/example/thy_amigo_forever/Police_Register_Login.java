package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Police_Register_Login extends AppCompatActivity {

    //two buttons here are for login and register respectively
    // mark the changes accordingly
    // Intends needed to navigate to
    // Police_Mainframe and Police_Registry Respectively hi

    public void login(View view){

        Intent intent = new Intent(this, Police_Mainframe.class);
        startActivity(intent);
    }

    public void register(View view){

        Intent intent = new Intent(this, Police_Registry.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_register_login_activity);
    }
}