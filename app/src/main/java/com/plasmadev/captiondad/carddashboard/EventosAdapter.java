package com.plasmadev.captiondad.carddashboard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.QuerySnapshot;

public class EventosAdapter extends RecyclerView.Adapter<EventosAdapter.EventosViewHolder> {
    private QuerySnapshot r;

    public EventosAdapter(QuerySnapshot r) {
        this.r = r;
    }

    @NonNull
    @Override
    public EventosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EventosViewHolder eventosViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class EventosViewHolder extends RecyclerView.ViewHolder {
        public EventosViewHolder(@NonNull View v) {
            super(v);
        }
    }
}
