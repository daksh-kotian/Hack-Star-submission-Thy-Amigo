package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Police_Mainframe extends AppCompatActivity {

    Button btnalert;
    Dialog dialog;

    public void accept(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }


    //Intent to Main_Map
    // and alert
    // to inform communication with Hospital_Mainframe

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_mainframe_activity);
        btnalert=findViewById(R.id.btn_proceed);
        dialog= new Dialog(this);

        btnalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openalert();
            }
        });

    }
    //hi

    private void openalert(){
        dialog.setContentView(R.layout.alert_police_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose=dialog.findViewById(R.id.imageViewclose);
        Button btn_accept=dialog.findViewById(R.id.btn_accept);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(Police_Mainframe.this, "Close", Toast.LENGTH_SHORT).show();
            }
        });




        dialog.show();


    }

}