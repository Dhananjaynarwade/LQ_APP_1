package com.example.lq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forget_password extends AppCompatActivity {
    private EditText forgetEmail;
    private Button forgetPassword;
    private String email;
    ProgressBar progressBar;

    public static void setOnClickListener(Object o) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        forgetEmail = findViewById(R.id.edittext_Loginemail_forgetpassword);
        forgetPassword=findViewById(R.id.forgetBtn);
         forgetPassword.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
              email=forgetEmail.getText().toString();

              if (email.isEmpty()){
                  Toast.makeText(forget_password.this, "Please Enter your email", Toast.LENGTH_SHORT).show();
              }
              else{
                  forgetpasswordfor();
              }
             }
         });
    }

    private void forgetpasswordfor() {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if ((task.isSuccessful())){
                            Toast.makeText(forget_password.this, "Check your email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(forget_password.this,login.class));
                            finish();

                        }
                        else {
                            Toast.makeText(forget_password.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}