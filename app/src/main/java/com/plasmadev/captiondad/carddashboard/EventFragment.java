package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class EventFragment extends Fragment implements View.OnClickListener {

    public EventFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);
        v.setOnClickListener(this);
        String fecha = getArguments().getString("fecha");
        String titulo = getArguments().getString("titulo");
        ((TextView) v.findViewById(R.id.eventoFecha)).setText(fecha);
        ((TextView) v.findViewById(R.id.eventoTitulo)).setText(titulo);
        ((ImageView) v.findViewById(R.id.eventoImagen)).setImageBitmap(Util.findOrCreateBy(getArguments().getString("imagen")));
        return v;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this.getActivity(), Evento.class);
        i.putExtra("img", getArguments().getString("imagen"));
        i.putExtra("titulo", getArguments().getString("titulo"));
        i.putExtra("fecha", getArguments().getString("fecha"));
        i.putExtra("detalle", getArguments().getString("detalle"));
        i.putExtra("telefono", getArguments().getString("telefono"));
        i.putExtra("email", getArguments().getString("email"));
        this.getActivity().startActivity(i);
    }
}
