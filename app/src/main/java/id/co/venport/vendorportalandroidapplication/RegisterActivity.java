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

public class RegisterActivity extends AppCompatActivity {

    private EditText namaEdit, emailEdit, hpEdit, passwordEdit, ulangpasswordEdit;
    private Button daftarButton;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth=FirebaseAuth.getInstance();

        namaEdit =(EditText)findViewById(R.id.namaEdit);
        emailEdit =(EditText)findViewById(R.id.emailEdit);
        hpEdit =(EditText)findViewById(R.id.hpEdit);
        passwordEdit =(EditText)findViewById(R.id.passwordEdit);
        ulangpasswordEdit =(EditText)findViewById(R.id.ulangpasswordEdit);;
        daftarButton =(Button)findViewById(R.id.daftarButton);

        daftarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerFunction();
            }
        });
    }

    private void registerFunction() {

        String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        String nama = namaEdit.getText().toString();
        String hp = hpEdit.getText().toString();
        String ulangpassword = ulangpasswordEdit.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Please enter your email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Please enter your password",Toast.LENGTH_SHORT).show();
        }
        if (password.length()<6){
            Toast.makeText(getApplicationContext(),"Password must be at least 6 digits", Toast.LENGTH_SHORT).show();
        }

        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Authorization Error",
                                    Toast.LENGTH_SHORT).show();
                        }

                        else {
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                            finish();
                        }

                    }
                });
    }

}
