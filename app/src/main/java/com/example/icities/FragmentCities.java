package com.example.icities;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.icities.Clases.City;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;


public class FragmentCities extends Fragment implements OnSelectedItemListener{

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

        cities = UserDataFromRest.getCities(mAuth.getUid());


        recyclerView = v.findViewById(R.id.recyclerView);

        adapter = new Adapter(cities);


        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        adapter.setClickListener(v1 -> {
            int pos =  recyclerView.getChildAdapterPosition(v1);
            City c = createObjectCity(pos);
            onItemSelected(c);
        });

        return v;
    }

    public City createObjectCity(int pos){
        return new City(cities.get(pos).getId(), cities.get(pos).getCityname(), cities.get(pos).getCountryname(),
                cities.get(pos).getRegionname(), cities.get(pos).getCreatoruid());
    }

    @Override
    public void onItemSelected(City c) {
        Fragment fragment = new FragmentPlaces();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        args.putParcelable("Ciudad", c);
        FragmentManager FM = getActivity().getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fragment_container, fragment);
        FT.addToBackStack("City");
        FT.commit();
    }
}
