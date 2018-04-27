package id.co.venport.vendorportalandroidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TampilanAwalActivity extends AppCompatActivity {

    private Button daftarButton, masukButton, fbButton, googleButton;
    private FirebaseAuth auth;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_awal);

        auth=FirebaseAuth.getInstance();

        daftarButton =(Button)findViewById(R.id.daftarButton);
        masukButton =(Button)findViewById(R.id.masukButton);
        fbButton =(Button)findViewById(R.id.fbButton);
        googleButton =(Button)findViewById(R.id.googleButton);

        masukButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( TampilanAwalActivity.this,TampilanAwalActivity.class);
                startActivity(intent);
            }
        });

    }
}
