package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn_proceed;
    Button btn_hospital;
    Button btn_police;
    Dialog dialog;

    //A pop-up is needed upon the single button
    //with 2 more buttons to navigate to :
    // Hospital_Login_Register
    // &
    // Police_Register_Login
    // respectively...

    //this is how you create a intent !
    public void hospital(View view){

        Intent intent = new Intent(this, Hospital_Login_Register.class);
        startActivity(intent);
    }

    public void police(View view){

        Intent intent = new Intent(this, Police_Register_Login.class);
        startActivity(intent);
    }

    // Ignore the Login_and_Register Activity For RN !

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_hospital=findViewById(R.id.btn_hospital);
        btn_police=findViewById(R.id.btn_police);

        btn_proceed=findViewById(R.id.btn_proceed);
        dialog= new Dialog(this);

        btn_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openalert();
            }
        });

    }

    private void openalert(){
        dialog.setContentView(R.layout.proceed_popup);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

       dialog.show();
    }

}