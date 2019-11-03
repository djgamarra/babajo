package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class Museo extends AppCompatActivity {
    private TextToSpeech tts;
    private String detalle;
    private boolean reading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museo);
        this.tts = new TextToSpeech(this, null);
        tts.setLanguage(Locale.US);
        Intent extras = this.getIntent();
        this.detalle = extras.getStringExtra("detalle");
        String img = extras.getStringExtra("img");
        ImageView i = this.findViewById(R.id.eventoImg);
        i.setImageBitmap(Util.findOrCreateBy(img));
        ((TextView) findViewById(R.id.eventoTitulo)).setText(extras.getStringExtra("titulo"));
        ((TextView) findViewById(R.id.eventoFecha)).setText(extras.getStringExtra("fecha"));
        ((TextView) findViewById(R.id.eventoDetalle)).setText(this.detalle);
        ((TextView) findViewById(R.id.eventoContacto)).setText(extras.getStringExtra("contacto"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.tts.stop();
    }

    public void text_to_speech(View v) {
        if (this.reading) this.tts.stop();
        else this.tts.speak(this.detalle, TextToSpeech.QUEUE_ADD, null);
        this.reading = !this.reading;
    }
}
