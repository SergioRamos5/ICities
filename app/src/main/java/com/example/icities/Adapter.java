package com.example.icities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icities.Clases.City;

import java.util.List;

public class Adapter extends RecyclerView.Adapter implements View.OnClickListener {

    Holder holder;
    List<City> cities;
    View.OnClickListener listener;


    public Adapter(List<City> cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_holder, parent, false);
        holder = new Holder(view);
        view.setOnClickListener(this);

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

    public void setClickListener(View.OnClickListener listener){
        if (listener!=null)
            this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null)
            listener.onClick(v);
    }
}
