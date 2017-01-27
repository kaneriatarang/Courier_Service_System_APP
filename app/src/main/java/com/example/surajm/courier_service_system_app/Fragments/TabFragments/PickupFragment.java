package com.example.surajm.courier_service_system_app.Fragments.TabFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.surajm.courier_service_system_app.Activity.Pickup_Office_MapsActivity;
import com.example.surajm.courier_service_system_app.Other.ConsinementDetails;
import com.example.surajm.courier_service_system_app.R;

import static com.example.surajm.courier_service_system_app.Activity.MainActivity.ConsinmentList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PickupFragment extends Fragment {

    Button search_Button;

    public PickupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_pickup, container, false);
        search_Button = (Button)view.findViewById(R.id.search_office_Button);

        addData();
        search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Pickup_Office_MapsActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
    public void addData() {
        ConsinmentList.add(new ConsinementDetails("RD101010", "bluedart", "12-05-2016", "done", "done", "300"));
        ConsinmentList.add(new ConsinementDetails("RD202020", "dhl", "20-05-2016", "not", "not", "250"));
    }
}
