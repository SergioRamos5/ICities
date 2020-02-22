package com.example.icities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public abstract class Adapter<T> extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener {

    Context context;
    Holder holder;
    int cardviewLayout;
    AdapterNotifierArrayList<T> binding;
    RecyclerView recyclerView;

    public Adapter(Context context, RecyclerView recyclerView, int cardviewLayout, List<T> binding) {
        this.context = context;
        this.cardviewLayout = cardviewLayout;
        this.binding = new AdapterNotifierArrayList<>(binding);
        this.recyclerView = recyclerView;

        setRecyclerView();
    }

    public Adapter(Context context, RecyclerView recyclerView, int cardviewLayout, ArrayList<T> binding) {
        this.context = context;
        this.cardviewLayout = cardviewLayout;
        this.binding = new AdapterNotifierArrayList<>(binding);
        this.recyclerView = recyclerView;

        setRecyclerView();
    }

    private void setRecyclerView()
    {
        this.recyclerView.setAdapter(this);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(cardviewLayout, parent, false);
        holder = new Holder(view);
        holder.view.setOnClickListener(this);
        holder.view.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {}

    @Override
    public int getItemCount() {
        return binding.size();
    }

    public View getView() {
        return holder.view;
    }

    public AdapterNotifierArrayList<T> getBinding() {
        return binding;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public void onClick(View view) {}

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    private class Holder extends RecyclerView.ViewHolder {

        View view;

        public Holder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }

    class AdapterNotifierArrayList<J> extends ArrayList<J> implements List<J> {

        public AdapterNotifierArrayList(List<J> binding) {
            super.addAll(binding);
        }

        public AdapterNotifierArrayList(ArrayList<J> binding) {
            super.addAll(binding);
        }

        @Override
        public J set(int i, J t) {
            J res = super.set(i, t);
            notifyItemChanged(i);
            return res;
        }

        @Override
        public void add(int i, J t) {
            super.add(i, t);
            notifyItemInserted(i);
        }

        @Override
        public J remove(int i) {
            J res = super.remove(i);
            notifyItemRemoved(i);
            return res;
        }

        @Override
        protected void removeRange(int fromIndex, int toIndex) {
            super.removeRange(fromIndex, toIndex);
            notifyItemRangeRemoved(fromIndex, toIndex);
        }
    }
}
