package com.example.surajm.courier_service_system_app.Activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.surajm.courier_service_system_app.DatabseBackgroundWorker.RegistrationBackWorker;
import com.example.surajm.courier_service_system_app.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    Button register,backLogin;
    RadioButton u_male,u_female;
    EditText nameregi,mobileNumber,address,pincode,email,usernameregi,passwordregi,conPassword;
    TextInputLayout nameregiRap,mobileNumberRap,addressRap,pincodeRap,emailRap,usernameregiRap,passwordregiRap,conPasswordRap;
    int fname = 0,fmobilenumber = 0,faddress = 0,fpincode = 0,femail = 0,fusername = 0,fpassword = 0,fconpasword = 0;

    Pattern emailpattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    Pattern stringpattern = Pattern.compile("^[a-zA-Z\n]*");
    Matcher matcherString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Show back button on actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //set title on actionbar
        setTitle("User Registration");
        setContentView(R.layout.activity_registration);

        u_male = (RadioButton)findViewById(R.id.radio_male);
        u_female = (RadioButton)findViewById(R.id.radio_Female);

        nameregi = (EditText)findViewById(R.id.name__regi_edtext);
        nameregiRap = (TextInputLayout)findViewById(R.id.name__regi_edtext_rap);

        //---------------validating name----------------------------
        nameregi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                matcherString = stringpattern.matcher(charSequence);
                boolean valid = matcherString.matches();

                if (charSequence.length() == 0) {
                    nameregi.setCompoundDrawablesWithIntrinsicBounds(0, 0,0,0);
                    nameregiRap.setError(getString(R.string.error_field_required));
                    nameregiRap.setErrorEnabled(true);
                    fname = 0;
                }
                else if (!valid) {
                    nameregi.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wrong_check_24,0);
                    nameregiRap.setError(getString(R.string.error_invalid_name));
                    nameregiRap.setErrorEnabled(true);
                    fname = 0;
                }
                else {
                    nameregi.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_check_24,0);
                    nameregiRap.setErrorEnabled(false);
                    fname = 1;
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //---------------validating mobilenumber----------------------------
        mobileNumber = (EditText)findViewById(R.id.mobile_Number_edtext);
        mobileNumberRap = (TextInputLayout)findViewById(R.id.mobile_Number_edtext_rap);

        mobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() == 0) {
                    mobileNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0,0,0);
                    mobileNumberRap.setError(getString(R.string.error_field_required));
                    mobileNumberRap.setErrorEnabled(true);
                    fmobilenumber = 0;
                }
                else if (charSequence.length() != 10) {
                    mobileNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wrong_check_24,0);
                    mobileNumberRap.setError(getString(R.string.error_invalid_mobileNumber));
                    mobileNumberRap.setErrorEnabled(true);
                    fmobilenumber = 0;
                }
                else {
                    mobileNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_check_24,0);
                    mobileNumberRap.setErrorEnabled(false);
                    fmobilenumber = 1;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //---------------validating address----------------------------
        address = (EditText)findViewById(R.id.address_edtext);
        addressRap = (TextInputLayout)findViewById(R.id.address_edtext_rap);

        address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                address.setCompoundDrawablesWithIntrinsicBounds(0, 0,0,0);
                addressRap.setError(getString(R.string.error_field_required));
                addressRap.setErrorEnabled(true);
                faddress = 0;
            }
            else {
                address.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_check_24,0);
                addressRap.setErrorEnabled(false);
                faddress = 1;
            }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //---------------validating pincode----------------------------
        pincode = (EditText)findViewById(R.id.pincode_edtext);
        pincodeRap = (TextInputLayout)findViewById(R.id.pincode_edtext_rap);

        pincode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() == 0) {
                    pincode.setCompoundDrawablesWithIntrinsicBounds(0, 0,0,0);
                    pincodeRap.setError(getString(R.string.error_field_required));
                    pincodeRap.setErrorEnabled(true);
                    fpincode = 0;
                }
                else if (charSequence.length() != 6) {
                    pincode.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wrong_check_24,0);
                    pincodeRap.setError(getString(R.string.error_invalid_pincode));
                    pincodeRap.setErrorEnabled(true);
                    fpincode = 0;
                }
                else {
                    pincode.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_check_24,0);
                    pincodeRap.setErrorEnabled(false);
                    fpincode = 1;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //---------------validating email----------------------------
        email = (EditText)findViewById(R.id.email_edtext);
        emailRap = (TextInputLayout)findViewById(R.id.email_edtext_rap);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                matcherString = emailpattern.matcher(charSequence);
                boolean valid = matcherString.matches();

                if (charSequence.length() == 0) {
                    email.setCompoundDrawablesWithIntrinsicBounds(0, 0,0,0);
                    emailRap.setError(getString(R.string.error_field_required));
                    emailRap.setErrorEnabled(true);
                    femail = 0;
                }
                else if (!valid) {
                    email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wrong_check_24,0);
                    emailRap.setError(getString(R.string.error_invalid_email));
                    emailRap.setErrorEnabled(true);
                    femail = 0;
                }
                else {
                    email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_check_24,0);
                    emailRap.setErrorEnabled(false);
                    femail = 1;
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //---------------validating username----------------------------
        usernameregi = (EditText)findViewById(R.id.username_regi_edtext);
        usernameregiRap = (TextInputLayout)findViewById(R.id.username_regi_edtext_rap);
        usernameregi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() == 0) {
                    usernameregi.setCompoundDrawablesWithIntrinsicBounds(0, 0,0,0);
                    usernameregiRap.setError(getString(R.string.error_field_required));
                    usernameregiRap.setErrorEnabled(true);
                    fusername = 0;
                }
                else {
                    usernameregi.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_check_24,0);
                    usernameregiRap.setErrorEnabled(false);
                    fusername = 1;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //---------------validating password----------------------------
        passwordregi = (EditText)findViewById(R.id.password_regi_edtext);
        passwordregiRap = (TextInputLayout)findViewById(R.id.passwd_regi_edtext_rap);

        passwordregi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() == 0) {
                    passwordregi.setCompoundDrawablesWithIntrinsicBounds(0, 0,0,0);
                    passwordregiRap.setError(getString(R.string.error_field_required));
                    passwordregiRap.setErrorEnabled(true);
                    fpassword = 0;
                }
                else if (charSequence.length() < 6) {
                    passwordregi.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wrong_check_24,0);
                    passwordregiRap.setError(getString(R.string.error_invalid_password));
                    passwordregiRap.setErrorEnabled(true);
                    fpassword = 0;
                }
                else {
                    passwordregi.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_check_24,0);
                    passwordregiRap.setErrorEnabled(false);
                    fpassword = 1;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        ---------------validating confirm password----------------------------
        conPassword = (EditText)findViewById(R.id.confirmPassword_edtext);
        conPasswordRap = (TextInputLayout)findViewById(R.id.confirmPassword_edtext_rap);

        conPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Pattern passwordcheck = Pattern.compile(passwordregi.getText().toString());
                matcherString = passwordcheck.matcher(charSequence);
                boolean valid = matcherString.matches();

                if (charSequence.length() == 0) {
                    conPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,0,0);
                    conPasswordRap.setError(getString(R.string.error_field_required));
                    conPasswordRap.setErrorEnabled(true);
                    fconpasword = 0;
                }
                else if (!valid) {
                    conPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wrong_check_24,0);
                    conPasswordRap.setError(getString(R.string.error_incorrect_conpassword));
                    conPasswordRap.setErrorEnabled(true);
                    fconpasword = 0;
                }
                else {
                    conPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_check_24,0);
                    conPasswordRap.setErrorEnabled(false);
                    fconpasword = 1;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        register = (Button)findViewById(R.id.btnRegister_regi);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fname == 1 && fmobilenumber == 1 && faddress == 1 && fpincode == 1 && femail == 1 &&fusername == 1 &&fpassword == 1 &&fconpasword == 1)
                {
                    Toast.makeText(RegistrationActivity.this, "Register Process", Toast.LENGTH_SHORT).show();
                    String str_name  = nameregi.getText().toString();
                    String str_mobile  = mobileNumber.getText().toString();
                    String str_address  = address.getText().toString();
                    String str_pincode  = pincode.getText().toString();
                    String str_male = u_male.getText().toString();
                    String str_female = u_female.getText().toString();
                    String str_email = email.getText().toString();
                    String str_username = usernameregi.getText().toString();
                    String str_pass = passwordregi.getText().toString();

                    String type = "register";

                    String Gender = "male";
                    String send_gender = "";
                    if(Gender == str_male)
                    {
                        send_gender = str_male;
                    }
                    else
                    {
                        send_gender = str_female;
                    }

                    RegistrationBackWorker backgroundWorker = new RegistrationBackWorker(RegistrationActivity.this);
                    backgroundWorker.execute(type,str_name,str_mobile,str_address,str_pincode,send_gender,str_email,str_username,str_pass);

                }
                else
                {
                    Toast.makeText(RegistrationActivity.this, "All Fields must be fill", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backLogin = (Button)findViewById(R.id.goLogin);
        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistrationActivity.this,Login_mainActivity.class);
                startActivity(i);
            }
        });


    }
}
