package com.example.icities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icities.Clases.City;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {

    Holder holder;
        List<City> cities;


    public Adapter(List<City> cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_holder, parent, false);

            holder = new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).bind(cities.get(position), position);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }
}
