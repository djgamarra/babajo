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

public class PublicacionesAdapter extends RecyclerView.Adapter<PublicacionesAdapter.PublicacionesViewHolder> {
    private static int[] colors = new int[4];
    private List<DocumentSnapshot> r;
    private Context context;

    public PublicacionesAdapter(List<DocumentSnapshot> r, Context context) {
        this.r = r;
        this.context = context;
    }

    @NonNull
    @Override
    public PublicacionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.evento, parent, false);
        return new PublicacionesViewHolder(v, null, this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicacionesViewHolder publicacionesViewHolder, int i) {
        publicacionesViewHolder.setData(null);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class PublicacionesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView eventoTitulo, eventoFecha;
        private DocumentSnapshot doc;
        private Context context;

        public PublicacionesViewHolder(@NonNull View v, DocumentSnapshot d, Context context) {
            super(v);
            this.context = context;
//            this.eventoTitulo = v.findViewById(R.id.eventoTitulo);
//            this.eventoFecha = v.findViewById(R.id.eventoFecha);
//            v.findViewById(R.id.eventoCard).setOnClickListener(this);
//            this.setData(d);
            
        }

        public void setData(DocumentSnapshot d) {
//            this.doc = d;
//            this.eventoTitulo.setText(this.doc.getString("nombre"));
//            this.eventoFecha.setText(this.doc.getString("fecha"));
//            this.eventoFecha.setTextColor(colors[(int) (Math.random() * colors.length)]);
        }

        @Override
        public void onClick(View view) {
//            Intent i = new Intent(this.context, Evento.class);
//            i.putExtra("img", doc.getString("imagen"));
//            i.putExtra("titulo", doc.getString("nombre"));
//            i.putExtra("fecha", doc.getString("fecha"));
//            i.putExtra("detalle", doc.getString("detalle"));
//            i.putExtra("telefono", doc.getString("telefono"));
//            i.putExtra("email", doc.getString("email"));
//            this.context.startActivity(i);
        }
    }
}
