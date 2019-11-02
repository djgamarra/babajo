package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.firestore.DocumentSnapshot;

public class Historia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);
    }

    public void open_museo(View v) {
        Intent i = new Intent(this, Museo.class);
        DocumentSnapshot doc = FirebaseHolder.historias.get(1);

        i.putExtra("img", doc.getString("imagen"));
        i.putExtra("titulo", doc.getString("nombre"));
        i.putExtra("fecha", doc.getString("ubicacion"));
        i.putExtra("detalle", doc.getString("historia"));
        i.putExtra("contacto", doc.getString("contacto") == null ? "---" : doc.getString("contacto"));

        this.startActivity(i);
    }

    public void open_aduanas(View v) {
        Intent i = new Intent(this, Museo.class);
        DocumentSnapshot doc = FirebaseHolder.historias.get(0);

        i.putExtra("img", doc.getString("imagen"));
        i.putExtra("titulo", doc.getString("nombre"));
        i.putExtra("fecha", doc.getString("ubicacion"));
        i.putExtra("detalle", doc.getString("historia"));
        i.putExtra("contacto", doc.getString("contacto") == null ? "---" : doc.getString("contacto"));

        this.startActivity(i);
    }
}
