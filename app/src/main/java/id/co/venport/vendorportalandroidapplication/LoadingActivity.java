package id.co.venport.vendorportalandroidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class LoadingActivity extends AppCompatActivity {

    private Button tesButton;
    private FirebaseAuth auth;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        auth=FirebaseAuth.getInstance();

        tesButton =(Button)findViewById(R.id.tesButton);

        tesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( LoadingActivity.this,TampilanAwalActivity.class);
                startActivity(intent);
            }
        });

    }
}
