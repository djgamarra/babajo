package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ZXingScannerView camera = new ZXingScannerView(this);
        setContentView(camera);
        camera.setResultHandler(this);
        camera.startCamera();
    }

    @Override
    public void handleResult(Result result) {


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
