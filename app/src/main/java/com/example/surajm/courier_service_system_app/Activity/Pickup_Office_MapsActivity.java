package com.example.surajm.courier_service_system_app.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.surajm.courier_service_system_app.Fragments.Office_DialogFragment;
import com.example.surajm.courier_service_system_app.Other.OfficeDetails;
import com.example.surajm.courier_service_system_app.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

public class Pickup_Office_MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    FragmentManager fragmentmanager = getSupportFragmentManager();
    Dictionary<String,OfficeDetails> serchedoffice = new Dictionary<String, OfficeDetails>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Enumeration<String> keys() {
            return null;
        }

        @Override
        public Enumeration<OfficeDetails> elements() {
            return null;
        }

        @Override
        public OfficeDetails get(Object o) {
            return null;
        }

        @Override
        public OfficeDetails put(String s, OfficeDetails officeDetails) {
            return null;
        }

        @Override
        public OfficeDetails remove(Object o) {
            return null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup__office__maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //Show back button on actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        serchedoffice.put("C-DAC"+" Knowledge Park",new OfficeDetails("C-DAC","Knowledge Park",
                "Opp HAL aroengine Division,Old Madrash Road,Bengalore,Karnataka",
                "1234567890","560016",12.989524, 77.652535));
        serchedoffice.put("DTDC"+" Knowledge Park",new OfficeDetails("DTDC","Indiranagar",
                "\"55, Indiranagar Double Road, Stage 3, Indiranagar, Bengaluru, Karnataka",
                "1234567890","560038",12.973156, 77.635961));
        serchedoffice.put("The Professional Couriers"+" Pai Layout",new OfficeDetails("The Professional Couriers","Pai Layout",
                "1st Floor, R.K. Sridhar Complex, C V Raman Nagar, Nagavarapalya, Bengaluru, Karnataka",
                "1234567890","560093",12.989913, 77.663696));



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        for ( OfficeDetails value : serchedoffice.get() ) {
//        }

        // Add a marker in Map and move the camera
        Marker marker1 = mMap.addMarker(new MarkerOptions().position(new LatLng(12.989524, 77.652535)).title("C-DAC Knowledge Park"));
        marker1.showInfoWindow();
        Marker marker2 = mMap.addMarker(new MarkerOptions().position(new LatLng(12.982891, 77.637749)).title("DTDC"));
        marker2.showInfoWindow();
        Marker marker3 = mMap.addMarker(new MarkerOptions().position(new LatLng(12.990027, 77.663729)).title("The Professional Couriers"));
        marker3.showInfoWindow();

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        //the include method will calculate the min and max bound.
        builder.include(marker1.getPosition());
        builder.include(marker2.getPosition());
        builder.include(marker3.getPosition());


        LatLngBounds bounds = builder.build();

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (width * 0.10); // offset from edges of the map 12% of screen

        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
        mMap.animateCamera(cu);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //Enable GPS Location on Map
        mMap.setMyLocationEnabled(true);
        //Show Zoom Control on Map
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTitle().equals("C-DAC Knowledge Park")) {

                    Office_DialogFragment alertdFragment = new Office_DialogFragment();
                    // Show Alert DialogFragment
                    alertdFragment.show(fragmentmanager, "Alert Dialog Fragment");
                    Bundle bundle = new Bundle();
                    bundle.putString("officeData", "C-DAC Knowledge Park");
                    alertdFragment.setArguments(bundle);
                }
                if(marker.getTitle().equals("DTDC")) {
                    Office_DialogFragment alertdFragment = new Office_DialogFragment();
                    // Show Alert DialogFragment
                    alertdFragment.show(fragmentmanager, "Alert Dialog Fragment");
                    Bundle bundle = new Bundle();
                    bundle.putString("officeData", "DTDC, Indranagar");
                    alertdFragment.setArguments(bundle);
                }
                if(marker.getTitle().equals("The Professional Couriers")) {
                    Office_DialogFragment alertdFragment = new Office_DialogFragment();
                    // Show Alert DialogFragment
                    alertdFragment.show(fragmentmanager, "Alert Dialog Fragment");
                    Bundle bundle = new Bundle();
                    bundle.putString("officeData", "The Professional Couriers, Pai Layout");
                    alertdFragment.setArguments(bundle);
                }
                return false;
            }
        });

    }
}
