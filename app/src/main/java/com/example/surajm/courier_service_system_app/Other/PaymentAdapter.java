package com.example.surajm.courier_service_system_app.Other;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.surajm.courier_service_system_app.Activity.MainActivity;
import com.example.surajm.courier_service_system_app.Activity.PaymentActivity;
import com.example.surajm.courier_service_system_app.R;

import java.util.ArrayList;

/**
 * Created by Suraj m on 25-01-2017.
 */

public class PaymentAdapter extends BaseAdapter {

    private Context activity;
    private ArrayList<ConsinementDetails> ConsinmentList;
//    private static LayoutInflater inflater=null;

    public PaymentAdapter(Activity activity, ArrayList<ConsinementDetails> consinmentList) {
        this.activity = activity;
        ConsinmentList = consinmentList;
    }

    @Override
    public int getCount() {
        return ConsinmentList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vi =View.inflate(activity,R.layout.payment_rowlayout,null);

        TextView reqid = (TextView)vi.findViewById(R.id.reqIdTextView);
        TextView date = (TextView)vi.findViewById(R.id.dateTextView);
        ImageView pickupimg = (ImageView)vi.findViewById(R.id.pickupimage);
        ImageView paymentimg = (ImageView)vi.findViewById(R.id.paymentimage);
        ImageView paymentcompany = (ImageView)vi.findViewById(R.id.paymentImageviewcompany);
        ImageButton next = (ImageButton)vi.findViewById(R.id.next);

        if (ConsinmentList.get(i).getCompanyname().equals("bluedart"))
        {
            paymentcompany.setImageResource(R.drawable.bule_dart_white);
        }
        if (ConsinmentList.get(i).getCompanyname().equals("dhl"))
        {
            paymentcompany.setImageResource(R.drawable.dhl_white);
        }
        reqid.setText(ConsinmentList.get(i).getReqId());
        date.setText(ConsinmentList.get(i).getDate());

        if (ConsinmentList.get(i).getPickupStatus().equals("done"))
        {
            pickupimg.setImageResource(R.drawable.complete_white);
        }
        else
        {
            pickupimg.setImageResource(R.drawable.inprogress_white);
        }
        if (ConsinmentList.get(i).getPaymentStatus().equals("done"))
        {
            paymentimg.setImageResource(R.drawable.complete_white);
        }
        else
        {
            paymentimg.setImageResource(R.drawable.pending_white);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, PaymentActivity.class);
                i.putExtra("conindex",i.toString());
                activity.startActivity(i);

            }
        });

        return vi;
    }
}
