package com.plasmadev.captiondad.carddashboard;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public class EventosAdapter extends RecyclerView.Adapter<EventosAdapter.EventosViewHolder> {
    private static int[] colors = new int[4];
    private List<DocumentSnapshot> r;
    private Context context;

    public EventosAdapter(List<DocumentSnapshot> r, Context context) {
        this.r = r;
        this.context = context;
    }

    @NonNull
    @Override
    public EventosAdapter.EventosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        colors = new int[]{
                this.context.getResources().getColor(R.color.indigo),
                this.context.getResources().getColor(R.color.yellow),
                this.context.getResources().getColor(R.color.colorAccent),
                this.context.getResources().getColor(R.color.colorPrimary),
        };
        View v = LayoutInflater.from(this.context).inflate(R.layout.evento, parent, false);
        return new EventosViewHolder(v, this.r.get(i), this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull EventosViewHolder eventosViewHolder, int i) {
        eventosViewHolder.setData(this.r.get(i));
    }

    @Override
    public int getItemCount() {
        return this.r.size();
    }

    public static class EventosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView eventoTitulo, eventoFecha;
        private DocumentSnapshot doc;
        private Context context;

        public EventosViewHolder(@NonNull View v, DocumentSnapshot d, Context context) {
            super(v);
            this.context = context;
            this.eventoTitulo = v.findViewById(R.id.eventoTitulo);
            this.eventoFecha = v.findViewById(R.id.eventoFecha);
            v.findViewById(R.id.eventoCard).setOnClickListener(this);
            this.setData(d);
        }

        public void setData(DocumentSnapshot d) {
            this.doc = d;
            this.eventoTitulo.setText(this.doc.getString("nombre"));
            this.eventoFecha.setText(this.doc.getString("fecha"));
            this.eventoFecha.setTextColor(colors[(int) (Math.random() * colors.length)]);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(this.context, Evento.class);
            i.putExtra("img", doc.getString("imagen"));
            i.putExtra("titulo", doc.getString("nombre"));
            i.putExtra("fecha", doc.getString("fecha"));
            i.putExtra("detalle", doc.getString("detalle"));
            i.putExtra("contacto", doc.getString("contacto") == null ? "---" : doc.getString("contacto"));
            this.context.startActivity(i);
        }
    }
}
