import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thy_amigo_forever.MainActivity;

public class ambulance_mainframe extends AppCompatActivity {

public void displayToast(View view){
    Toast.makeText(ambulance_mainframe.this, "Request sent", Toast.LENGTH_SHORT).show();
}
}
