package com.example.surajm.courier_service_system_app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.surajm.courier_service_system_app.Other.ConsinementDetails;
import com.example.surajm.courier_service_system_app.R;

import static com.example.surajm.courier_service_system_app.Activity.MainActivity.ConsinmentList;

public class PaymentActivity extends AppCompatActivity {

    private TextView requestID,amount;
    private Button submit;
    int flage = 0;
    String paymentmode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        requestID = (TextView)findViewById(R.id.reqIdTextView);
        amount = (TextView)findViewById(R.id.amountTextView);

        String index = getIntent().getStringExtra("index").toString();
        int i = Integer.parseInt(index);

        requestID.setText(ConsinmentList.get(i).getReqId());
        amount.setText(ConsinmentList.get(i).getAmount());

        submit = (Button)findViewById(R.id.submit_payment_Button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this, "payment process", Toast.LENGTH_SHORT).show();
            }
        });

        }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.coh_RadioButton:
                if (checked)
                    paymentmode = "coh";
                    flage =1;
                    break;
            case R.id.netBank_RadioButton:
                if (checked)
                    paymentmode = "netbanking";
                    flage =1;
                    break;
            case R.id.card_RadioButton:
                if (checked)
                    paymentmode = "card";
                    flage =1;
                    break;
        }
    }

    }

