package com.example.icities;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.icities.Clases.City;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;


public class FragmentCities extends Fragment {

    private FirebaseAuth mAuth;
    private ServiceProvider serviceProvider;
    private TextView cityName;
    private List<City> cities;
    private RecyclerView recyclerView;
    private Adapter adapter;
    public FragmentCities() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_cities, container, false);

        cityName = v.findViewById(R.id.tvCitiName);
        mAuth = FirebaseAuth.getInstance();

        serviceProvider = UserData.createRetrofit();

        cities = UserData.getCities(mAuth.getUid());

        recyclerView = v.findViewById(R.id.recyclerView);

        adapter = new Adapter(cities);


        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        return v;
    }
}
