package com.plasmadev.captiondad.carddashboard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class EventFragment extends Fragment {
    private String titulo, fecha, detalle;

    public EventFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);
        this.fecha = getArguments().getString("fecha");
        this.titulo = getArguments().getString("titulo");
        this.detalle = getArguments().getString("detalle");
        ((TextView) v.findViewById(R.id.eventoFecha)).setText(fecha);
        ((TextView) v.findViewById(R.id.eventoTitulo)).setText(titulo);
//        ((TextView) v.findViewById(R.id.eventoDetalle)).setText(detalle);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        v.setBackground(new BitmapDrawable(getBitmapFromURL(getArguments().getString("imagen"))));
        return v;
    }

    public Bitmap getBitmapFromURL(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
