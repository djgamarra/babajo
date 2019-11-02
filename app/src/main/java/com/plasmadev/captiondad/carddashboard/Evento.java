package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Evento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        Intent extras = this.getIntent();
        String img = extras.getStringExtra("img");
        ImageView i = this.findViewById(R.id.eventoImg);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        i.setImageBitmap(getBitmapFromURL(img));
        ((TextView) findViewById(R.id.eventoTitulo)).setText(extras.getStringExtra("titulo"));
        ((TextView) findViewById(R.id.eventoFecha)).setText(extras.getStringExtra("fecha"));
        ((TextView) findViewById(R.id.eventoDetalle)).setText(extras.getStringExtra("detalle"));
        ((TextView) findViewById(R.id.eventoTelefono)).setText(extras.getStringExtra("telefono"));
        ((TextView) findViewById(R.id.eventoEmail)).setText(extras.getStringExtra("email"));
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

    public void llamar(View v) {
        Intent extras = this.getIntent();
        String phone = extras.getStringExtra("telefono");
        if (phone != null) {
            Uri u = Uri.parse("tel:" + phone);
            Intent i = new Intent(Intent.ACTION_DIAL, u);
            this.startActivity(i);
        }
    }

    public void mail_to(View v) {
        Intent extras = this.getIntent();
        String email = extras.getStringExtra("email");
        if (email != null) {
            Uri u = Uri.parse("tel:" + email);
            Intent i = new Intent(Intent.CATEGORY_APP_EMAIL, u);
            this.startActivity(i);
        }
    }
}
