package com.example.icities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class FragmentTabs extends Fragment {

    TabLayout tabs;

    public FragmentTabs() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tabs, container, false);

        tabs = v.findViewById(R.id.tablayout);
        tabs.addTab(tabs.newTab().setText("Cities"));
        tabs.addTab(tabs.newTab().setText("Bios"));


        final ViewPager mviewPager = v.findViewById(R.id.viewPager);
        final PagerAdapter adapter = new PagerAdapter(getActivity().getSupportFragmentManager(), tabs.getTabCount());
        mviewPager.setAdapter(adapter);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mviewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return v;
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        int NumOfTabs;

        public PagerAdapter(@NonNull FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.NumOfTabs = NumOfTabs;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentCities();
                case 1:
                    return new FragmentBio();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NumOfTabs;
        }
    }
}
