package com.plasmadev.captiondad.carddashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public class PublicacionesAdapter extends RecyclerView.Adapter<PublicacionesAdapter.PublicacionesViewHolder> {
    private List<DocumentSnapshot> r;
    private Context context;

    public PublicacionesAdapter(List<DocumentSnapshot> r, Context context) {
        this.r = r;
        this.context = context;
    }

    @NonNull
    @Override
    public PublicacionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.publicacion, parent, false);
        return new PublicacionesViewHolder(v, null, this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicacionesViewHolder publicacionesViewHolder, int i) {
        publicacionesViewHolder.setData(null);
    }

    @Override
    public int getItemCount() {
        return this.r.size();
    }

    public static class PublicacionesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView titulo, detalle, autor;
        private ImageView imagen, icon;
        private DocumentSnapshot doc;
        private Context context;

        public PublicacionesViewHolder(@NonNull View v, DocumentSnapshot d, Context context) {
            super(v);
            this.context = context;
            this.titulo = v.findViewById(R.id.feedTitle);
            this.detalle = v.findViewById(R.id.feedTextWall);
            this.autor = v.findViewById(R.id.feedUsername);
            this.imagen = v.findViewById(R.id.feedImage);
            this.icon = v.findViewById(R.feedUserIcon);
            v.findViewById(R.id.eventoCard).setOnClickListener(this);
            this.setData(d);
        }

        public void setData(DocumentSnapshot d) {
            this.doc = d;
            this.titulo.setText(doc.getString("nombre"));
            this.detalle.setText(doc.getString("detalle"));
            this.autor.setText(doc.getString("autor"));
            this.imagen.setImageBitmap(Util.findOrCreateBy(doc.getString("imagen")));
            this.icon.setImageBitmap(Util.findOrCreateBy(doc.getString("icono")));
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
