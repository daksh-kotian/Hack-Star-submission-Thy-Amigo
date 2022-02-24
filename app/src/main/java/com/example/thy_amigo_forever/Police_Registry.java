package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Police_Registry extends AppCompatActivity {

    public void submit(View view){

        Intent intent = new Intent(this, Police_Register_Login.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_registry_activity);
    }
}