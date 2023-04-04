package com.example.lq;

import android.annotation.SuppressLint;
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

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    EditText password ;
    EditText repassword;
    EditText UserNameET;
    EditText EmailET;
    Button SignUpAccount;
    TextView loginBtnTextView;
    ProgressBar progressBar;

    boolean passwordVisible;
    boolean  passwordunvisiable;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        UserNameET=findViewById(R.id.EditText_username);
        EmailET=findViewById(R.id.EditText_email);

        password=findViewById(R.id.EditText_password);
        repassword=findViewById(R.id.Edittext_repassword);
        SignUpAccount=findViewById(R.id.Button_Signup_Account);
        loginBtnTextView=findViewById(R.id.TextView_LoginPage);
        progressBar=findViewById(R.id.progBar);



        //Password Hide and UnHide /

        password.setOnTouchListener((view, event) -> {
            final int Right = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= password.getRight() - password.getCompoundDrawables()[Right].getBounds().width()) {
                    int selection = password.getSelectionEnd();
                    if (passwordVisible) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visible_hide, 0);
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }

                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visibility_on_show, 0);
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;

                        }
                        password.setSelection(selection);
                        return true;
                    }
                }
            }

            return false;
        });

        repassword.setOnTouchListener((view, event) -> {
            final int Right = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= repassword.getRight() - repassword.getCompoundDrawables()[Right].getBounds().width()) {
                    int selection = repassword.getSelectionEnd();
                    if (passwordunvisiable) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            repassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visible_hide, 0);
                            repassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordunvisiable = false;
                        }

                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            repassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visibility_on_show, 0);
                            repassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordunvisiable = true;

                        }
                        repassword.setSelection(selection);
                        return true;


                    }
                }
            }

            return false;
        });
        
        SignUpAccount.setOnClickListener(v-> createSignAccount());
        loginBtnTextView.setOnClickListener(view -> finish());

    }

    private void createSignAccount() {
        String Username =UserNameET.getText().toString();
        String email=EmailET.getText().toString();
        String passwordet = password.getText().toString();
        String repasswordet = repassword.getText().toString();

        boolean isValidated = validateData( Username,email,passwordet,repasswordet);
        if(!isValidated){
            return;
        }
        // all right then we will go to the Firebase account
        createAccountFirebase(Username,email,passwordet);
    }

    private void createAccountFirebase(String ignoredUsername, String email, String passwordet) {
        changeInProgress(true);

        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,passwordet).addOnCompleteListener(signup.this, task -> {
            changeInProgress(false);


            if(task.isSuccessful()){
                Utility.showToast(signup.this, "Successfully create account ,Check email to verify");
                firebaseAuth.getCurrentUser().sendEmailVerification();
                firebaseAuth.signOut();
                finish();

            }else{
                //failure
                Utility.showToast(signup.this, task.getException().getLocalizedMessage());


            }
        });

    }
    void changeInProgress(boolean inProgress){
        if (inProgress){
            progressBar.setVisibility(View.VISIBLE);
            SignUpAccount.setVisibility(View.GONE);
        }
        else{
            progressBar.setVisibility(View.GONE);
            SignUpAccount.setVisibility(View.VISIBLE);
        }

    }

    private boolean validateData(String Username,String email,String passwordet,String repasswordet){
        if(Username.isEmpty()){
            UserNameET.setError("Enter your name");
            return false;
        }

       if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
           EmailET.setError("Valied");

           return false;
       }
       if (passwordet.length()<6){
           password.setError("Password length is invalid");
           return false;
       }
       if (passwordet.equals(repassword)){
           repassword.setError("password not matched");
           return  false;
       }
       if(passwordet.isEmpty()){
           password.setError("password is empty");
       }
       if(repasswordet.isEmpty()){
           repassword.setError("Confirm password is empty");
       }

        return  true;
    }

}

