package com.example.icities;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.icities.Clases.City;
import com.example.icities.Clases.UserDataFromRest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FragmentCities extends Fragment implements OnSelectedItemListener {

    private FirebaseAuth mAuth;
    private ServiceProvider serviceProvider;
    private TextView cityName;
    private List<City> cities;
    private RecyclerView recyclerView;

    public FragmentCities() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cities, container, false);

        cityName = v.findViewById(R.id.tvCitiName);
        mAuth = FirebaseAuth.getInstance();

        cities = UserDataFromRest.getCities(mAuth.getUid());


        recyclerView = v.findViewById(R.id.recyclerView);

        CityAdapter adapter = new CityAdapter(getContext(), recyclerView, R.layout.city_holder, cities);

        FloatingActionButton fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            LayoutInflater inflater1 = getActivity().getLayoutInflater();

            View v1 = inflater1.inflate(R.layout.add_dialog, null);

            EditText cityName = v1.findViewById(R.id.et_cityNameDialog);
            EditText country = v1.findViewById(R.id.et_countryDialog);
            EditText region = v1.findViewById(R.id.et_regionDialog);
            //Cogemos la vista para trabajar dentro de ella.
            builder.setView(v1);

            builder.setPositiveButton("Add", (dialog, which) -> {
                UserDataFromRest.insertCity(new City(cityName.getText().toString(), country.getText().toString(), region.getText().toString(), mAuth.getUid()));
                List<City> aux = UserDataFromRest.getCities(mAuth.getUid());
                adapter.getBinding().add(aux.get(aux.size() - 1));
            });

            builder.setNegativeButton("Cancel", (dialog, which) -> {

            });


            ImageView image = v1.findViewById(R.id.imageDialog);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v1) {

                }
            });

            builder.create();
            builder.show();
        });

        return v;
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

    private class CityAdapter extends Adapter<City> {


        public CityAdapter(Context context, RecyclerView recyclerView, int cardviewLayout, List<City> binding) {
            super(context, recyclerView, cardviewLayout, binding);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            TextView textView = getView().findViewById(R.id.tvCitiName);
            textView.setText(getBinding().get(position).getCityname());

            textView = getView().findViewById(R.id.tvCountry);
            textView.setText(getBinding().get(position).getRegionname());

            ImageView image = getView().findViewById(R.id.imageCityPrincipal);

            StorageReference ref = FirebaseStorage.getInstance().getReferenceFromUrl("gs://icities-eda4d.appspot.com/"+ getBinding().get(position).getId() + "/img.png");
            ref.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    try {
                        Picasso.get().load(task.getResult()).into(image);
                    } catch (Exception e) {
                        image.setImageResource(R.drawable.ciudad);
                    }
                }
            });


        }

        @Override
        public void onClick(View v) {
            int pos = recyclerView.getChildAdapterPosition(v);
            onItemSelected(cities.get(pos));
        }

        @Override
        public boolean onLongClick(View view) {
            int pos = recyclerView.getChildAdapterPosition(view);

            cities.get(pos).deleteFromDBForce();
            getBinding().remove(pos);
            return false;
        }
    }

}
