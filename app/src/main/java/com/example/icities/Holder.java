package com.example.icities;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icities.Clases.City;

public class Holder extends RecyclerView.ViewHolder {
    TextView cityName;
    City city;

    public Holder(@NonNull View itemView) {
        super(itemView);

        cityName = itemView.findViewById(R.id.tvCitiName);



    }

    public void bind(City city, int pos) {

        cityName.setText(city.getCityname());
    }



}
