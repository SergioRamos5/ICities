package com.example.icities;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.icities.Clases.City;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPlaces extends Fragment {


    public FragmentPlaces() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_places, container, false);
        City c = new City();
        c = getArguments().getParcelable("Ciudad");
        Toast.makeText(getContext(), c.getCityname(), Toast.LENGTH_SHORT).show();

        return v;
    }


}
