package com.example.surajm.courier_service_system_app.Fragments.TabFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.surajm.courier_service_system_app.Activity.Login_mainActivity;
import com.example.surajm.courier_service_system_app.Activity.MainActivity;
import com.example.surajm.courier_service_system_app.Activity.SplashActivity;
import com.example.surajm.courier_service_system_app.LoginActivity;
import com.example.surajm.courier_service_system_app.Other.ConsinementDetails;
import com.example.surajm.courier_service_system_app.Other.PaymentAdapter;
import com.example.surajm.courier_service_system_app.R;

import java.util.ArrayList;

import static com.example.surajm.courier_service_system_app.Activity.MainActivity.ConsinmentList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment {


    PaymentAdapter adapter;
    ListView paymentListView;

    public PaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        Button search = (Button)view.findViewById(R.id.show);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), SplashActivity.class);
                startActivity(i);
            }
        });


        paymentListView = (ListView)view.findViewById(R.id.listViewPayment);
        adapter = new PaymentAdapter(getActivity(),ConsinmentList);
        paymentListView.setAdapter(adapter);
        return view;
    }


}
