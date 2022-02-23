package com.example.thy_amigo_forever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Hospital_Login_Register extends AppCompatActivity {

    //this is the line that I wrote and ...
    //this is basically a Function that I also has defined in the attribute
    //of Log-In button as onClick() and this basically indicates,
    // what action will be performed upon the click of that button
    public void logIn(View view){

        //Declaring two Edittext that connects to our fields in XML file to further retrieve info from them
        EditText UserID = findViewById(R.id.UserID);
        EditText Password = findViewById(R.id.Password);

        //I'm taking in values from my respective fields as String to further compare them.
        String userID = UserID.getText().toString();
        String password = Password.getText().toString();
        //Two times for two values to be compared as Admin and Ambulance LogIn's
        //String ambID = UserID.getText().toString();
        //String ambPd = Password.getText().toString();
        //Creating My Own String To then Compare the abv Ones too...
        String AdminID = "Mangalam"; //...................................admin login id String
        String AdminPD = "Charu"; //...................................admin login Password
        //Again twice to serve two diff login's at once !
        String AmbId = "Daksh";//...........................................ambulance login Id
        String AmbPd = "Astha";//...........................................ambulance login Password

        //Main Logic - to compare individually each string to differentiate the Log-In and henceforth take them to Diff Intent
        if(userID.equals(AdminID) && password.equals(AdminPD)){
            //this if - for admin check
            Intent intent = new Intent(this, Hospital_Admin_Mainframe.class);
        }
        else if (userID.equals(AmbId) && password.equals(AmbPd)){
            //this if - for ambulance check
            Intent intent = new Intent(this, Ambulance_Mainframe.class);
        }
        else{
            //this check - for invalid Id's and Passwords
            Toast.makeText(this, "Incorrect UserID & Password !", Toast.LENGTH_SHORT).show();
        }
    }

    public void adminReg(View view){

        //jisko ye page mile, congrats
        // addhe se jyada kaam done hai,
        // iss funtion ko intent krdo to
        //Hospital_Ambulance_Register
        //ye function, second button ke OnClick ka hissa hai... Just FYI....
    }
    //my written code ends here !!!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_login_register_activity);
    }
}