package com.example.surajm.courier_service_system_app.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaCodec;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.surajm.courier_service_system_app.DatabseBackgroundWorker.LoginBackWorker;
import com.example.surajm.courier_service_system_app.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_mainActivity extends AppCompatActivity {

    Button signUP,loginBtn,forgotPassword;
    EditText username,password;
    public static ProgressBar progress;
    TextInputLayout usernamerap,passwordrap;
    int fusername = 0,fpassword = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        setTitle("User Login");

        progress = (ProgressBar)findViewById(R.id.progressBar);

        username = (EditText)findViewById(R.id.username_edtext);
        password = (EditText)findViewById(R.id.passwd_edtext);
        usernamerap = (TextInputLayout)findViewById(R.id.username_edtext_rep);
        passwordrap = (TextInputLayout)findViewById(R.id.password_edtext_rep);

        //---------------validating username----------------------------
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() == 0) {
                        username.setCompoundDrawablesWithIntrinsicBounds(0, 0,0,0);
                        usernamerap.setError(getString(R.string.error_field_required));
                        usernamerap.setErrorEnabled(true);
                        fusername = 0;
                    }
                else {
                        username.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_check_24,0);
                        usernamerap.setErrorEnabled(false);
                        fusername = 1;
                    }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //---------------validating pasword----------------------------
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if (charSequence.length() == 0) {
                    password.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
                    passwordrap.setError(getString(R.string.error_field_required));
                    passwordrap.setErrorEnabled(true);
                    fpassword = 0;
                } else {
                    password.setCompoundDrawablesWithIntrinsicBounds(0, 0,R.drawable.right_check_24,0);
                    passwordrap.setErrorEnabled(false);
                    fpassword = 1;
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        loginBtn = (Button)findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fusername == 1 && fpassword == 1) {
                    String str_uname = username.getText().toString();
                    String str_password = password.getText().toString();

                    String type = "login";
                    LoginBackWorker loginBackgroundWorker = new LoginBackWorker(Login_mainActivity.this);
                    loginBackgroundWorker.execute(type,str_uname,str_password);
                }
            }
        });

        signUP = (Button)findViewById(R.id.register_Btn);
        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent i = new Intent(Login_mainActivity.this, RegistrationActivity.class);
                    startActivity(i);
            }
        });

    }
}
