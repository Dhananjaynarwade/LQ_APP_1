package com.example.lq;

import static com.example.lq.R.id.forgetPassword;
import static com.example.lq.R.id.fresh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText emailEditText;
    EditText password;
    boolean passwordVisible;
    TextView createAccountBtnTextview;
    Button LoginBtn;
    ProgressBar progressBar;
    TextView ForgentPassword;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText=findViewById(R.id.edittext_Loginemail);
        password=findViewById(R.id.edittext_password);
        LoginBtn=findViewById(R.id.login_loginbtn1);
        progressBar=findViewById(R.id.progBar_login);
        createAccountBtnTextview =findViewById(fresh);

        ForgentPassword=findViewById(forgetPassword);
        password=findViewById(R.id.edittext_password);


        password.setOnTouchListener((view, event) -> {
            final int Right=2;
            if(event.getAction()==MotionEvent.ACTION_UP){
                if (event.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                    int selection= password.getSelectionEnd();
                    if (passwordVisible){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visible_hide,0);
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }

                    }else{
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visibility_on_show,0);
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;

                        }
                        password.setSelection(selection);
                        return true;


                    }
                }
            }
            return false;
        });

        ForgentPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,FP.class));
                finish();
            }
        });





        LoginBtn.setOnClickListener((v )-> loginUser() );


        createAccountBtnTextview.setOnClickListener((v)->startActivity(new Intent(login.this,signup.class)));



    }

    private void loginUser() {
        String email=emailEditText.getText().toString();
        String passwordet = password.getText().toString();

        boolean isValidated = validateData(email,passwordet);
        if(!isValidated){
            return;
        }
        loginAccountInFirebase(email,passwordet);




    }

    private void loginAccountInFirebase(String email, String passwordet) {
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        changeInProgress(true);
        firebaseAuth.signInWithEmailAndPassword(email, passwordet).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                changeInProgress(false);
                if(task.isSuccessful()){

                    if(firebaseAuth.getCurrentUser().isEmailVerified()){
                        startActivity(new Intent(login.this,Startwindow.class));

                    }else{
                        Utility.showToast(login.this,"Email not verified , Please verify your email");
                    }

                }else{
                    //login filed
                    Utility.showToast(login.this,task.getException().getLocalizedMessage());

                }




            }
        });
    }

    void changeInProgress(boolean inProgress){
        if (inProgress){
            progressBar.setVisibility(View.VISIBLE);
            LoginBtn.setVisibility(View.GONE);
        }
        else{
            progressBar.setVisibility(View.GONE);
            LoginBtn.setVisibility(View.VISIBLE);
        }

    }

    private boolean validateData(String email,String passwordet){


        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Valied");

            return false;
        }
        if (passwordet.length()<6){
            password.setError("Password length is invalid");
            return false;
        }

        if(passwordet.isEmpty()){
            password.setError("password is empty");
        }


        return  true;
    }


}