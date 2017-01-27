package com.example.surajm.courier_service_system_app.Fragments.TabFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.surajm.courier_service_system_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RateInfoFragment extends Fragment {


    public RateInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rate_info, container, false);
    }

}
