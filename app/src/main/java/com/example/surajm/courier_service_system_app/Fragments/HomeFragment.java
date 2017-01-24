package com.example.surajm.courier_service_system_app.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.surajm.courier_service_system_app.Fragments.TabFragments.PaymentFragment;
import com.example.surajm.courier_service_system_app.Fragments.TabFragments.PickupFragment;
import com.example.surajm.courier_service_system_app.Fragments.TabFragments.RateInfoFragment;
import com.example.surajm.courier_service_system_app.Fragments.TabFragments.TrackingFragment;
import com.example.surajm.courier_service_system_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static int int_items = 4;
    private int[] tabIcons = {
            R.drawable.tab_pickup_white_48,
            R.drawable.tab_payment_white_50,
            R.drawable.tab_tracking_white_48,
            R.drawable.tab_rateinfo_white_48,
    };

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View view = inflater.inflate(R.layout.fragment_home, null);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                setupTabIcons();
            }
        });


        return view;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new PickupFragment();
                case 1:
                    return new PaymentFragment();
                case 2:
                    return new TrackingFragment();
                case 3:
                    return new RateInfoFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return " PICKUP ";
                case 1:
                    return " PAYMENT ";
                case 2:
                    return " TRACKING";
                case 3:
                    return "RATE INFO";
            }
            return null;
        }

    }
}