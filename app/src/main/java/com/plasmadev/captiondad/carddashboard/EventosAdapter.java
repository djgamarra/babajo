package com.plasmadev.captiondad.carddashboard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public class EventosAdapter extends RecyclerView.Adapter<EventosAdapter.EventosViewHolder> {
    private List<DocumentSnapshot> r;

    public EventosAdapter(List<DocumentSnapshot> r) {
        this.r = r;
    }

    @NonNull
    @Override
    public EventosAdapter.EventosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento, parent, false);
        return new EventosViewHolder(v, this.r.get(i));
    }

    @Override
    public void onBindViewHolder(@NonNull EventosViewHolder eventosViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return this.r.size();
    }

    public static class EventosViewHolder extends RecyclerView.ViewHolder {
        TextView eventoTitulo, eventoFecha;

        public EventosViewHolder(@NonNull View v, DocumentSnapshot d) {
            super(v);
            this.eventoTitulo = v.findViewById(R.id.eventoTitulo);
            this.eventoFecha = v.findViewById(R.id.eventoFecha);
            this.setData(d);
        }

        public void setData(DocumentSnapshot d) {
            this.eventoTitulo.setText(d.getString("nombre"));
            this.eventoFecha.setText(d.getString("fecha"));
        }
    }
}
