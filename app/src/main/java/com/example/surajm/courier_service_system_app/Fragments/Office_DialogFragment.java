package com.example.surajm.courier_service_system_app.Fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.surajm.courier_service_system_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Office_DialogFragment extends DialogFragment {


    public Office_DialogFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_office__dialog, container, false);
//    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String officename = getArguments().getString("officeData");
        return new AlertDialog.Builder(getActivity())
                // Set Dialog Icon
                .setIcon(R.drawable.ic_audiotrack)
                // Set Dialog Title
                .setTitle("Office Details")
                // Set Dialog Message
                .setMessage(officename)

                // Positive button
                .setPositiveButton("Pickup", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Pickup Request Done", Toast.LENGTH_SHORT).show();
                    }
                })

                // Negative Button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,	int which) {
                        // Do something else
                    }
                }).create();
    }

}
