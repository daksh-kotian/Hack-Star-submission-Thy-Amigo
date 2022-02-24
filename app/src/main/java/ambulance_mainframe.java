import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thy_amigo_forever.MainActivity;
import com.example.thy_amigo_forever.MapsActivity;

public class ambulance_mainframe extends AppCompatActivity {

    public void viewmap(View view){
        Intent intent= new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

public void displayToast(View view){
    Toast.makeText(ambulance_mainframe.this, "Request sent", Toast.LENGTH_SHORT).show();
}
}
